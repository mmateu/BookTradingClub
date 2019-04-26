package com.example.BookTradingClub.presentation.controller;

import com.example.BookTradingClub.presentation.dto.RegistrationDto;
import com.example.BookTradingClub.presentation.dto.UpdateUserDto;
import com.example.BookTradingClub.presentation.dto.UserDto;
import com.example.BookTradingClub.service.UserCommandService;
import com.example.BookTradingClub.service.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public UserDto getCurrentUser(Principal principal){
        User user = userCommandService.findUserByName(principal.getName()) ;

        return  mapper.map(user, UserDto.class);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public UserDto updateUser(Principal principal, @RequestBody final UpdateUserDto updateUserDto) {

        mapper.getConfiguration().setAmbiguityIgnored(true);
        User updateUser = mapper.map(updateUserDto, User.class);
        User updatedUser = userCommandService.updateUser(principal.getName(), updateUser);

        return mapper.map(updatedUser, UserDto.class);

    }





}
