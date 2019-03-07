package com.scott.service.Impl;

import com.scott.entity.Book;
import com.scott.service.BookService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @CLASSNAME :BookServiceImpl
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/7 0007  16:43
 * @Version :V1.0
 * @Status : 编写
 **/
@Component
public class BookServiceImpl implements BookService{

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
