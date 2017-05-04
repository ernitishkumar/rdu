package com.rdu.services;

import com.rdu.beans.User;
import com.rdu.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by NITISH on 04-05-2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getByUsername(String username){
        System.out.println("Getting user by username: "+username);
        return userRepository.findByUsername(username);
    }

    public User getByUsernameAndPassword(String username,String password){
        System.out.println("Getting user by username: "+username);
        return userRepository.findByUsernameAndPassword(username,password);
    }
}
