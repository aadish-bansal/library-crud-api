package com.nagarro.crudlibrary.entities;


import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
    @Id
    @Column(name = "code")
    private Integer id;

    @Column(name="name")
    private String name;
    @ManyToOne
    private Author author;

    @Column(name = "Added_0n")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", date='" + date + '\'' +
                '}';
    }
}
