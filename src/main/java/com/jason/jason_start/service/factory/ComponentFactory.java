package com.jason.jason_start.service.factory;

import com.jason.jason_start.domain.chart.ChartParam;
import com.jason.jason_start.service.chart.SummaryChartqueryer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Component
public class ComponentFactory {
    @Autowired
    private SummaryChartqueryer summaryChartqueryer; // 指標卡

    public Object getData(String type, ChartParam chartParam) throws Exception {
        if (type.equals("1")) {
            return summaryChartqueryer.query(chartParam);
        }
        return null;
    }
}
