package com.gm.wj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gm.wj.entity.Category;

/**
 * @author Evan
 * @date 2019/4
 */
public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
