package com.iflytek.vuedemo.dao;

import com.iflytek.vuedemo.pojo.Hospital;
import com.iflytek.vuedemo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    List<User> findAllByUsernameLike(String username);
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);


}
