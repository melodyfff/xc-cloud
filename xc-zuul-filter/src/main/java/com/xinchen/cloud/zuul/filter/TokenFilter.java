package com.xinchen.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Token 过滤器
 * ZuulFilter 是Zuul中核心组件，通过继承该抽象类，覆写几个关键方法达到自定义调度请求的作用
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/12/2 19:51
 */
public class TokenFilter extends ZuulFilter {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        // pre：路由之前
        // routing：路由之时
        // post： 路由之后
        // 可以放在被路由之前调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 是否执行该过滤器
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 1. 获取当前request请求
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        // 2. 打印请求
        LOGGER.info("--->>> TokenFilter {},{}",request.getMethod(),request.getRequestURL());

        // 3. 获取请求参数
        String token = request.getParameter("token");

        // 4. 检测是否包含参数
        if (StringUtils.isNotBlank(token)){
            // 对请求进行路由
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess",true);
            return null;
        } else {
            // 不进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess",false);
            return null;
        }
    }
}
