package com.iflytek.vuedemo.service;

import com.iflytek.vuedemo.dao.UserDao;
import com.iflytek.vuedemo.pojo.Hospital;
import com.iflytek.vuedemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDAO;

    public List<User> list(){
        return userDAO.findAll();
    }
    public User insert(User user){
        return userDAO.save( user);
    }
    public List<User> query(String username){
        return userDAO.findAllByUsernameLike(username);

    }
    public void delete(Integer id){
        userDAO.deleteById(id);
    }
    public User insertorupdate(User user){
        return userDAO.save(user);
    }
    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

}
