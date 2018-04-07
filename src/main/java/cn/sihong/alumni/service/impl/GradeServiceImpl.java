package cn.sihong.alumni.service.impl;

import cn.sihong.alumni.db.dao.GradeDao;
import cn.sihong.alumni.db.domain.Grade;
import cn.sihong.alumni.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDao gradeDao;

    @Override
    public List<Grade> findGradeByInYear(int inYear) {
        return gradeDao.fingGradeByInYear(inYear);
    }

    @Override
    public Grade findGradeById(int id) {
        return gradeDao.findGradeById(id);
    }
}
