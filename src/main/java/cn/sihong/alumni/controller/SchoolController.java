package cn.sihong.alumni.controller;

import cn.sihong.alumni.db.domain.Relation;
import cn.sihong.alumni.db.domain.School;
import cn.sihong.alumni.db.domain.User;
import cn.sihong.alumni.service.GradeService;
import cn.sihong.alumni.service.RelationService;
import cn.sihong.alumni.service.SchoolService;
import cn.sihong.alumni.service.UserService;
import cn.sihong.alumni.util.ResultVOUtil;
import cn.sihong.alumni.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private RelationService relationService;

    @Autowired
    private UserService userService;

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/findList")
    public ResultVO findSchoolList() {
        try {
            return ResultVOUtil.success(schoolService.findList());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    @RequestMapping("/findSchoolById")
    public ResultVO findSchoolById(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            return ResultVOUtil.success(schoolService.findSchoolById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    @RequestMapping("/findSchoolByName")
    public ResultVO findSchoolByName(HttpServletRequest request) {
        try {
            String name = request.getParameter("name");
            return ResultVOUtil.success(schoolService.fingSchoolByName(name));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    @RequestMapping("/insertSchool")
    public ResultVO insertSchool(HttpServletRequest request) {
        try {
            School school = new School();
            school.setName(request.getParameter("name") != null ? request.getParameter("name") : "");
            school.setCity(request.getParameter("city") != null ? request.getParameter("city") : "");
            schoolService.insertSchool(school);
            return ResultVOUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    @RequestMapping("/findUserInSchool")
    public ResultVO findUserInSchool(HttpServletRequest request) {
        try {
            List<Relation> list = relationService.findRelationBySchoolId(Integer.parseInt(request.getParameter("schoolId")));
            List<Map<String, Object>> resultList = new ArrayList<>();

            for (Relation relation : list) {
                Map<String, Object> resultMap = userService.findUserById(relation.getUserId()).toMap();
                resultMap.putAll(gradeService.findGradeById(relation.getGradeId()).toMap());
                resultList.add(resultMap);
            }

            return ResultVOUtil.success(resultList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

}
