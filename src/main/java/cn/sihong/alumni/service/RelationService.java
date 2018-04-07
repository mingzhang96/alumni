package cn.sihong.alumni.service;

import cn.sihong.alumni.db.domain.Relation;

import java.util.List;

public interface RelationService {

    public List<Relation> findRelationByUserId(int userId);

    public List<Relation> findRelationBySchoolId(int schoolId);

    public List<Relation> findRelationByGradeId(int gradeId);
}
