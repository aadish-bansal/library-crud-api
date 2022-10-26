package com.nagarro.crudlibrary.serviceImpl;

import com.nagarro.crudlibrary.entities.Book;
import com.nagarro.crudlibrary.repository.BookRepository;
import com.nagarro.crudlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return (List<Book>) this.bookRepository.findAll();
    }
    @Override
    public Book getById(int id) {
        Book book=null;
            try {
                 book = this.bookRepository.findById(id);
            }
             catch (Exception e){
                e.printStackTrace();
             }

        return book;
    }

    @Override
    public void add(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public void update(Book book,int id) {
        book.setId(id);
        this.bookRepository.save(book);

    }

    @Override
    public void delete(int id) {
        this.bookRepository.deleteById(id);
    }


}
