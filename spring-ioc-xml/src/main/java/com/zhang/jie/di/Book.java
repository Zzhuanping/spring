package com.zhang.jie.di;

public class Book {
    private String name;
    private String author;
    private String other;

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        System.out.println("有参构造");
    }

    public Book() {
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", other=" + other +
                '}';
    }
}
