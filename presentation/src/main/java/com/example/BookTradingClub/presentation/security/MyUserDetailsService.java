package com.example.BookTradingClub.presentation.security;

import com.example.BookTradingClub.data.entity.UserEntity;
import com.example.BookTradingClub.data.repository.UserJPAEntityRepository;
import com.example.BookTradingClub.service.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserJPAEntityRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByName(username);
        if( userEntity == null ){
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(mapper.map(userEntity, User.class));

    }
}
