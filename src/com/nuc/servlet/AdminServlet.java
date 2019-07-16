package com.nuc.servlet;

import com.nuc.entiy.Admin;
import com.nuc.entiy.User;
import com.nuc.service.AdminService;
import com.nuc.service.impl.AdmainServiceImpl;
import com.nuc.util.FileUpload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        Admin admin = null;
        List<User> userList = new ArrayList<>();
        AdminService service = new AdmainServiceImpl();
        String opr = request.getParameter("opr");
        System.out.println(request.getParameter("opr"));
        if ("login".equals(opr)){       //管理员登录
            admin = new Admin();
            admin.setAdminName(request.getParameter("adminname"));
            admin.setAdminPwd(request.getParameter("adminpwd"));
            admin = service.login(admin);
            request.getSession().setAttribute("admin",admin);
            request.getRequestDispatcher("/BookServlet?opr=welcome&page=1").forward(request,response);
        }else if ("show".equals(opr)){      //展示管理员信息
            admin = new Admin();
            admin.setAdminId(Integer.parseInt(request.getParameter("id")));
            admin = service.getUser(admin);
            request.setAttribute("admin",admin);
            request.getRequestDispatcher("admin/admin_info.jsp").forward(request,response);
        }else if ("update".equals(opr)){        //修改管理员信息
            admin = new Admin();
            admin.setAdminId(Integer.parseInt(request.getParameter("adminid")));
            admin.setAdminName(request.getParameter("adminname"));
            admin.setAdminPwd(request.getParameter("adminpwd"));
            System.out.println("修改前"+admin);
            admin = service.updateUser(admin);
            System.out.println("修改完之后"+admin);
            if (admin == null)
                request.setAttribute("message","修改成功");
            else
                request.setAttribute("message","修改失败");
            request.setAttribute("admin",admin);
            request.getRequestDispatcher("/AdminServlet?opr=show&id="+admin.getAdminId()).forward(request,response);
        }else if ("list".equals(opr)){      //展示所有用户信息
            userList = service.listUser();
            request.setAttribute("userList",userList);
            request.getRequestDispatcher("admin/admin.jsp").forward(request,response);
        }
    }
}
