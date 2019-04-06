package com.gm.wj.dao;

import com.gm.wj.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDAO extends JpaRepository<Book,Integer> {
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
