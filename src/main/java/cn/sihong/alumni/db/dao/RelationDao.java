package cn.sihong.alumni.db.dao;

import cn.sihong.alumni.db.domain.Relation;
import cn.sihong.alumni.db.mapper.RelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class RelationDao {

    @Autowired
    private RelationMapper relationMapper;

    public List<Relation> findList() {
        return relationMapper.findList();
    }

    public Relation findRelationById(int id) {
        return relationMapper.findRelationById(id);
    }

    public List<Relation> findRelationByUserId(int userId) {
        return relationMapper.findRelationByUserId(userId);
    }

    public List<Relation> findRelationBySchoolId(int schoolId) {
        return relationMapper.findRelationBySchoolId(schoolId);
    }

    public List<Relation> findRelationBySchoolIdGradeId(Map<String, Object> map) {
        return relationMapper.findRelationBySchoolIdGradeId(map);
    }

    public List<Relation> findRelationByGradeId(int gradeId) {
        return relationMapper.findRelationByGradeId(gradeId);
    }

    public void updateDelete(Relation relation) {
        relationMapper.updateDelete(relation);
    }

    public void insertRelation(Relation relation) {
        relationMapper.insertRelation(relation);
    }


}
