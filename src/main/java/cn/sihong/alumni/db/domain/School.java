package cn.sihong.alumni.db.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class School {


    private Integer id;
    private String city;
    private String name;
    private Integer isDeleted;

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("city", city);
        map.put("name", name);
        return map;
    }

}
