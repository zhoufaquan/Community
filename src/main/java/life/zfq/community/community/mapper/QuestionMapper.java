package life.zfq.community.community.mapper;

import life.zfq.community.community.dao.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author: zhouFaQuan
 * @Date: 2019/12/5 14:01
 */
@Mapper

public interface QuestionMapper {


@Insert(value = "INSERT INTO question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmt_create1},#{gmt_modified1},#{creator},#{tag})")
 void  create(Question question);
}
