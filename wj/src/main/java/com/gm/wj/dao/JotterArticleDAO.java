package com.gm.wj.dao;

import com.gm.wj.pojo.JotterArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Evan
 * @date 2020/1/14 20:40
 */

public interface JotterArticleDAO  extends JpaRepository<JotterArticle,Integer> {
    JotterArticle findById(int id);
}
