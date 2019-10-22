package life.zfq.community.community.controller;

import life.zfq.community.community.controller.dto.AccessTokenDTO;
import life.zfq.community.community.controller.dto.GithubUser;
import life.zfq.community.community.controller.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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
    //处理github回调请求和参数
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest requset){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(clientUri);
        accessTokenDTO.setClient_state(state);
        //通过授权码及其他参数取得访问令牌
        String accessToken = githubProvider.getAccessTokenDTO(accessTokenDTO);
        //  通过访问令牌获得用户信息
        GithubUser user = githubProvider.getUser(accessToken);
        if (user != null) {
            //登陆成功写cookies session
            requset.getSession().setAttribute("user",user);
            return "redirect:/index";
        } else {
            return "redirect:/index";
        }

    }
}
