package com.wdm.example.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.wdm.example.dao.BookDao;
import com.wdm.example.model.Book;

/**
 * Created by wdmyong on 2017/10/16.
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    private LoadingCache<String, Book> CACHE = CacheBuilder.newBuilder()
            .maximumSize(10)
            .refreshAfterWrite(10, TimeUnit.SECONDS)
            .expireAfterAccess(60, TimeUnit.SECONDS)
            .build(
                    new CacheLoader<String, Book>() {
                        @Override
                        public Book load(String name) throws Exception {
                            Book book = bookDao.getByName(name);
                            System.out.println("c:\t" + LocalTime.now().getSecond() + book);
                            return book;
                        }
                    }
            );

    public Book getById(int id) {
        return bookDao.getById(id);
    }

    public Book getByName(String name) {
        return CACHE.getUnchecked(name);
    }

    public Book getByNameWithCallable(String name) {
        Book result = null;
        try {
            result = CACHE.get(name, () -> {
                Book book = bookDao.getByName(name);
                System.out.println("a:\t" + LocalTime.now().getSecond() + book);
                try {
                    Thread.sleep(5000);
                } catch (Exception ex) {

                }
                return book;
            });
            System.out.println("b:\t" + LocalTime.now().getSecond() + result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
}
