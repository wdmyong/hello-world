package com.wdm.example.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.wdm.example.mapper.UserMapper;
import com.wdm.example.model.User;

/*
 * @author wdmyong
 * 20170416
 */
@Repository
public class UserDao {

    @Resource
    UserMapper userMapper;

    @Resource
    DataSource dataSource;

    @Cacheable(value = "user_cache_", key = "'id_' + #id")
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    @CacheEvict(value = "user_cache_", key = "'id_' + #user.id")
    public void update(User user) {
        userMapper.update(user);
    }
}
