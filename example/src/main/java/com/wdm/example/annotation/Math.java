package com.wdm.example.annotation;

import com.wdm.example.annotation.BookType.Type;

public class Math {

    @BookName("数学")
    private String bookName;

    @BookType(bookType = Type.BIG)
    private int bookType;

    @BookSeller(id=1, name="我省教育厅", address="A街道B门牌号")
    private String appleProvider;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public void showName() {
        System.out.println("书本的名字是：数学");
    }
}
