package com.starter.redis.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class GeneralInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(GeneralInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info(String.format("preHandle invoked...%s:%s", request.getRequestURI(), request.getMethod()));
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info(String.format("postHandle invoked...%s:%s", request.getRequestURI(), request.getMethod()));
        long time = (long) request.getAttribute("startTime");
        long requestProcessingTime = System.currentTimeMillis() - time;
        LOG.info("Total time takes to process the request : " + requestProcessingTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            LOG.error(String.format("exception in afterCompletion invoked...%s", ex.getMessage()));
        }
        LOG.info(String.format("afterCompletion invoked...%s:%s", request.getRequestURI(), request.getMethod()));
    }

}
