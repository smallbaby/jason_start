package com.jason.jason_start.dao;

import com.jason.jason_start.domain.Person;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Component
public interface UserMapper {
    @Select("select * from person order by name desc")
    List<Person> getUserList();
}
