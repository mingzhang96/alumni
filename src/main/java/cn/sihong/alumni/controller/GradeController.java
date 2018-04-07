package cn.sihong.alumni.controller;

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

}
