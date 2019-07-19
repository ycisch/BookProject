package com.nuc.servlet;

import com.nuc.entiy.User;
import com.nuc.service.UserService;
import com.nuc.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: UserServlet
 * Function:  用户登录  用户注册
 * Date:      2019/7/17 21:01
 * author     yinchen&wy&ry&wcr
 * version    V1.0
 */

public class UserServlet extends javax.servlet.http.HttpServlet {
    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws IOException
     */
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String opr = request.getParameter("opr");
        UserService service = new UserServiceImpl();
        User user = new User();

        /**
         * @description         用户登录
         */
        if ("login".equals(opr)){       //登录
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user = service.login(user);
            if (user == null)
            {
                request.setAttribute("message","用户名或密码错误！");
                request.getRequestDispatcher("system/login.jsp").forward(request,response);;
            }
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("system/menu.jsp").forward(request,response);
        }
        /**
         * @description         用户注册
         */
        if ("regist".equals(opr)){        //注册
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));
            user.setAddress(request.getParameter("address"));
            user.setPhone(request.getParameter("phone"));
            if (service.regist(user)){
                request.setAttribute("message","注册成功");
                request.getRequestDispatcher("system/login.jsp").forward(request,response);
            }else {
                request.setAttribute("message","注册失败");
            }


        }
        /**
         * @description         展示个人信息
         */
        if ("show".equals(opr)){      //展示个人信息
            user = (User) request.getSession().getAttribute("user");
            service.getUser(user);
            request.setAttribute("user",user);
            request.getRequestDispatcher("user/personalInfo.jsp").forward(request,response);
        }
        /**
         * @description         修改个人信息
         */
        if ("update".equals(opr)){        //修改个人信息
            user = (User) request.getSession().getAttribute("user");
//            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));
            user.setAddress(request.getParameter("address"));
            user.setPhone(request.getParameter("phone"));
            user = service.updateUser(user);
            if (user == null)
                request.setAttribute("message","修改失败");
            else{
                request.setAttribute("message","修改成功");
                request.setAttribute("user",user);
            }
                request.getRequestDispatcher("/WEB_INF/views/admin/user-list.jsp").forward(request,response);
        }
        /**
         * @description         余额充值
         */
        if ("add".equals(opr)){       //余额充值
            user = (User) request.getSession().getAttribute("user");
            float money = Float.parseFloat(request.getParameter("total_amount"));
            System.out.println(money);
            if (service.addMoney(user,money))
            {
                request.setAttribute("message","充值成功");
                request.setAttribute("user",user);
            }
            else
                request.setAttribute("message","充值失败");
            request.getRequestDispatcher("user/personalCenter.jsp").forward(request,response);
        }
        /**
         * @description         前台校验
         */
        if ("exist".equals(opr)){
            String username = request.getParameter("username");
            System.out.println(username);
            PrintWriter printWriter = response.getWriter();
            boolean exists = service.exist(username);
            response.setContentType("text/html;charset=utf-8");
            if (exists){
                printWriter.print("true");
                printWriter.flush();
                printWriter.close();

            }else {
                printWriter.print("false");
                printWriter.flush();
                printWriter.close();
            }
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
