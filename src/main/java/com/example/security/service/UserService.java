package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.security.models.Users;
import com.example.security.repo.UsersRepo;

@Service
public class UserService {
    @Autowired
    private JWTService jwtService;

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Boolean isUserPresent(Users users){
        Users presntuser = usersRepo.findByUsername(users.getUsername());
        if(presntuser != null){
            return true;
        }
        return false;
    }

    public Users saveUser(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return usersRepo.save(user);
    }

    public String verify(Users users) {
        System.out.println(users.getUsername());
        System.out.println(users.getPassword());
        Authentication authentication =  authenticationManager
                            .authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
        
        if(authentication.isAuthenticated()){   
            return jwtService.generateToken(users.getUsername());
        }
        return "Invalid Credentials";
    }
}
