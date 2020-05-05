package com.jason.jason_start.service;

import com.jason.jason_start.domain.chart.ChartParam;
import com.jason.jason_start.service.factory.ChartContextHandler;
import com.jason.jason_start.service.factory.ComponentFactory;
import com.jason.jason_start.service.factory.HandlerContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Slf4j
@Service
public class DataProviderService {

    @Autowired
    private ComponentFactory componentFactory;

    public Object getData(ChartParam chartParam) throws Exception {
        log.info("當前參數列表偉：" + chartParam);
        if (chartParam.getData_type() == 0) {
            // 實時
            HandlerContextHolder.setCurrentChartType("1");
            return getRealTimeData(chartParam, "xx");
        } else if (chartParam.getData_type() == 1) {
            // 離線
            return componentFactory.getData("1", chartParam);
        } else {
            throw new Exception("數據類型出錯.");
        }
    }

    private Object getRealTimeData(ChartParam chartParam, String xx) {
        // 获取上下文处理器
        ChartContextHandler handler = HandlerContextHolder.getHandler();
        // 参数处理
        // 查询
        // buildChart
        return null;
    }
}
