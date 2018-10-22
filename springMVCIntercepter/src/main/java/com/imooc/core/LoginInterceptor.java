package com.imooc.core;

import com.imooc.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute("session_user");
        if(user==null) {
            System.out.println("1:keketip--login====preHandle===>");
            response.sendRedirect(request.getContextPath()+"/login");
            return false;//会终止下面的拦截（false的话，下面的postHandle和afterCompletion就不会执行）
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("3:-----keketip==--login==postHandle===>");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("4--->keketip=--login===afterCompletion===>");
    }
}
