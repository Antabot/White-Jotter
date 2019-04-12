package com.gm.wj.controller;

import com.gm.wj.pojo.Book;
import com.gm.wj.pojo.Search;
import com.gm.wj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        System.out.println(book.getCategory());
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @PostMapping("/api/search")
    public List<Book> searchResult(@RequestBody Search s) throws Exception {
        if ("".equals(s.getKeywords())) {
            return bookService.list();
        } else {
            return bookService.Search(s.getKeywords());
        }
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid")int cid) throws Exception {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @PostMapping("api/covers")
    public String coversUpload(HttpServletRequest request) throws Exception {
        return "aha";
    }

}
