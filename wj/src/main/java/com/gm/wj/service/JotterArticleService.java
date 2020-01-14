package com.gm.wj.service;

import com.gm.wj.dao.JotterArticleDAO;
import com.gm.wj.pojo.JotterArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Evan
 * @date 2020/1/14 21:00
 */

@Service
public class JotterArticleService {
    @Autowired
    JotterArticleDAO jotterArticleDAO;

}
