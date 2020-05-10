package com.jason.jason_start.spring;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

/**
 * Author: Jason
 * Date 2020/5/7
 */
public class AssertTest {

    @Test
    public void testHasText() {
        Assert.hasText(null, "名称不能为空");
    }

    @Test
    public void testIsTrue() {
        int a = 1;
        Assert.isTrue(a == 0, "次数大于1");
    }

    public void testSavePortal() {
        //1、断言必填字段
        //2、验证别名不能重复
    }
}
