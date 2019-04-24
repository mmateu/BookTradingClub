package com.example.BookTradingClub.presentation.security;

import com.example.BookTradingClub.service.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCommandService userCommandService;

    @Override
    public UserDetails loadUserByUsername(String username) {

        return new UserPrincipal(userCommandService.findUserByName(username));

    }
}
