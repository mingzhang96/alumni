package cn.sihong.alumni.db.mapper;

import cn.sihong.alumni.db.domain.Relation;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RelationMapper {

    @Select("select * from t_relation")
    List<Relation> findList();

    @Select("select * from t_relation where id = #{id}")
    Relation findRelationById(int id);

    @Select("select * from t_relation where user_id = #{userId}")
    List<Relation> findRelationByUserId(int userId);

    @Select("select * from t_relation where school_id = #{schoolId}")
    List<Relation> findRelationBySchoolId(int schoolId);

    @Select("select * from t_relation where grade_id = #{gradeId}")
    List<Relation> findRelationByGradeId(int gradeId);

    @Select("select * from t_relation where school_id = #{schoolId} and grade_id = #{gradeId}")
    List<Relation> findRelationBySchoolIdGradeId(Map<String, Object> map);

}
