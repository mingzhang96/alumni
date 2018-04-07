package cn.sihong.alumni.service.impl;

import cn.sihong.alumni.db.dao.SchoolDao;
import cn.sihong.alumni.db.domain.School;
import cn.sihong.alumni.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    @Override
    public List<School> findList() {
        return schoolDao.findList();
    }

    @Override
    public School findSchoolById(int id) {
        return schoolDao.findSchoolById(id);
    }

    @Override
    public School fingSchoolByName(String name) {
        return schoolDao.fingSchoolByName(name);
    }

    @Override
    public void insertSchool(School school) {
        schoolDao.insertSchool(school);
    }
}
