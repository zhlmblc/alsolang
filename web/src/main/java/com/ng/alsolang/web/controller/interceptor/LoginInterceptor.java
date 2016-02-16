package com.ng.alsolang.web.controller.interceptor;

import com.ng.alsolang.domain.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * User: zhangxuegang
 * Date: 2016/1/23
 * Time: 23:16
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    // 不需要拦截的地址
    private static final String[] IGNORE_URI = {
            "user/userlogin.do","index/index.do", "conference/createConference.do",
            "user/userindex.do", "/user/toUserRegister", "user/userRegister.do", "conference/getMeetings.do",
            "userlogin.jsp", "conference/joinConference.do","record/getRecordings.do"};

    private static final String LOGIN_URL = "user/userlogin.do";

    /**
     * 请求预处理
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String url = request.getRequestURL().toString();
        logger.info("get the url is  {} ", url);
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
//            T_supplier_user user = LoginController.getLoginUser(request);
            User user = (User) request.getSession().getAttribute("LOGGEDIN_USER");
            if (user != null) {
                flag = true;
            } else {
                response.sendRedirect(LOGIN_URL);
            }
        }
        return flag;
    }

    /**
     * 返回处理
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        super.postHandle(request, response, handler, modelAndView);
//        response.sendRedirect(LOGIN_URL);
    }

    /**
     * 后处理
     * @param req
     * @param res
     * @param arg2
     * @param arg3
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3) throws Exception {
    }

}
