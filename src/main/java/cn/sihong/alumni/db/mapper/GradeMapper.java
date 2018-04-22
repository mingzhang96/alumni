package cn.sihong.alumni.db.mapper;

import cn.sihong.alumni.db.domain.Grade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Insert("insert into t_grade(school_id, in_year, class_number, notice) values(#{schoolId}, #{inYear}, #{classNumber}, #{notice})")
    void insertGrade(Grade grade);

    @Update("update t_grade set notice = #{notice} where id = #{id}")
    void updateNoticeById(Grade grade);

    @Select("select * from t_grade order by id desc limit 1")
    Grade findLast();

    @Select("select * from t_grade where in_year = #{inYear} and school_id = #{schoolId}")
    List<Grade> fingGradeBySchoolIdInYear(Grade grade);


}
