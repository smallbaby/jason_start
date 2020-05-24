package com.jason.jason_start.spring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class ConditionTest {

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,5,6})
    public void testAbs(int x) {
        System.out.println(Math.abs(x));
    }
}
