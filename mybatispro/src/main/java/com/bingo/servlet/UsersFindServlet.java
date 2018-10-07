package com.bingo.servlet;

import com.bingo.dao.UsersDao;
import com.bingo.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class UsersFindServlet extends HttpServlet {
    /**
     * 创建对应的日志记录级别
     * [DEBUG/WARN/INFO/LOG]
     */
    private Logger log = Logger.getLogger(String.valueOf(UsersFindServlet.class));
    private UsersDao usersDao = new UsersDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Users> list = usersDao.findAll();
//        request.setAttribute("usersList",list);
        request.getSession().setAttribute("usersList",list);
        log.info("获取到了usersList");
        for (Users user:list
             ) {
            System.out.println(user.getNickname());
        }
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
