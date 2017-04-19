package com.wdm.example.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdm.example.dao.UserDao;
import com.wdm.example.datasource.TargetDataSource;
import com.wdm.example.model.User;
import com.wdm.example.service.UserService;

/*
 * @author wdmyong
 * 20170416
 */
@Service
public class UserService {

    @Resource
    UserDao userDao;

    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @TargetDataSource("master")
    public User getById0(Integer id) {
        return userDao.getById(id);
    }

    @TargetDataSource("first")
    public User getById1(Integer id) {
        return userDao.getById(id);
    }

    @TargetDataSource("second")
    public User getById2(Integer id) {
        return userDao.getById(id);
    }

    public void insert(User user) {
        Date now = new Date();
        user.setCreateTime(now);
        user.setModifyTime(now);
        userDao.insert(user);
    }

    public void update(User user) {
        user.setModifyTime(new Date());
        userDao.update(user);
    }

}
