package com.jason.jason_start.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Data
@Component
public class User {
    @Value("1")
    private Long id;
    @Value("jason")
    private String name;
    @Value("hello")
    private String note;
}
