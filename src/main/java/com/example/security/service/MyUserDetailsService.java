package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.models.UserPrincipal;
import com.example.security.models.Users;
import com.example.security.repo.UsersRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
    
    @Autowired
    private UsersRepo usersRepo;

    // public MyUserDetailsService(UsersRepo usersRepo){
    //     this.usersRepo = usersRepo;
    // }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepo.findByUsername(username);
        if (user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println(user);
        return new UserPrincipal(user);
    }
    

}
