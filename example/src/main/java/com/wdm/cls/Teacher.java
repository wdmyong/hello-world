package com.wdm.cls;

/**
 * Created by wdmyong on 2017/10/14.
 */
public class Teacher {

    private User user;
    private Book book;
    private String school;
    private int level;
    private Integer num;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "user=" + user +
                ", book=" + book +
                ", school='" + school + '\'' +
                ", level=" + level +
                ", num=" + num +
                '}';
    }
}
