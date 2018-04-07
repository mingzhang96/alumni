package cn.sihong.alumni.service;

import cn.sihong.alumni.db.domain.Grade;

import java.util.List;

public interface GradeService {

    public List<Grade> findGradeByInYear(int inYear);

    public Grade findGradeById(int id);

}
