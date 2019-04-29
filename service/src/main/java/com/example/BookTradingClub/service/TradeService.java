package com.example.BookTradingClub.service;

import com.example.BookTradingClub.service.domain.ExchangeState;
import com.example.BookTradingClub.service.domain.Request;

import java.util.List;

public interface TradeService {

        Request requestTrade(String requestingUser, Request request) ;

        Request acceptTrade(String requestedUser, Request request);

        Request rejectTrade(String requestedUser, Request request);

        List<Request> getTradesByState(ExchangeState state);


}
