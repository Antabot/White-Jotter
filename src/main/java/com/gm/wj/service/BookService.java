package com.gm.wj.service;

import com.gm.wj.config.RedisConfig;
import com.gm.wj.dao.BookDAO;
import com.gm.wj.entity.Book;
import com.gm.wj.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Evan
 * @date 2019/4
 */
@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;
    @Autowired
    CategoryService categoryService;

//    @Cacheable(value = RedisConfig.REDIS_KEY_DATABASE)
    public List<Book> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookDAO.findAll(sort);
    }

    public void addOrUpdate(Book book) {
        bookDAO.save(book);
    }

    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }

    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }

    public List<Book> Search(String keywords) {
        return bookDAO.findAllByTitleLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
    }
}
