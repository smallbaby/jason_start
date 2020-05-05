package com.jason.jason_start.service.factory;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author: Jason
 * @date 2020/5/5
 */
public abstract class ChartContextHandlerAdapter implements ChartContextHandler, InitializingBean {

    private String type;

    protected ChartContextHandlerAdapter(String type) {
        this.type = type;
    }

    @Override
    public String getChartType() {
        return type;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        HandlerContextHolder.registHandler(this);
    }
}
