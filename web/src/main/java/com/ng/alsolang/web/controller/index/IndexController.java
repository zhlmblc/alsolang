package com.ng.alsolang.web.controller.index;

import com.ng.alsolang.domain.user.User;
import com.ng.alsolang.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * User: zhangxuegang
 * Date: 2016/1/27
 * Time: 19:16
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource(name = "userServiceImpl")
    private UserService userService;

    /**
     * 用户登录跳转
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/index.do")
    public String toIndex(HttpServletRequest request, Model model) {
        return "index/index";
    }


}
