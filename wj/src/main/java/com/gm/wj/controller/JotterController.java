package com.gm.wj.controller;

import com.gm.wj.pojo.JotterArticle;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.service.JotterArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Evan
 * @date 2020/1/14 20:33
 */

@RestController
public class JotterController {
    @Autowired
    JotterArticleService jotterArticleService;

    @PostMapping("api/admin/content/article")
    public Result saveArticle(@RequestBody JotterArticle article) {
        return ResultFactory.buildSuccessResult("测试");
    }

    @GetMapping("/api/article")
    public Page listArticles() {
        return jotterArticleService.list(0, 10);
    }

}
