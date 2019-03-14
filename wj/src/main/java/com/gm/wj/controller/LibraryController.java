package com.gm.wj.controller;

import com.gm.wj.pojo.Book;
import com.gm.wj.result.Result;
import com.gm.wj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping(value="/api/libraryindex")
    public List<Book> list() throws Exception {
        return bookService.list();
    }
}
