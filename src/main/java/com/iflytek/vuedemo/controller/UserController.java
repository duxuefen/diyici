package com.iflytek.vuedemo.controller;
import com.iflytek.vuedemo.pojo.Page;
import com.iflytek.vuedemo.pojo.User;
import com.iflytek.vuedemo.result.Result;
import com.iflytek.vuedemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @RequestMapping("/api/user")
    public Result query() {
        List<User> list = userService.list();

        Page page = new Page();
        page.setData(list);
        return Result.SUCCESS(page);
    }

    @DeleteMapping("/api/deluser/{id}")
    public Result delete(@PathVariable Integer id) {
        User user = new User();
        userService.delete(id);
        return Result.SUCCESS("删除成功");
    }

    @PostMapping("/api/user/insert")
    public Result add(@RequestBody User user) {

        userService.insert(user);
        return Result.SUCCESS("添加成功");

    }

    @GetMapping("/api/searchUser")
    public Result searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return query();
        } else {
            List<User> list = userService.query(keywords);
            System.out.println(list);
            Page page = new Page();
            page.setData(list);
            return Result.SUCCESS(page);
        }
    }

//    @RequestMapping("")
//    public Result users(String username){
//
//
//        if(username==""){
//            List<User> list  = userService.list();
//
//            Page page = new Page();
//            page.setData(list);
//            return Result.SUCCESS(page);
//        }
//        else{
////            User user=new User();
//////            user.setUsername(username);
//            List<User> list =  userService.query(username);
//            Page page = new Page();
//            page.setData(list);
//            System.out.println(Result.SUCCESS(page));
//
//            return Result.SUCCESS(page);
//
//        }
//
//    }
//
//    @PostMapping("/add")
//    public Result add(@RequestBody User login){
//        return Result.SUCCESS(userService.add(login));
//    }
//
//    @PutMapping("/update")
//    public Result update(@RequestBody User login){
//        return Result.SUCCESS(userService.update(login));
//    }
//
//    @DeleteMapping("/delete/{userid}")
//    public Result delete(@PathVariable Integer userid){
//        Login login = new Login();
//        login.setUserid(userid);
//        return Result.SUCCESS(userService.delete(login));
//    }
//    @PutMapping("/status/{userid}/{status}")
//    public Result state(@PathVariable Integer userid, @PathVariable Boolean status) {
//        int status2 = status ? 1 : 0;
//        Login login = new Login();
//        login.setUserid(userid);
//        Login login2 = new Login();
//        login2 = userService.query(login).get(0);
//        login2.setStatus(status2);
//        return Result.SUCCESS(userService.update(login2));
//}



}
