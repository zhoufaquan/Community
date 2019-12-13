package life.zfq.community.community.dto;

import lombok.Data;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/21 19:33
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;

}
