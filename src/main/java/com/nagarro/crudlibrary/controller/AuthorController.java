package com.nagarro.crudlibrary.controller;

import com.nagarro.crudlibrary.entities.Author;
import com.nagarro.crudlibrary.serviceImpl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorService;


    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAll() {
        List<Author> allAuthor = this.authorService.getAll();
        if (allAuthor.size() == 0) {
            return ResponseEntity.status(404).body(null);
        }
        return  ResponseEntity.status(200).body(allAuthor);

    }
    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getByid(@PathVariable("id") int id) {
        Author byId = null;
        try {
            byId = this.authorService.getById(id);
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
        if (byId == null) {
            return ResponseEntity.status(404).body(byId);
        }
        return  ResponseEntity.status(200).body(byId );


    }

    @PostMapping("/authors")
    public ResponseEntity<Void> add(@RequestBody Author author){
       try{
           this.authorService.add(author);
       }
        catch (Exception e) {
            System.out.println("Exception occurred");
            return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.status(201).body(null);

    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        try{
            this.authorService.delete(id);
        }
        catch (Exception e) {
            System.out.println("Exception occurred");
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(204).body(null);
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<Void> update(@RequestBody Author author, @PathVariable("id") int id ){
        try{
            this.authorService.update(author,id);

        }
        catch (Exception e) {
            System.out.println("Exception occurred");
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(null);
    }

}

