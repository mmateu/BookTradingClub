package com.example.BookTradingClub.service;

import com.example.BookTradingClub.data.entity.BookEntity;
import com.example.BookTradingClub.data.entity.UserBookEntity;
import com.example.BookTradingClub.data.entity.UserEntity;
import com.example.BookTradingClub.data.repository.BookJPAEntityRepository;
import com.example.BookTradingClub.data.repository.UserBookJPAEntityRepository;
import com.example.BookTradingClub.data.repository.UserJPAEntityRepository;
import com.example.BookTradingClub.service.domain.Book;
import com.example.BookTradingClub.service.domain.User;
import com.example.BookTradingClub.service.domain.UserBook;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookJPAEntityRepository bookDataEntityRepository;

    @Autowired
    private UserBookJPAEntityRepository userBookJPAEntityRepository;

    @Autowired
    private UserJPAEntityRepository userJPAEntityRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public Book book(int id) {

        BookEntity bookEntity = bookDataEntityRepository.getEntity(id);

        return mapper.map(bookEntity, Book.class);
    }

    @Override
    public List<Book> books() {

        List<BookEntity> entities = bookDataEntityRepository.findEntities();

        Type bookListType = new TypeToken<List<Book>>(){}.getType();

        return mapper.map(entities, bookListType);
    }

    @Override
    @Transactional
    public UserBook saveBookForUser(Book book, User user) {

        UserBook userBook = new UserBook();

        BookEntity bookEntity = bookDataEntityRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor());
        if( bookEntity == null) {
            bookEntity = mapper.map(book, BookEntity.class);
            bookEntity = bookDataEntityRepository.saveEntity(bookEntity);
        }

        UserEntity userEntity = userJPAEntityRepository.findByName(user.getName());
        UserBookEntity userBookEntity = userBookJPAEntityRepository.findByBookAndUser(bookEntity, userEntity);
        if( userBookEntity == null ) {
            userBookEntity = new UserBookEntity();
            userBookEntity.setCount(1);
            userBookEntity.setBook(bookEntity);
            userBookEntity.setUser(userEntity);
        } else {
            userBookEntity.setCount(userBookEntity.getCount()+1);
        }

        userBookEntity = userBookJPAEntityRepository.save(userBookEntity);


        return mapper.map(userBookEntity, UserBook.class);

    }

    @Override
    public List<UserBook> usersBooks() {

        List<UserBookEntity> userBookEntities = userBookJPAEntityRepository.findEntities()
                .stream().filter(i -> i.getCount() > 0)
                .collect(Collectors.toList());

        Type userBookListType = new TypeToken<List<UserBook>>(){}.getType();

        return mapper.map(userBookEntities, userBookListType);
    }
}
