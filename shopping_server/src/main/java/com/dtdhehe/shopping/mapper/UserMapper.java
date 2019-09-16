package com.dtdhehe.shopping.mapper;

import com.dtdhehe.shopping.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Xie_东
 * @version 1.0
 * @date 2019/9/14 17:10
 * @description
 **/
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查找user
     * @param userName
     * @return
     */
    @Select("select t.* from user t where t.user_name=#{userName}")
    User findByUserName(@Param("userName") String userName);

    /**
     * 保存用户
     * @param user
     * @return
     */
    @Insert("insert into user(id,user_name,password,gender,nick_name,phone,email,motto,valid,create_time) VALUES(#{id},#{userName},#{password},#{gender},#{nickName},#{phone},#{email},#{motto},#{valid},#{createTime});")
    Integer save(User user);
}
