package com.nagarro.crudlibrary.repository;

import com.nagarro.crudlibrary.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {

    public Author findById(int id);
}
