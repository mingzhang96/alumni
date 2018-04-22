package cn.sihong.alumni.db.mapper;

import cn.sihong.alumni.db.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from t_user")
    List<User> findList();

    @Select("select * from t_user where id = #{id}")
    User findUserById(int id);

    @Select("select * from t_user where name = #{name}")
    User findUserByName(String name);

    @Insert("insert into t_user(xm, password, name, qq, phone, wechat, mail, address, motto) values(#{xm}, #{password}, #{name}, #{qq}, #{phone}, #{wechat}, #{mail}, #{address}, #{motto})")
    void insertUser(User user);

    @Update("update t_user set qq = #{qq}, phone=#{phone}, wechat = #{wechat}, mail = #{mail}, address = #{address}, motto = #{motto} where id = #{id}")
    void updateUserById(User user);

    @Update("update t_user set password = #{password} where name = #{name}")
    void updatePasswordByName(User user);

}
