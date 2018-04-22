package cn.sihong.alumni.controller;

import cn.sihong.alumni.db.domain.Grade;
import cn.sihong.alumni.db.domain.Message;
import cn.sihong.alumni.db.domain.Relation;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private RelationService relationService;

    @Autowired
    private UserService userService;

    @Autowired
    private GradeService gradeService;

    /**
     * 新建班级
     * @param request
     * @return
     */
    @RequestMapping("/insertGrade")
    public ResultVO insertGrade(HttpServletRequest request) {
        try {
            Grade grade = new Grade();
            grade.setSchoolId(Integer.parseInt(request.getParameter("schoolId")));
            grade.setInYear(Integer.parseInt(request.getParameter("inYear")));
            grade.setClassNumber(Integer.parseInt(request.getParameter("classNumber")));
            grade.setNotice(request.getParameter("notice"));
            grade.setManagerId(Integer.parseInt(request.getParameter("userId")));
            gradeService.insertGrade(grade);
            Relation relation = new Relation();
            relation.setUserId(Integer.parseInt(request.getParameter("userId")));
            relation.setSchoolId(Integer.parseInt(request.getParameter("schoolId")));
            relation.setGradeId(gradeService.findLast().getId());
            relationService.insertRelation(relation);
            return ResultVOUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    /**
     * 根据学校id和年份查找班级
     * @param request
     * @return
     */
    @RequestMapping("/findGradeBySchoolIdInYear")
    public ResultVO findGradeBySchoolIdInYear(HttpServletRequest request) {
        try {
            Grade grade = new Grade();
            grade.setInYear(Integer.parseInt(request.getParameter("inYear")));
            grade.setSchoolId(Integer.parseInt(request.getParameter("schoolId")));
            return ResultVOUtil.success(gradeService.fingGradeBySchoolIdInYear(grade));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    /**
     * user添加进入grade
     * @param request
     * @return
     */
    @RequestMapping("/addToGrade")
    public ResultVO addToGrade(HttpServletRequest request) {
        try {
            Relation relation = new Relation();
            relation.setGradeId(Integer.parseInt(request.getParameter("gradeId")));
            relation.setSchoolId(Integer.parseInt(request.getParameter("schoolId")));
            relation.setUserId(Integer.parseInt(request.getParameter("userId")));
            relationService.insertRelation(relation);
            return ResultVOUtil.success();

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    @RequestMapping("/findUserInGrade")
    public ResultVO findUserInGrade(HttpServletRequest request) {
        try {
            List<Relation> list = relationService.findRelationByGradeId(Integer.parseInt(request.getParameter("id")));
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

    /**
     * 管理员删用户
     * @param request
     * @return
     */
    @RequestMapping("/deleteUser")
    public ResultVO deleteUser(HttpServletRequest request) {
        try {
            int gradeId = Integer.parseInt(request.getParameter("gradeId"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            Relation relation = new Relation();
            relation.setGradeId(gradeId);
            relation.setUserId(userId);
            relationService.updateDelete(relation);
            return ResultVOUtil.success();

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    /**
     * 更新公告
     * @param request
     * @return
     */
    @RequestMapping("/updateNotice")
    public ResultVO updateNotice(HttpServletRequest request) {
        try {
            Grade grade = new Grade();
            grade.setId(Integer.parseInt(request.getParameter("gradeId")));
            grade.setNotice(request.getParameter("notice"));
            gradeService.updateNoticeById(grade);
            return ResultVOUtil.success();

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    /**
     * 返回留言列表
     * @param request
     * @return
     */
    @RequestMapping("/findListByGradeId")
    public ResultVO findListByGradeId(HttpServletRequest request) {
        try {
            Message message = new Message();
            message.setGradeId(Integer.parseInt(request.getParameter("gradeId")));
            List<Message> messageList = gradeService.findListByGradeId(message);
            List<Map<String, Object>> resultList = new ArrayList<>();
            for (Message messageTemp : messageList) {
                Map<String, Object> resultMap = messageTemp.toMap();
                resultMap.putAll(userService.findUserById(messageTemp.getUserId()).toMap());
                resultList.add(resultMap);
            }
            return ResultVOUtil.success(resultList);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    /**
     * 新建留言
     * @param request
     * @return
     */
    @RequestMapping("/insertMessage")
    public ResultVO insertMessage(HttpServletRequest request) {
        try {
            Message message = new Message();
            message.setGradeId(Integer.parseInt(request.getParameter("gradeId")));
            message.setUserId(Integer.parseInt(request.getParameter("userId")));
            message.setMessage(request.getParameter("message"));
            gradeService.insertMessage(message);
            return ResultVOUtil.success();

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

    /**
     * 删除留言
     * @param request
     * @return
     */
    @RequestMapping("/deleteMessage")
    public ResultVO deleteMessage(HttpServletRequest request) {
        try {
            Message message = new Message();
            message.setMessage(request.getParameter("id"));
            gradeService.deleteMessage(message);
            return ResultVOUtil.success();

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "failed");
        }
    }

}
