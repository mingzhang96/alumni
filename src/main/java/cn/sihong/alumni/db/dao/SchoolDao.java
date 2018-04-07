package cn.sihong.alumni.db.dao;

import cn.sihong.alumni.db.domain.School;
import cn.sihong.alumni.db.mapper.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchoolDao {

    @Autowired
    private SchoolMapper schoolMapper;

    public List<School> findList() {
        return schoolMapper.findList();
    }

    public School findSchoolById(int id) {
        return schoolMapper.findSchoolById(id);
    }

    public School fingSchoolByName(String name) {
        return schoolMapper.fingSchoolByName(name);
    }

    public void insertSchool(School school) {
        schoolMapper.insertSchool(school);
    }
}
