package cn.sihong.alumni.service.impl;

import cn.sihong.alumni.db.dao.UserDao;
import cn.sihong.alumni.db.domain.User;
import cn.sihong.alumni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> findList() {
        return userDao.findList();
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public void updateUserById(User user) {
        userDao.updateUserById(user);
    }

    @Override
    public void updatePasswordByName(User user) {
        userDao.updatePasswordByName(user);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
