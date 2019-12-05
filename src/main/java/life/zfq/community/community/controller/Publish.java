package life.zfq.community.community.controller;

import life.zfq.community.community.dao.Question;
import life.zfq.community.community.dao.User;
import life.zfq.community.community.mapper.QuestionMapper;
import life.zfq.community.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zhouFaQuan
 * @Date: 2019/10/24 16:52
 */
@Controller
public class Publish {
    @Autowired
    private UserMapper userMapper;
@Autowired
    private QuestionMapper questionMapper;



    /**
     * GetMapping渲染页面
     */
    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    /**
     * 前后端分离就会提局部刷新，不会页面刷新，所以需要克服
     */
    @PostMapping("/publish")
    public  String doPublish(@RequestParam(value="title",required=false) String title,
                            @RequestParam(value="description",required=false) String description,
                            @RequestParam(value="tag",required=false) String tag,
                            HttpServletRequest request, Model model) {
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        if(title == null || title == ""){
            model.addAttribute("error","标题不能为空");
            return "/publish";
        }
        if(description == null || description == ""){
            model.addAttribute("error","描述不能为空");
            return "/publish";
        }
        if(tag == null || tag == ""){
            model.addAttribute("error","标签不能为空");
            return "/publish";
        }
        User user = null;
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies);
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.findByIdToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

         if (user == null) {
             model.addAttribute("error","用户未登录");
             return "/publish";
         }else{

             System.out.println(user);
             Question question = new Question();
             question.setTitle(title);
             question.setDescription(description);
             question.setTag(tag);
             question.setCreator(user.getId());
             question.setGmt_create1(System.currentTimeMillis());
             question.setGmt_modified1(question.getGmt_create1());
             System.out.println(question);
             questionMapper.create(question);

             return "redirect:/index";
         }

    }
}
