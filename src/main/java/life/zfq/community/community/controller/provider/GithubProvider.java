package life.zfq.community.community.controller.provider;

import com.alibaba.fastjson.JSON;
import life.zfq.community.community.controller.dto.AccessTokenDTO;
import life.zfq.community.community.controller.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/21 18:32
 */
@Component
//通过授权码获得访问令牌
public class GithubProvider {
    public String getAccessTokenDTO(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
            String token = string.split("&")[0].split("=")[1];
            return token;


        } catch (IOException e) {

        }
        return null;

    }
    //通过访问令牌获取user信息
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            //json对象转换为类对象
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {

        }
        return null;
    }
}
