package com.jason.jason_start.spring;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.XpathAssertions;

/**
 * Author: Jason
 * Date 2020/5/8
 */
public class enumTest {

    @Test
    public void testEnum() {
        Operator o = Operator.ADD;
        switch (o) {
            case ADD:
                System.out.println("add..");
                break;
            case EDIT:
                System.out.println("Edit..");
                break;
        }
    }

    @Test
    public void testT() {
        String split = "\\t";
        System.out.println("hell" + split + "world");
    }

    @Test
    public void testColor() {
        Color c = Color.RED;
        if (c.getCode().equals(Color.RED.getCode())) {
            System.out.println("红色...");
        }
    }

}

@Getter
enum Color {
    RED("001", "红色,咋地.."),BLUE("002", "蓝色的..");
    private String code;
    private String name;
    private Color(String code, String name) {
        this.code = code;
        this.name = name;
    }
}

// 常量定义
enum Operator {
    ADD, EDIT, DELETE, SELECT;

}
