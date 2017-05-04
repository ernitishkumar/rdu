package com.rdu.controllers;

import com.rdu.beans.User;
import com.rdu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NITISH on 04-05-2017.
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public ResponseEntity<User> login(@RequestBody User user){
        System.out.println("Logging user : "+user);
        User existingUser = userService.getByUsernameAndPassword(user.getUsername(),user.getPassword());
        ResponseEntity<User> responseEntity = null;
        if(existingUser != null){
            System.out.println("Authenticated user");
            existingUser.setPassword("");
            return responseEntity = new ResponseEntity<User>(existingUser, HttpStatus.OK);
        }else{
            System.out.println("Login failed");
            return responseEntity = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
