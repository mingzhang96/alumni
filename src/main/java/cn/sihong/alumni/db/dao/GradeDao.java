package cn.sihong.alumni.db.dao;

import cn.sihong.alumni.db.domain.Grade;
import cn.sihong.alumni.db.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GradeDao {

    @Autowired
    private GradeMapper gradeMapper;

    public Grade findGradeById(int id) {
        return gradeMapper.findGradeById(id);
    }

    public List<Grade> fingGradeByInYear(int inYear) {
        return gradeMapper.fingGradeByInYear(inYear);
    }

    public void insertSchool(Grade grade) {
        gradeMapper.insertGrade(grade);
    }
}
