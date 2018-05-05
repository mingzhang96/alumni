package cn.sihong.alumni.controller;

import cn.sihong.alumni.db.domain.Grade;
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
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RelationService relationService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/findList")
    public ResultVO findUserList() {
        try {
            return ResultVOUtil.success(userService.findList());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    @RequestMapping("/login")
    public ResultVO login(HttpServletRequest request) {
        try {
            String userName = request.getParameter("username");
            System.out.println(userName);
            User user = userService.findUserByName(userName);
            System.out.println(user);
            String password = request.getParameter("password");
            System.out.println("password = " + password);
            if (user.getPassword().equals(password)) {
                Map<String, Integer> map = new HashMap<>();
                map.put("id", user.getId());
                return ResultVOUtil.success(map);
            } else {
                return ResultVOUtil.error(0, "failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }

    }

    @RequestMapping("/userInfo")
    public ResultVO getUserInfoById(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            return ResultVOUtil.success(userService.findUserById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    @RequestMapping("/saveUser")
    public ResultVO saveUserInfo(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new User();
            user.setId(id);
            user.setXm(request.getParameter("xm"));
            user.setPassword(request.getParameter("password"));
            user.setName(request.getParameter("username"));
            user.setAddress(request.getParameter("address"));
            user.setMail(request.getParameter("mail"));
            user.setMotto(request.getParameter("motto"));
            user.setPhone(request.getParameter("phone"));
            user.setQq(request.getParameter("qq"));
            user.setWechat(request.getParameter("wechat"));

            userService.updateUserById(user);
            return ResultVOUtil.success();

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    /**
     * 注册
     * @param request
     * @return
     */
    @RequestMapping("/registerUser")
    public ResultVO registerUser(HttpServletRequest request) {
        try {
            User user = new User();
            user.setXm(request.getParameter("xm"));
            user.setPassword(request.getParameter("password"));
            user.setName(request.getParameter("name"));
            user.setAddress(request.getParameter("address"));
            user.setMail(request.getParameter("mail"));
            user.setMotto(request.getParameter("motto"));
            user.setPhone(request.getParameter("phone"));
            user.setQq(request.getParameter("qq"));
            user.setWechat(request.getParameter("wechat"));

            userService.insertUser(user);
            return ResultVOUtil.success();

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    @RequestMapping("/findSchool")
    public ResultVO findSchoolByUserId(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            List<Relation> list = relationService.findRelationByUserId(id);
            List<School> schoolList = new ArrayList<>();
            for (Relation relation : list) {
                schoolList.add(schoolService.findSchoolById(relation.getSchoolId()));
            }
            System.out.println("school number = " + list.size());
            return ResultVOUtil.success(schoolList);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    @RequestMapping("/findGrade")
    public ResultVO findGradeByUserId(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            List<Relation> list = relationService.findRelationByUserId(id);
            List<Map<String, Object>> resultList = new ArrayList<>();
            for (Relation relation : list) {
                Map<String, Object> resultMap = gradeService.findGradeById(relation.getGradeId()).toMap();
                resultMap.putAll(schoolService.findSchoolById(relation.getSchoolId()).toMap());
                resultList.add(resultMap);
            }
            return ResultVOUtil.success(resultList);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    @RequestMapping("/changePassword")
    public ResultVO changePassword(HttpServletRequest request) {
        try {
            User user = new User();
            user.setName(request.getParameter("name"));
            user.setPassword(request.getParameter("password"));
            userService.updatePasswordByName(user);
            return ResultVOUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

}
