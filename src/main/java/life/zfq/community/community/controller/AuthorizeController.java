package life.zfq.community.community.controller;

import life.zfq.community.community.dao.User;
import life.zfq.community.community.dto.AccessTokenDTO;
import life.zfq.community.community.dto.GithubUser;
import life.zfq.community.community.mapper.UserMapper;
import life.zfq.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/21 18:25
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String clientUri;
    @Autowired
    private UserMapper userMapper;
    //处理github回调请求和参数
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest requset,
                           HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(clientUri);
        accessTokenDTO.setClient_state(state);
        //通过授权码及其他参数取得访问令牌
        String accessToken = githubProvider.getAccessTokenDTO(accessTokenDTO);
        //  通过访问令牌获得用户信息
        GithubUser githubUser = githubProvider.getUser(accessToken);
        //登陆持久化
        if (githubUser != null&&githubUser.getId()!=null) {

            User user = new User();
            //UUID.randomUUID().toString()是javaJDK提供的一个自动生成主键的方法。
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            //数据插入数据库过程就相当于写入 session
            userMapper.insert(user);
            //登陆成功写cookies cookies在response里,返回给浏览器页面
            response.addCookie(new Cookie("token",token));
            requset.getSession().setAttribute("user",githubUser);
            return "redirect:/index";
        } else {
            return "redirect:/index";
        }

    }
}
