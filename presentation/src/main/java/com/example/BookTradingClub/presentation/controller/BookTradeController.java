package com.example.BookTradingClub.presentation.controller;

import com.example.BookTradingClub.presentation.dto.RequestCreatedDto;
import com.example.BookTradingClub.presentation.dto.RequestDecisionDto;
import com.example.BookTradingClub.presentation.dto.RequestToCreateDto;
import com.example.BookTradingClub.service.TradeService;
import com.example.BookTradingClub.service.domain.ExchangeState;
import com.example.BookTradingClub.service.domain.Request;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/exchanges")
public class BookTradeController {

    @Autowired
    private TradeService tradeService;

    @Autowired
    private ModelMapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    RequestCreatedDto makeExchangeRequest(@RequestBody RequestToCreateDto requestToCreateDto, Principal principal){

        Request request = mapper.map(requestToCreateDto, Request.class);
        Request newRequest = tradeService.requestTrade(principal.getName(), request);

        return mapper.map(newRequest, RequestCreatedDto.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pending")
    List<RequestCreatedDto> getPendingRequests() {
        List<Request> requests = tradeService.getTradesByState(ExchangeState.PENDING);

        Type requestsCreatedDtoListType = new TypeToken<List<RequestCreatedDto>>(){}.getType();

        return mapper.map(requests, requestsCreatedDtoListType);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accepted")
    List<RequestCreatedDto> getAcceptedRequests() {
        List<Request> requests = tradeService.getTradesByState(ExchangeState.ACCEPTED);

        Type requestsCreatedDtoListType = new TypeToken<List<RequestCreatedDto>>(){}.getType();

        return mapper.map(requests, requestsCreatedDtoListType);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rejected")
    List<RequestCreatedDto> getRejectedRequests() {
        List<Request> requests = tradeService.getTradesByState(ExchangeState.REJECTED);

        Type requestsCreatedDtoListType = new TypeToken<List<RequestCreatedDto>>(){}.getType();

        return mapper.map(requests, requestsCreatedDtoListType);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/accept")
    RequestCreatedDto acceptRequest(Principal principal, @RequestBody final RequestDecisionDto requestDecision) {

        Request request = mapper.map(requestDecision, Request.class);
        Request requestAccepted = tradeService.acceptTrade(principal.getName(), request);

        return mapper.map(requestAccepted, RequestCreatedDto.class);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reject")
    RequestCreatedDto rejectRequest(Principal principal, @RequestBody final RequestDecisionDto requestDecision) {

        Request request = mapper.map(requestDecision, Request.class);
        Request requestRejected = tradeService.rejectTrade(principal.getName(), request);

        return mapper.map(requestRejected, RequestCreatedDto.class);
    }

}
