package cn.sihong.alumni.db.mapper;

import cn.sihong.alumni.db.domain.Grade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeMapper {

    /**
     private Integer id;
     private Integer schoolId;
     private Integer inYear;
     private Integer classNumber;
     private Integer isDeleted;
     */

    @Select("select * from t_grade")
    List<Grade> findList();

    @Select("select * from t_grade where id = #{id}")
    Grade findGradeById(int id);

    @Select("select * from t_grade where in_year = #{inYear}")
    List<Grade> fingGradeByInYear(int inYear);

    @Insert("insert into t_grade(school_id, in_year, class_number) values(#{schoolId}, #{inYear}, #{classNumber})")
    void insertGrade(Grade grade);

}
