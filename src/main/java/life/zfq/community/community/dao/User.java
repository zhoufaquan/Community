package life.zfq.community.community.dao;

import lombok.Data;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/22 23:33
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private   String avatarUrl;


}
