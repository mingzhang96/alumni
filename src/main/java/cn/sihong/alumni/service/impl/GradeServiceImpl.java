package cn.sihong.alumni.service.impl;

import cn.sihong.alumni.db.dao.GradeDao;
import cn.sihong.alumni.db.domain.Grade;
import cn.sihong.alumni.db.domain.Message;
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

    @Override
    public void updateNoticeById(Grade grade) {
        gradeDao.updateNoticeById(grade);
    }

    @Override
    public List<Message> findListByGradeId(Message message) {
        return gradeDao.findListByGradeId(message);
    }

    @Override
    public void insertMessage(Message message) {
        gradeDao.insertMessage(message);
    }

    @Override
    public void deleteMessage(Message message) {
        gradeDao.deleteMessage(message);
    }

    @Override
    public void insertGrade(Grade grade) {
        gradeDao.insertGrade(grade);
    }

    @Override
    public Grade findLast() {
        return gradeDao.findLast();
    }

    @Override
    public List<Grade> fingGradeBySchoolIdInYear(Grade grade) {
        return gradeDao.fingGradeBySchoolIdInYear(grade);
    }


}
