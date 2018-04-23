package com.hq.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ERROR_TYPE;

/**
 * @author Administrator
 * @Package com.hq.gateway.filter
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/4/23 14:33
 */
public class GlobalErrorFilter  extends ZuulFilter {
    protected Logger logger =LoggerFactory.getLogger(GlobalErrorFilter.class);

    @Override
    public String filterType() {
        return ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        Throwable throwable = context.getThrowable();
        this.logger.error("[ErrorFilter] error message: {}", throwable.getCause().getMessage());
        context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        context.set("error.exception", throwable.getCause());
        return null;
    }

}
