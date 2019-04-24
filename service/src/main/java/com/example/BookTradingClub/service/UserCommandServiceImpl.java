package com.example.BookTradingClub.service;

import com.example.BookTradingClub.data.entity.UserEntity;
import com.example.BookTradingClub.data.repository.UserJPAEntityRepository;
import com.example.BookTradingClub.service.domain.User;
import com.example.BookTradingClub.service.exception.InvalidUsernameException;
import com.example.BookTradingClub.service.exception.UsernameAlreadyExistsException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserCommandServiceImpl implements UserCommandService{

    @Autowired
    private UserJPAEntityRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerNewUser(String username, String password) {

        UserEntity userEntity = userRepository.findByName(username);
        if(userEntity != null){
            throw new UsernameAlreadyExistsException("Username already exists");
        }
        if(username.length() < 3) {
            throw new InvalidUsernameException("Username is invalid");
        }

        userEntity = new UserEntity();
        userEntity.setName(username);
        userEntity.setPassword(passwordEncoder.encode(password));

        userRepository.save(userEntity);

    }

    @Override
    public void updateUser(User user) {

    }
}
