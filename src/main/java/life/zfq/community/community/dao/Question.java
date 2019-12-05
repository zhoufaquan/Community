package life.zfq.community.community.dao;

/**
 * @Author: zhouFaQuan
 * @Date: 2019/12/5 14:15
 */
public class Question {

   private Integer id;
   private String title;
   private String description;
   private String tag;
   private Long gmt_create1;
   private Long gmt_modified1;
   private Integer creator;
   private Integer view_count;
   private Integer comment_count;
   private Integer like_count;
    public Long getGmt_create1() {
        return gmt_create1;
    }

    public void setGmt_create1(Long gmt_create1) {
        this.gmt_create1 = gmt_create1;
    }

    public Long getGmt_modified1() {
        return gmt_modified1;
    }

    public void setGmt_modified1(Long gmt_modified1) {
        this.gmt_modified1 = gmt_modified1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }




    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tag='" + tag + '\'' +
                ", gmt_create=" + gmt_create1 +
                ", gmt_modified1=" + gmt_modified1 +
                ", creator=" + creator +
                ", view_count=" + view_count +
                ", comment_count=" + comment_count +
                ", like_count=" + like_count +
                '}';
    }
}
