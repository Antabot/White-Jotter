package com.gm.wj.dao;

import com.gm.wj.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book,Integer> {

}
