package com.jason.jason_start.service;

import com.jason.jason_start.dao.UserMapper;
import com.jason.jason_start.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Service
public interface UserService {

    List<Person> getUserList();
}
