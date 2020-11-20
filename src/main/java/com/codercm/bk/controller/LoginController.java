package com.codercm.bk.controller;

import com.codercm.bk.pojo.User;
import com.codercm.bk.result.Result;
import com.codercm.bk.service.UserService;
import org.hsqldb.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

//import java.util.Objects;
import java.lang.Object;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        //对html标签进行转义, 防止xss攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username,requestUser.getPassword());
        if(null == user) {
          return new Result(400);
        }else {
            return new Result(200);
        }

//        if(!"admin".equals(username) || !"123456".equals(requestUser.getPassword())) {
//            String message = "账号密码错误";
//            System.out.println("fail");
//            return new Result(400);
//        }else {
//            System.out.println("okk");
//            return new Result(200);
//        }
    }
}
