package com.ng.alsolang.web.controller.user;

import com.ng.alsolang.domain.user.User;
import com.ng.alsolang.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制类
 * User: zhangxuegang
 * Date: 2016/1/20
 * Time: 14:21
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource(name = "userServiceImpl")
    private UserService userService;

    /**
     * 用户登录跳转
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/userindex.do")
    public String toIndex(HttpServletRequest request, Model model) {

        // 查看session中是否存在
        User user = (User) request.getSession().getAttribute("LOGGEDIN_USER");
        if (user != null) {
            logger.info("get user from session success, user is {}", user.toString());
            model.addAttribute("user", user);
            return "user/userindex";
        }

        // 用户登录验证
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        if (userId != null && password != null) {
            User userLogin = new User();
            userLogin.setUserId(userId);
            userLogin.setPassword(password);
            if (this.userService.getLoginUser(userLogin)) {
                user = this.userService.getUserByUserId(userLogin.getUserId());
                logger.info("get user success, user is {}", user.toString());
                request.getSession().setAttribute("LOGGEDIN_USER",user);
                model.addAttribute("user", user);
            } else {
                model.addAttribute("user can not in use");
                logger.error("can't get the user");
            }
            return "user/userindex";
        }
        return "user/userlogin";
    }

    /**
     * 跳转到登录页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "userlogin.do", method = RequestMethod.GET)
    public String userLogin(HttpServletRequest request, Model model) {
        return "user/userlogin";
    }


    /**
     * 跳转到注册页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/toUserRegister.do",method= RequestMethod.GET)
    public String toUserRegister(HttpServletRequest request,Model model) {

        return "user/userregister";
    }


    /**
     * 新用户注册
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/userRegister.do")
    public String registerIndex(HttpServletRequest request,Model model){
        //ModelAndView mav=new ModelAndView();

        User userRegister=new User();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        // 参数判断
        if (userName == null || email == null ) {
            return "user/userregister";
        }

        // 防重判断
        userRegister.setUserId(email);
        userRegister.setUserName(username);
        userRegister.setPassword(password);
        userRegister.setUserName(userName);
        userRegister.setEmail(email);
        userRegister.setMobile(mobile);
        userRegister.setStatus(1);
        logger.info("get the register User, User is {}", userRegister.toString());
        Boolean flag = this.userService.insert(userRegister);

        model.addAttribute("flag", flag);
        return "user/userlogin";
    }


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}