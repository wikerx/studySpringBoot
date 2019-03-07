package com.scott.entity;

/**
 * @CLASSNAME :Book
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/7 0007  16:41
 * @Version :V1.0
 * @Status : 编写
 **/
public class Book {
    private String isbn;
    private String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

//    get set

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
