package com.jason.jason_start.annotation;

/**
 * Author: Jason
 * Date 2020/7/18
 */
public class InfoMain {
    @InfoFieldAnnotation(value = InfoFieldAnnotation.Status.SECOND)
    private String status;

    @InfoMethodAnnotation
    public void notSetValue() {
        System.out.println("not set value");
    }

    @InfoMethodAnnotation(author = "zhangkai", website = "wenhaozhang.com", version = 2)
    public void setValue() {
        System.out.println("set value.");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
