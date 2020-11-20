package com.codercm.bk.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codercm.bk.pojo.Book;
import com.codercm.bk.pojo.Category;

import java.util.List;

public interface BookDAO extends JpaRepository<Book,Integer> {
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}


