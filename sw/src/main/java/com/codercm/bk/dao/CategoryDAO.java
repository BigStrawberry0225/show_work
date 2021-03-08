package com.codercm.bk.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codercm.bk.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}

