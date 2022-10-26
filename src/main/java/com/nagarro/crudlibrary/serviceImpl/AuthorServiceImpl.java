package com.nagarro.crudlibrary.serviceImpl;

import com.nagarro.crudlibrary.entities.Author;
import com.nagarro.crudlibrary.repository.AuthorRepository;
import com.nagarro.crudlibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return (List<Author>) this.authorRepository.findAll();
    }

    @Override
    public Author getById(int id) {
            Author author=null;
            try {
                author = this.authorRepository.findById(id);
            }
             catch (Exception e){
                e.printStackTrace();
             }

        return author;
    }

    @Override
    public void add(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public void update(Author author,int id) {
        author.setId(id);
        this.authorRepository.save(author);
    }

    @Override
    public void delete(int id) {
        this.authorRepository.deleteById(id);
    }


}
