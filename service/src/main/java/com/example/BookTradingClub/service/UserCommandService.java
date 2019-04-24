package com.example.BookTradingClub.service;

import com.example.BookTradingClub.service.domain.User;

public interface UserCommandService {

    void registerNewUser(final String userName, final String password);

    void updateUser(final User user);

    User findUserByName(final String name);
}
