package com.example.BookTradingClub.service;

import com.example.BookTradingClub.data.entity.UserEntity;
import com.example.BookTradingClub.data.repository.UserJPAEntityRepository;
import com.example.BookTradingClub.service.domain.User;
import com.example.BookTradingClub.service.exception.InvalidUsernameException;
import com.example.BookTradingClub.service.exception.UserNotFoundException;
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
    public User updateUser(String username, User userPatch) {
        User existingUser = this.findUserByName(username);
        userPatch.setId(existingUser.getId());
        userPatch.setName(username);


        if(! existingUser.equals(userPatch)){
            if( userPatch.getCity() != null && !userPatch.getCity().equals(existingUser.getCity())){
                existingUser.setCity(userPatch.getCity());
            }
            if( userPatch.getCountry() != null && !userPatch.getCountry().equals(existingUser.getCountry())){
                existingUser.setCountry(userPatch.getCountry());
            }
            if( userPatch.getFirstName() != null && !userPatch.getFirstName().equals(existingUser.getFirstName())){
                existingUser.setFirstName(userPatch.getFirstName());
            }
            if( userPatch.getLastName() != null && !userPatch.getLastName().equals(existingUser.getLastName())){
                existingUser.setLastName(userPatch.getLastName());
            }
        }
        UserEntity updatedEntity =  userRepository.saveEntity(mapper.map(existingUser, UserEntity.class));
        return mapper.map(updatedEntity, User.class);

    }

    @Override
    public User findUserByName(String name) {

        UserEntity userEntity = userRepository.findByName(name);

        if( userEntity == null ) {
            throw new UserNotFoundException("User with name "+name+" was not found");
        }

        return mapper.map(userEntity, User.class);

    }
}
