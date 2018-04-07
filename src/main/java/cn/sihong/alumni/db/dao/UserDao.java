package cn.sihong.alumni.db.dao;

import cn.sihong.alumni.db.domain.User;
import cn.sihong.alumni.db.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public List<User> findList() {
        return userMapper.findList();
    }

    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }



}
