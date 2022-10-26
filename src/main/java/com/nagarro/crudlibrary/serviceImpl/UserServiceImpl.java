package com.nagarro.crudlibrary.serviceImpl;

import com.nagarro.crudlibrary.entities.Author;
import com.nagarro.crudlibrary.entities.User;
import com.nagarro.crudlibrary.repository.AuthorRepository;
import com.nagarro.crudlibrary.repository.UserRepository;
import com.nagarro.crudlibrary.service.AuthorService;
import com.nagarro.crudlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getAll() {
        return (List<User>) this.userRepository.findAll();
    }
}
