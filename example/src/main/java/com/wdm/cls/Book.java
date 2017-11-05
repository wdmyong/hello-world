package com.wdm.cls;

/**
 * Created by wdmyong on 2017/10/14.
 */
public class Book {

    private String name;
    private String edition;

    public Book(String name, String edition) {
        this.name = name;
        this.edition = edition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", edition='" + edition + '\'' +
                '}';
    }
}
