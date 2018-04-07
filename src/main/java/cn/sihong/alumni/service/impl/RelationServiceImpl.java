package cn.sihong.alumni.service.impl;

import cn.sihong.alumni.db.dao.RelationDao;
import cn.sihong.alumni.db.domain.Relation;
import cn.sihong.alumni.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationDao relationDao;

    @Override
    public List<Relation> findRelationByUserId(int userId) {
        return relationDao.findRelationByUserId(userId);
    }

    @Override
    public List<Relation> findRelationBySchoolId(int schoolId) {
        return relationDao.findRelationBySchoolId(schoolId);
    }

    @Override
    public List<Relation> findRelationByGradeId(int gradeId) {
        return relationDao.findRelationByGradeId(gradeId);
    }
}
