package com.grup2.analyzer.interceptor;

import com.grup2.analyzer.model.Page;
import com.grup2.analyzer.model.PageLog;
import com.grup2.analyzer.service.PageLogService;
import com.grup2.analyzer.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

@Component
public class PageAnalyzerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private PageService pageService;

    @Autowired
    private PageLogService pageLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        String uri = request.getRequestURI();

        if (!uri.startsWith("/admin")) {
            Page page = pageService.loadPageByURL(uri);

            if (page == null) {
                page = new Page(uri);
                pageService.saveOrUpdatePage(page);
            }

            PageLog pageLog = new PageLog();
            pageLog.setIpAddress(request.getRemoteAddr());
            pageLog.setAgent(request.getHeader("User-Agent"));
            pageLog.setTimestamp(new Date());
            pageLog.setPage(page);
            pageLogService.saveOrUpdatePage(pageLog);
        }

        super.afterCompletion(request, response, handler, ex);
    }
}
