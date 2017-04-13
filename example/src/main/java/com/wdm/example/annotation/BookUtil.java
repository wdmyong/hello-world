package com.wdm.example.annotation;

import java.lang.reflect.Field;

public class BookUtil {

    public static void getBookInfo(Class<?> clazz) {
        String bookName = "书本名字：";
        String bookType = "书本类型：";
        String bookSeller = "经书商：";
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(BookName.class)) {
                BookName name = (BookName)field.getAnnotation(BookName.class);
                System.out.println(bookName + name.value());
            } else if (field.isAnnotationPresent(BookType.class)) {
                BookType type = (BookType)field.getAnnotation(BookType.class);
                System.out.println(bookType + type.bookType().toString());
            } else if (field.isAnnotationPresent(BookSeller.class)) {
                BookSeller seller = (BookSeller)field.getAnnotation(BookSeller.class);
                System.out.println(bookSeller + seller.id() + "\tname: " + seller.name() + 
                        "\tadress: " + seller.address());
            }
        }
    }
}
