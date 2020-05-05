package com.jason.jason_start.service.chart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Slf4j
public abstract class AbstractQueryer<Response, Request> {
    public final Response query(final Request request) throws Exception {
        before(request);
        Response result = core(request);
        return after(request, result);
    }

    protected Response after(Request request, Response result) {
        // 后置处理 ,（空处理、异常封装)
        return result;
    }

    protected abstract Response core(Request request);

    protected void before(Request request) throws Exception {}
}
