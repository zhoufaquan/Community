package life.zfq.community.community.controller;

import life.zfq.community.community.controller.dto.AccessTokenDTO;
import life.zfq.community.community.controller.dto.GithubUser;
import life.zfq.community.community.controller.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/21 18:25
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    //处理github回调请求和参数
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id("Iv1.a0f189c4840019b7");
        accessTokenDTO.setClient_secret("44cebec026b0b71b1bafff9fdf6f8d7046663d8d");
        accessTokenDTO.setRedirect_uri("http://localhost:8087/callback");
        accessTokenDTO.setClient_state(state);
        //通过授权码及其他参数取得访问令牌
        String accessToken = githubProvider.getAccessTokenDTO(accessTokenDTO);
        //  通过访问令牌获得用户信息
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
