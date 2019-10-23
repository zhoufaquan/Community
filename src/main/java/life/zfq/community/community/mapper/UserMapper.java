package life.zfq.community.community.mapper;

import life.zfq.community.community.dao.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/22 23:38
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user ( name, account_id,token,gmt_create,gmt_modified )  VALUES( #{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);


}
