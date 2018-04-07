package cn.sihong.alumni.db.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Grade {

    private Integer id;
    private Integer schoolId;
    private Integer inYear;
    private Integer classNumber;
    private Integer isDeleted;

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("gradeId", id);
        map.put("schoolId", schoolId);
        map.put("inYear", inYear);
        map.put("classNumber", classNumber);
        return map;
    }

}
