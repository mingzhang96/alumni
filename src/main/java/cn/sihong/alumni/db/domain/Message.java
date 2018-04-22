package cn.sihong.alumni.db.domain;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class Message {
    private Integer id;
    private Integer userId;
    private Integer gradeId;
    private String message;
    private Integer isDeleted;
    private Date createTime;

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("userId", userId);
        map.put("gradeId", gradeId);
        map.put("message", message);
        map.put("createTime", createTime);
        return map;
    }

}
