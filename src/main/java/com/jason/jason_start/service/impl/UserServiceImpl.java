package com.jason.jason_start.service.impl;

import com.jason.jason_start.dao.UserMapper;
import com.jason.jason_start.domain.Person;
import com.jason.jason_start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<Person> getUserList() {
        return userMapper.getUserList();
    }
}
