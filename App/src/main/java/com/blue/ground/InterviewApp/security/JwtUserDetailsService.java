package com.blue.ground.InterviewApp.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepositoryImpl usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<com.blue.ground.InterviewApp.security.User> users = usersRepository.findAll();
        com.blue.ground.InterviewApp.security.User validateUser =
                new com.blue.ground.InterviewApp.security.User();

        for (com.blue.ground.InterviewApp.security.User user : users) {
            if (username.equals(user.getUsername())) {
                validateUser.setUsername(user.getUsername());
                validateUser.setPassword(user.getPassword());
            } else {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
        }
        return new User(validateUser.getUsername(), validateUser.getPassword(),
                new ArrayList<>());
    }
}