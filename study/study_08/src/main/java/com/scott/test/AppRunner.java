package com.scott.test;
import com.scott.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @CLASSNAME :AppRunner
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/7 0007  16:44
 * @Version :V1.0
 * @Status : 编写
 **/
@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookService bookService;

    public AppRunner(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(".... Fetching books");
        logger.info("isbn-1234 -->" + bookService.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookService.getByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookService.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookService.getByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookService.getByIsbn("isbn-1234"));
        logger.info("isbn-1234 -->" + bookService.getByIsbn("isbn-1234"));
    }

}
