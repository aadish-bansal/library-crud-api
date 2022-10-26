package com.nagarro.crudlibrary.controller;

import com.nagarro.crudlibrary.entities.User;
import com.nagarro.crudlibrary.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll(){
        List<User> all = this.userService.getAll();

        if (all.size() == 0) {
            return ResponseEntity.status(404).body(null);
        }
        return  ResponseEntity.status(200).body(all);
    }

}

