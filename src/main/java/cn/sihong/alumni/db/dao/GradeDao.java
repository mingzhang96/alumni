package cn.sihong.alumni.db.dao;

import cn.sihong.alumni.db.domain.Grade;
import cn.sihong.alumni.db.domain.Message;
import cn.sihong.alumni.db.mapper.GradeMapper;
import cn.sihong.alumni.db.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GradeDao {

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private MessageMapper messageMapper;

    public Grade findGradeById(int id) {
        return gradeMapper.findGradeById(id);
    }

    public List<Grade> fingGradeByInYear(int inYear) {
        return gradeMapper.fingGradeByInYear(inYear);
    }

    public void insertGrade(Grade grade) {
        gradeMapper.insertGrade(grade);
    }

    public void updateNoticeById(Grade grade) {
        gradeMapper.updateNoticeById(grade);
    }

    public void insertMessage(Message message) {
        messageMapper.insertMessage(message);
    }

    public void deleteMessage(Message message) {
        messageMapper.updateDelete(message);
    }

    public List<Message> findListByGradeId(Message message) {
        return messageMapper.findListByGradeId(message);
    }

    public Grade findLast() {
        return gradeMapper.findLast();
    }

    public List<Grade> fingGradeBySchoolIdInYear(Grade grade) {
        return gradeMapper.fingGradeBySchoolIdInYear(grade);
    }



}
