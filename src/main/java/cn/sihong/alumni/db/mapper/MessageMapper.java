package cn.sihong.alumni.db.mapper;

import cn.sihong.alumni.db.domain.Grade;
import cn.sihong.alumni.db.domain.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {
    /**
     * private Integer id;
     private Integer userId;
     private Integer gradeId;
     private String message;
     private Integer isDeleted;
     private Date createTime;
     */

    @Select("select * from t_message where grade_id = #{gradeId} and is_deleted = 0")
    List<Message> findListByGradeId(Message message);

    @Insert("insert into t_message(user_id, grade_id, message) values(#{userId}, #{gradeId}, #{message})")
    void insertMessage(Message message);

    @Update("update t_message set is_deleted = 1 where id = #{id}")
    void updateDelete(Message message);
}
