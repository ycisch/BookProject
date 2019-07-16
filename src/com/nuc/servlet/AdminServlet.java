package com.nuc.servlet;

import com.nuc.entiy.Admin;
import com.nuc.entiy.User;
import com.nuc.service.AdminService;
import com.nuc.service.OrderService;
import com.nuc.service.impl.AdmainServiceImpl;
import com.nuc.service.impl.OrderServiceImpl;
import com.nuc.util.Date;
import com.nuc.util.FileUpload;
import com.nuc.util.Page;

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
        Admin admin = new Admin();
        List<User> userList = new ArrayList<>();
        AdminService service = new AdmainServiceImpl();
        String opr = request.getParameter("opr");
        System.out.println(request.getParameter("opr"));
        if ("login".equals(opr)){       //管理员登录
            admin.setAdminName(request.getParameter("adminname"));
            admin.setAdminPwd(request.getParameter("adminpwd"));
            admin = service.login(admin);
            if (admin == null)
            {
                request.setAttribute("message","登陆失败");
                request.getRequestDispatcher("admin/adminlogin.jsp").forward(request,response);
            }
            else
            {
                OrderService orderService = new OrderServiceImpl();
                orderService.listStyle();
                request.getSession().setAttribute("admin",admin);
                request.getRequestDispatcher("BookServlet?opr=welcome&page=1").forward(request,response);
            }
        }else if ("show".equals(opr)){      //展示管理员信息
            admin = (Admin) request.getSession().getAttribute("admin");
            admin = service.getUser(admin);
            request.setAttribute("admin",admin);
            request.getRequestDispatcher("admin/admin_info.jsp").forward(request,response);
        }else if ("update".equals(opr)){        //修改管理员信息
            admin = (Admin) request.getSession().getAttribute("admin");
//            admin.setAdminId(admin.getAdminId());
            System.out.println(admin);
            System.out.println(request.getParameter("adminpwd"));
            System.out.println(request.getParameter("newpwd"));
            System.out.println(request.getParameter("repwd"));
            if (admin.getAdminPwd().equals(request.getParameter("adminpwd"))){
                if (request.getParameter("repwd").equals(request.getParameter("newpwd"))){
                    admin.setAdminPwd(request.getParameter("newpwd"));
                    admin = service.updateUser(admin);
                    System.out.println(admin);
                    request.setAttribute("admin",admin);
                }
            }

//            if (admin == null)
//                request.setAttribute("message","修改成功");
//            else
//                request.setAttribute("message","修改失败");

            request.getRequestDispatcher("BookServlet?opr=welcome&page=1").forward(request,response);
        }else if ("list".equals(opr)){      //展示所有用户信息
            Page page = new Page();
            int currPageNo = Integer.parseInt(request.getParameter("currPageNo"));

            page.setCurrPageNo(currPageNo);
            page.setTotalCount(service.userCount());
            userList = service.listUser(page);
//            for (User user: userList)
//            {
//                System.out.println(user);
//            }
            request.setAttribute("userList",userList);
            request.setAttribute("page",page);
            request.getRequestDispatcher("admin/admin_userlist.jsp").forward(request,response);
        }else if ("delete".equals(opr)){
            User user = new User();
            user.setId(Integer.parseInt(request.getParameter("id")));
            System.out.println(request.getParameter("id"));
            service.deleteUser(user);
            request.getRequestDispatcher("/AdminServlet?opr=list&currPageNo=1").forward(request,response);
        }
    }
}
