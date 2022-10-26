package com.nagarro.crudlibrary.service;

import com.nagarro.crudlibrary.entities.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAll();

    public Book getById(int id);

    public void add(Book book);

    public void update(Book book,int id);

    public void delete(int id);

}
