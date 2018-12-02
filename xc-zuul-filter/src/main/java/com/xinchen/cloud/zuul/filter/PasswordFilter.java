package com.xinchen.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Password 过滤器
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/12/2 20:03
 */
public class PasswordFilter extends ZuulFilter {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        // 请求处理完成执行
        return "post";
    }

    @Override
    public int filterOrder() {
        // 优先级为0，数字越大，优先级越低
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // 获取上一个过滤器结果
        // 如果上个过滤器结果为false,不走下面过滤器，直接跳过后面的所有过滤器并返回 上一个过滤器不通过的结果
        RequestContext ctx = RequestContext.getCurrentContext();
        return (boolean) ctx.get("isSuccess");
    }

    @Override
    public Object run() throws ZuulException {
        // 1. 获取request
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        // 2. 打印请求
        LOGGER.info("--->>> PasswordFilter {},{}", request.getMethod(), request.getRequestURL());

        // 3. 判断参数
        String username = request.getParameter("password");
        if (null != username && username.equals("xinchen")) {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess",true);
            return null;
        } else {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("The Password cannot be empty");
            ctx.set("isSuccess",false);
            return null;
        }
    }
}
