package life.zfq.community.community.mapper;

import life.zfq.community.community.dao.Question;
import life.zfq.community.community.dto.QuestionDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: zhouFaQuan
 * @Date: 2019/12/5 14:01
 */
@Mapper

public interface QuestionMapper {


    @Insert(value = "INSERT INTO question(title,description,gmtCreate,gmtModified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

//    @Select("select * \n" +
//            "from question q\n" +
//            "INNER JOIN `user` u on q.creator=u.id")

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);
    @Select("select count(1) from question")
    Integer count();
}
