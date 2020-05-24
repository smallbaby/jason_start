package com.jason.jason_start.schedule;

import com.jason.jason_start.schedule.handle.JobController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Jason
 * Date 2020/5/23
 */
public final class Master {
    private final MasterContext context;
    private final Map<String, JobController> controllers;
    private final Map<String, List<String>> groupWorks; // 组和worker节点

    public Master(final MasterContext context) {
        this.context = context;
        groupWorks = new ConcurrentHashMap<String,List<String>>();
        controllers = new HashMap<>();
    }
}
