package cn.sihong.alumni.db.mapper;

import cn.sihong.alumni.db.domain.School;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolMapper {

    @Select("select * from t_school where is_deleted = 0")
    List<School> findList();

    @Select("select * from t_school where id = #{id} and is_deleted = 0")
    School findSchoolById(int id);

    @Select("select * from t_school where name = #{id} and is_deleted = 0")
    School fingSchoolByName(String name);

    @Insert("insert into t_school(city, name) values(#{city}, #{name})")
    void insertSchool(School school);

}
