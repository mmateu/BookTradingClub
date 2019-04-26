package com.example.BookTradingClub.service;

import com.example.BookTradingClub.service.domain.User;

public interface UserCommandService {

    void registerNewUser(final String userName, final String password);

    User updateUser(final String username, final User user);

    User findUserByName(final String name);
}
