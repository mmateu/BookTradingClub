package com.example.BookTradingClub.presentation.controller;

import com.example.BookTradingClub.presentation.dto.RegistrationDto;
import com.example.BookTradingClub.service.UserCommandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserCommandController {

    @Autowired
    UserCommandService userCommandService;

    @Autowired
    ModelMapper mapper;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void registerUser(@RequestBody final RegistrationDto registrationDto){

        userCommandService.registerNewUser(registrationDto.getName(), registrationDto.getPassword());


    }


}
