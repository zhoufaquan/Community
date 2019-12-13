package life.zfq.community.community.dto;

import life.zfq.community.community.dao.User;
import lombok.Data;

/**
 * @Author: zhouFaQuan
 * @Date: 2019/12/11 11:30
 */
@Data
public class QuestionDto {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;


    private String name;
    private String accountId;
    private String token;
    private  String avatarUrl;

}
