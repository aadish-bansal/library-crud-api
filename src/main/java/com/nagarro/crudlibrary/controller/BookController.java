package com.nagarro.crudlibrary.controller;

import com.nagarro.crudlibrary.entities.Book;
import com.nagarro.crudlibrary.serviceImpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookServiceImpl bookService;


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> allBook = this.bookService.getAll();
        if (allBook.size() == 0) {
            return ResponseEntity.status(404).body(null);
        }
        return  ResponseEntity.status(200).body(allBook);
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getByid(@PathVariable("id") int id){
        Book byId = null;
        try {
            byId = this.bookService.getById(id);
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
        if (byId == null) {
            return ResponseEntity.status(404).body(byId);
        }
        return  ResponseEntity.status(200).body(byId );

    }

    @PostMapping("/books")
    public ResponseEntity<Void>  add(@RequestBody Book book){
        try{
            this.bookService.add(book);
        }
        catch (Exception e) {
            System.out.println("Exception occurred");
            return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.status(201).body(null);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        try{
            this.bookService.delete(id);
        }
        catch (Exception e) {
            System.out.println("Exception occurred");
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(204).body(null);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Void> update(@RequestBody Book book, @PathVariable("id") int id ){
        try{
            this.bookService.update(book,id);
        }
        catch (Exception e) {
            System.out.println("Exception occurred");
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(null);
    }

}
