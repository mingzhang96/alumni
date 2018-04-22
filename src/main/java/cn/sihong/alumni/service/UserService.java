package cn.sihong.alumni.service;

import cn.sihong.alumni.db.domain.User;

import java.util.List;

public interface UserService {

    public List<User> findList();

    public User findUserById(int id);

    public User findUserByName(String name);

    public void updateUserById(User user);

    public void updatePasswordByName(User user);

}
