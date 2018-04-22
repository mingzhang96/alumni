package cn.sihong.alumni.service;

import cn.sihong.alumni.db.domain.Grade;
import cn.sihong.alumni.db.domain.Message;

import java.util.List;

public interface GradeService {

    public List<Grade> findGradeByInYear(int inYear);

    public Grade findGradeById(int id);

    public void updateNoticeById(Grade grade);

    public List<Message> findListByGradeId(Message message);

    public void insertMessage(Message message);

    public void deleteMessage(Message message);

    public void insertGrade(Grade grade);

    public Grade findLast();

    public List<Grade> fingGradeBySchoolIdInYear(Grade grade);



}
