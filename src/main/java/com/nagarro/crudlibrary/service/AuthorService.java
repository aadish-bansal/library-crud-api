package com.nagarro.crudlibrary.service;

import com.nagarro.crudlibrary.entities.Author;

import java.util.List;

public interface AuthorService {

    public List<Author> getAll();

    public Author getById(int id);

    public void add(Author author);

    public void update(Author author,int id);

    public void delete(int id);

}
