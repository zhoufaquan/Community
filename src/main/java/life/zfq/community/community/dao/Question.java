package life.zfq.community.community.dao;

import lombok.Data;

/**
 * @Author: zhouFaQuan
 * @Date: 2019/12/5 14:15
 */
@Data
public class Question {

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

}
