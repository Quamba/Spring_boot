package com.example.tp2.service;

import com.example.tp2.modele.Users;
import com.example.tp2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Users users = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not present"));
        return users;
    }
    public void createUser(UserDetails user) {
        userRepository.save((Users) user);
    }
}