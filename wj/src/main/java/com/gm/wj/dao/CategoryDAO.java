package com.gm.wj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gm.wj.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
