package com.nagarro.crudlibrary.repository;

import com.nagarro.crudlibrary.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    public User findById(int id);
}
