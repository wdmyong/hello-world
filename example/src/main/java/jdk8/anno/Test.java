package jdk8.anno;

import java.time.LocalDate;

import javax.annotation.Nonnull;

import com.wdm.example.model.Book;

/**
 * Created by wdmyong on 2017/10/18.
 */
public class Test {
    public static void main(String[] args) {
        fun(new Book(1, "ksks", LocalDate.now()));
        fun(null); // 编译不过，会作Nonnull检查
    }

    public static void fun(@Nonnull Book book) {
        System.out.println(book.getName());
    }
}
