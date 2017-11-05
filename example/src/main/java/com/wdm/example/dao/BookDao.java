package com.wdm.example.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.wdm.example.model.Book;

/**
 * Created by wdmyong on 2017/10/16.
 */
@Repository
public class BookDao {

    private static AtomicInteger ID_GENERATE = new AtomicInteger();

    public Book getById(int id) {
        System.out.println("visitor db for id:\t" + id);
        return new Book(id, "123", LocalDate.now());
    }

    public Book getByName(String name) {
        System.out.println("visitor db for id:\t" + name);
        return new Book(ID_GENERATE.getAndIncrement(), name, LocalDate.now());
    }
}
