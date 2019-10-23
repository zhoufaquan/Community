package life.zfq.community.community.controller;

import life.zfq.community.community.dao.User;
import life.zfq.community.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/20 18:52
 * version 2.0
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
     Cookie[] cookies = request.getCookies();
     for (Cookie cookie : cookies) {
         if (cookie.getName().equals("token")) {
             String token = cookie.getValue();
             User user = userMapper.findByIdToken(token);
             if (user != null) {
                 request.getSession().setAttribute("user",user);
             }
             break;
         }
     }
        return "index";
    }
}
