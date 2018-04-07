package cn.sihong.alumni.service;

import cn.sihong.alumni.db.domain.School;

import java.util.List;

public interface SchoolService {

    List<School> findList();

    School findSchoolById(int id);

    School fingSchoolByName(String name);

    void insertSchool(School school);
}
