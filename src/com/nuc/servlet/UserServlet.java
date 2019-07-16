package com.nuc.servlet;

import com.nuc.entiy.User;
import com.nuc.service.UserService;
import com.nuc.service.impl.UserServiceImpl;

import java.io.IOException;

public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String opr = request.getParameter("opr");
        UserService service = new UserServiceImpl();
        User user = new User();
        if ("login".equals(opr)){       //登录
//            System.out.println(request.getParameter("username"));
//            System.out.println(request.getParameter("password"));
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
        }else if ("regist".equals(opr)){        //注册
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
        }else if ("show".equals(opr)){      //展示个人信息
            user = (User) request.getSession().getAttribute("user");
            System.out.println(user);
            service.getUser(user);
            request.setAttribute("user",user);
            request.getRequestDispatcher("user/personalInfo.jsp").forward(request,response);
        }else if ("update".equals(opr)){        //修改个人信息
            user = (User) request.getSession().getAttribute("user");
            System.out.println(user);
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
                request.getRequestDispatcher("user/personalInfo.jsp").forward(request,response);
        }else if ("add".equals(opr)){       //余额充值
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

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
