package life.zfq.community.community.mapper;

import life.zfq.community.community.dao.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/22 23:38
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user ( name, account_id,token,gmtCreate,gmtModified,avatar_url)  VALUES( #{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);


    @Select("select *  from user where token = #{token}")
     User findByIdToken(@Param("token") String token);

    @Select("select *  from user where id = #{id}")
     User findById(@Param("id") Integer id);
}
