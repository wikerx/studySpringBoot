package com.scott.service;

import com.scott.entity.Book;

/**
 * Created by Administrator on 2019/3/7 0007.
 */
public interface BookService {

    Book getByIsbn(String isbn);

}
