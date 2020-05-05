package com.jason.jason_start.service.chart;

import com.jason.jason_start.domain.chart.ChartParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Slf4j
@Component
public class SummaryChartqueryer extends AbstractQueryer<Object, ChartParam>  {

    // 线程生命周期内起作用，减少同一个线程内多个函数或组件之间的一些公共变量的传递复杂度
    private ThreadLocal<List<Map<String, Object>>> threadLocal = new ThreadLocal<>();

    @Override
    protected void before(ChartParam chartParam) throws Exception {
        threadLocal.set(null);
        super.before(chartParam);
    }

    @Override
    protected Object core(ChartParam chartParam) {
        return null;
    }

    @Override
    protected Object after(ChartParam chartParam, Object result) {
        return super.after(chartParam, result);
    }
}
