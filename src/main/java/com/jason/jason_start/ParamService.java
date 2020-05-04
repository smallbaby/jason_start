package com.jason.jason_start;

import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Service
public class ParamService {
    //value 命名空间
    @Cacheable(value = "param_all")
    public List<String> findAll() {
        return null;
    }
}
