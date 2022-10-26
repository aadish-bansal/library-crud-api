package com.nagarro.crudlibrary;

import com.nagarro.crudlibrary.serviceImpl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudlibraryApplication {
	public static void main(String[] args) {
			SpringApplication.run(CrudlibraryApplication.class, args);
	}

}
