package cn.sihong.alumni.db.domain;

import lombok.Data;

@Data
public class Relation {

    private Integer id;
    private Integer schoolId;
    private Integer userId;
    private Integer gradeId;

}
