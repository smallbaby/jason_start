package com.jason.jason_start.service.factory;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

/**
 * @author: Jason
 * @date 2020/5/5
 */
@Data
public class HandlerContextHolder {

    // 当前图表类型
    private static final ThreadLocal<String> LOCAL_CHART_TYPE = new ThreadLocal<>();
    // 各种图表的处理handler
    private static final Map<String, ChartContextHandler> HANDLERS = Maps.newLinkedHashMap();
    // 设置当前类型
    public static void setCurrentChartType(String chartType){
        LOCAL_CHART_TYPE.set(chartType);
    }

    public static String getLocalChartType() {
        return LOCAL_CHART_TYPE.get();
    }


    public static ChartContextHandler getHandler() {
        return getHandler();
    }

    // 根据类型获取handler
    public static ChartContextHandler getHandler(String type) {
        return HANDLERS.get(type == null ? getLocalChartType() : type);
    }

    public static void registHandler(ChartContextHandler handler) {
        HANDLERS.putIfAbsent(handler.getChartType(), handler); // 图表类型 + handler
    }
}
