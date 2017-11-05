package com.wdm.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wdm.example.model.Book;
import com.wdm.example.service.BookService;

/**
 * Created by wdmyong on 2017/10/16.
 */
@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/byName/{name}")
    public Book getByName(@PathVariable("name") String name) {
        return bookService.getByNameWithCallable(name);
    }

    @RequestMapping("/byId/{id}")
    public Book getByName(@PathVariable("id") int id) {
        return bookService.getById(id);
    }
}
