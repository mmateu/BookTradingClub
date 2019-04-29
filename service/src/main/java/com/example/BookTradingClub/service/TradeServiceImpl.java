package com.example.BookTradingClub.service;

import com.example.BookTradingClub.data.entity.RequestEntity;
import com.example.BookTradingClub.data.entity.UserBookEntity;
import com.example.BookTradingClub.data.repository.RequestJPAEntityRepository;
import com.example.BookTradingClub.data.repository.UserBookJPAEntityRepository;
import com.example.BookTradingClub.data.repository.UserJPAEntityRepository;
import com.example.BookTradingClub.service.domain.*;
import com.example.BookTradingClub.service.exception.AcceptDecisionAlreadyTakenException;
import com.example.BookTradingClub.service.exception.BookHasOtherOwnerException;
import com.example.BookTradingClub.service.exception.BookUnavailableException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private UserJPAEntityRepository userRepository;

    @Autowired
    private UserBookJPAEntityRepository userBookRepository;

    @Autowired
    private RequestJPAEntityRepository requestRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserCommandService userCommandService;

    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public Request requestTrade(String requestingUser, Request newRequest) {

        UserBookEntity offeredBookEntity = userBookRepository.getEntity(newRequest.getOfferedBook().getId());
        UserBook offeredBook = mapper.map(offeredBookEntity, UserBook.class);

        UserBookEntity wantedBookEntity = userBookRepository.getEntity(newRequest.getWantedBook().getId());
        UserBook wantedBook = mapper.map(wantedBookEntity, UserBook.class);

        if(! offeredBook.belongsToUserWithGivenUsername(requestingUser)) {
            throw new BookHasOtherOwnerException(
                    offeredBook.getBook().getTitle(),
                    offeredBook.getUser().getName(),
                    requestingUser);
        }
        if(! (offeredBook.availableToExchange() &&  wantedBook.availableToExchange())){
            throw new BookUnavailableException("At least one of requested books is not available to trade. ");
        }

        Request createdRequest = new Request();
        createdRequest.setOfferedBook(offeredBook);
        createdRequest.setWantedBook(wantedBook);
        createdRequest.setRequestTimestamp(new Timestamp(Calendar.getInstance().getTime().getTime()));
        createdRequest.setExchangeState(ExchangeState.PENDING);

        RequestEntity requestEntity = requestRepository.save(mapper.map(createdRequest, RequestEntity.class));

        return mapper.map(requestEntity, Request.class);
    }

    @Override
    @Transactional
    public Request acceptTrade(String requestedUser, Request request) {

       Request requestToAccept = this.getRequestById(request.getId());

        if( !requestToAccept.getWantedBook().getUser().getName().equals(requestedUser) ) {
            throw new BookHasOtherOwnerException("The offer was made to somebody's else book.");
        }

        if( requestToAccept.getExchangeState() != ExchangeState.PENDING) {
            throw new AcceptDecisionAlreadyTakenException("The accept decision has already been taken. ");
        }

        requestToAccept.setAcceptDecisionTimestamp(new Timestamp(Calendar.getInstance().getTime().getTime()));
        requestToAccept.setExchangeState(ExchangeState.ACCEPTED);

        UserBook offered = requestToAccept.getOfferedBook();
        UserBook wanted = requestToAccept.getWantedBook();

        this.decrementUserBookCountAfterSuccessfulTrade(offered);
        this.decrementUserBookCountAfterSuccessfulTrade(wanted);

        this.saveTradedUserBookForSecondUser(offered, wanted);
        this.saveTradedUserBookForSecondUser(wanted, offered);

        RequestEntity requestEntity = requestRepository.saveEntity(mapper.map(requestToAccept,RequestEntity.class));

        return mapper.map(requestEntity, Request.class);
    }

    @Override
    @Transactional
    public Request rejectTrade(String requestedUser, Request request) {
        Request requestToReject = this.getRequestById(request.getId());

        if( !requestToReject.getWantedBook().getUser().getName().equals(requestedUser) ) {
            throw new BookHasOtherOwnerException("The offer was made to somebody's else book.");
        }

        if( requestToReject.getExchangeState() != ExchangeState.PENDING) {
            throw new AcceptDecisionAlreadyTakenException("The accept decision has already been taken. ");
        }

        requestToReject.setAcceptDecisionTimestamp(new Timestamp(Calendar.getInstance().getTime().getTime()));
        requestToReject.setExchangeState(ExchangeState.REJECTED);

        RequestEntity requestEntity = requestRepository.saveEntity(mapper.map(requestToReject,RequestEntity.class));

        return mapper.map(requestEntity, Request.class);
    }

    @Override
    public List<Request> getTradesByState(ExchangeState state) {
        List<RequestEntity> requestEntities = requestRepository.findEntities();

        Type requestEntityListType = new TypeToken<List<Request>>(){}.getType();

        List<Request> requests = mapper.map(requestEntities, requestEntityListType);

        return requests.stream().
                filter(request -> request.getExchangeState() == state).
                collect(Collectors.toList());
    }

    Request getRequestById(int id) {
        RequestEntity requestToAcceptEntity = requestRepository.getEntity(id);
        if( requestToAcceptEntity == null ) {
            throw new IllegalStateException();
        }
        return mapper.map(requestToAcceptEntity, Request.class);
    }

    private void decrementUserBookCountAfterSuccessfulTrade(UserBook userBook) {
        userBook.decrementCount();
        UserBookEntity userBookEntity = mapper.map(userBook, UserBookEntity.class);
        userBookRepository.saveEntity(userBookEntity);
    }

    private void saveTradedUserBookForSecondUser(UserBook userBook1, UserBook userBook2) {
        Book book = userBook1.getBook();
        User user = userCommandService.findUserByName(userBook2.getUser().getName());
        bookService.saveBookForUser(book, user);

    }
}
