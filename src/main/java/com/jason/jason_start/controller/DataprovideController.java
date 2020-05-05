package com.jason.jason_start.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jason.jason_start.domain.chart.ChartParam;
import com.jason.jason_start.service.DataProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Jason
 * @date 2020/5/4
 * 获取图表数据.
 */
@Slf4j
@RestController
public class DataprovideController {

    @Autowired
    private DataProviderService dataProviderService;

    @PostMapping("/getData.ajax")
    public Object getChartData(@RequestBody String data, @RequestParam(required = false,value = "false") boolean debug,
                               @RequestParam(required = false) boolean showErrorMsg) throws Exception {
        log.info("get data starting...");
        ChartParam chartParam = JSON.parseObject(data, ChartParam.class);
        Object obj = dataProviderService.getData(chartParam);
        JSONObject result = null;
        return obj;
    }
}
