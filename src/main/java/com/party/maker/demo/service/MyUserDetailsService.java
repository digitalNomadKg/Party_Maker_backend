package com.party.maker.demo.service;

import com.party.maker.demo.domain.User;
import com.party.maker.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException(username +"doesn't exist!");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),getGrantedAuthorities(user));
    }

    public Collection<GrantedAuthority> getGrantedAuthorities(User user) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(user.getRole().getRoleType().name().equals("ADMIN")){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if(user.getRole().getRoleType().name().equals("HOST")){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_HOST"));
        }
        if(user.getRole().getRoleType().name().equals("CLIENT")){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
        }
        return grantedAuthorities;
    }
}
