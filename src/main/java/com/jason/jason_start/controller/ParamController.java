package com.jason.jason_start.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.jason.jason_start.ParamService;
import com.jason.jason_start.common.DsConfig;
import com.jason.jason_start.domain.User;
import com.jason.jason_start.domain.chart.ChartParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@Slf4j
@Api(value = "参数接口.")
@RestController
//@RequestMapping("/param")
public class ParamController extends BaseController {
    @Value("${name}")
    private String env;

    @Autowired
    private ParamService paramService;
    @Autowired
    private User user;
    @Autowired
    private DsConfig dsConfig;

    //private final static Logger LOGGER = LoggerFactory.getLogger(ParamController.class);
    @ApiOperation(value = "hello")
    @GetMapping("/index")
    public Object index() {
        return dsConfig.getDriverName();
    }

    @GetMapping("/chart/data")
    public Object getChartData(@RequestBody String data, @RequestParam(required = false, defaultValue = "false") boolean debug) {
        log.info("current env is: " + env);
        log.info("getChartData: start...");
        ChartParam chartParam = JSON.parseObject(data, ChartParam.class);
        log.info("debug:" + debug);
        log.info("chartParam:" + chartParam.toString());
        return null;
    }

    @PostMapping("/chart/get")
    public Object get(@RequestHeader(name = "app_key", defaultValue = "app_key_dv") String key, @RequestBody ChartParam chartParam) {
        log.info("APP_KEY:" + key);
        log.info(chartParam.toString());
        paramService.findAll();
        log.info("user:" + user.toString());
        return chartParam;
    }
}
