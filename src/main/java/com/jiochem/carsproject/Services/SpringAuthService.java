package com.jiochem.carsproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.jiochem.carsproject.Models.User;
import com.jiochem.carsproject.Models.Role;
import com.jiochem.carsproject.Repositories.UserRepository;


import java.util.ArrayList;
import java.util.List;

    @Service
    public class SpringAuthService implements UserDetailsService {

        @Autowired
        private UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            User user = userRepository.findByEmail(email);

            if(user == null){
                throw new UsernameNotFoundException("Invalid username or password");
            }

            List<GrantedAuthority> roles = new ArrayList<>();

            for (Role role: user.getRoles()) {
                SimpleGrantedAuthority authRole = new SimpleGrantedAuthority(role.getRoleName());
                roles.add(authRole);
            }

            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), roles);

        }
    }


