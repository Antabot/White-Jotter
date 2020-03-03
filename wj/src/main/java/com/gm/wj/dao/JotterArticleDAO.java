package com.gm.wj.dao;

import com.gm.wj.entity.JotterArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Evan
 * @date 2020/1/14 20:40
 */
public interface JotterArticleDAO  extends JpaRepository<JotterArticle,Integer> {
    JotterArticle findById(int id);
}
