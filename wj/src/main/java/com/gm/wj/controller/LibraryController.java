package com.gm.wj.controller;

import com.gm.wj.entity.Book;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.service.BookService;
import com.gm.wj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Library controller.
 *
 * @author Evan
 * @date 2019/4
 */
@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> listBooks() {
        return bookService.list();
    }

    @PostMapping("/api/admin/content/books")
    public Result addOrUpdateBooks(@RequestBody Book book) {
        if(bookService.addOrUpdate(book)) {
            return ResultFactory.buildSuccessResult("修改成功");
        }
        return ResultFactory.buildFailResult("参数错误，修改失败");
    }

    @PostMapping("/api/admin/content/books/delete")
    public Result deleteBook(@RequestBody Book book) {
        if (bookService.deleteById(book.getId())) {
            return ResultFactory.buildSuccessResult("删除成功");
        }
        return ResultFactory.buildFailResult("参数错误，删除失败");
    }

    @GetMapping("/api/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords) {
        if ("".equals(keywords)) {
            return bookService.list();
        } else {
            return bookService.Search(keywords);
        }
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return listBooks();
        }
    }

    @PostMapping("/api/admin/content/books/covers")
    public String coversUpload(MultipartFile file) {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
