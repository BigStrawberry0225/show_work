package com.codercm.bk.dao;

import com.codercm.bk.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<User, Integer> {
    //DAO  data access objects 数据访问对象
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);
}
