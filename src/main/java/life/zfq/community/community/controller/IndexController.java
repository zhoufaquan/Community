package life.zfq.community.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.zfq.community.community.dao.Question;
import life.zfq.community.community.dao.User;
import life.zfq.community.community.dto.PageInfoDto;
import life.zfq.community.community.dto.QuestionDto;
import life.zfq.community.community.mapper.QuestionMapper;
import life.zfq.community.community.mapper.UserMapper;
import life.zfq.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/20 18:52
 * version 2.0
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model,
                        @RequestParam(name="page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "2") Integer size
                        ) {
     Cookie[] cookies = request.getCookies();
     if (cookies != null && cookies.length != 0)
        {
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
        }


        //List<Question> questions=  questionService.list();
        //System.out.println(questions.size());
        PageInfoDto questionDtoList= questionService.list(page,size);
        System.out.println(questionDtoList);
        model.addAttribute("pageInfo",questionDtoList);
        return "index";
    }
}
