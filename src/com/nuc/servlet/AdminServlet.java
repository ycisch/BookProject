package com.nuc.servlet;

import com.nuc.entiy.Admin;
import com.nuc.entiy.Book;
import com.nuc.entiy.User;
import com.nuc.service.AdminService;
import com.nuc.service.OrderService;
import com.nuc.service.UserService;
import com.nuc.service.impl.AdmainServiceImpl;
import com.nuc.service.impl.OrderServiceImpl;
import com.nuc.service.impl.UserServiceImpl;
import com.nuc.util.Date;
import com.nuc.util.FileUpload;
import com.nuc.util.Page;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: AdminServlet
 * Function:  查询用户，删除用户，管理员登录，修改管理员信息
 * Date:      2019/7/17 21:01
 * author     yinchen&wy&ry&wcr
 * version    V1.0
 */
public class AdminServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        /**
         * @param admin     管理员信息
         * @param userList  存储用户信息
         * @param service   AdminService
         * @param opr       判断参数--执行那一部分
         */
        Admin admin = new Admin();
        List<User> userList = new ArrayList<>();
        AdminService service = new AdmainServiceImpl();
        String opr = request.getParameter("opr");

        /**
         * @description 管理员登录
         */
        if ("login".equals(opr)){

            //拿到管理员姓名与密码
            admin.setAdminName(request.getParameter("adminname"));
            admin.setAdminPwd(request.getParameter("adminpwd"));

            //管理员登录
            admin = service.login(admin);


            if (admin == null)
            {
                request.setAttribute("message","登陆失败");
                request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request,response);
            }
            else
            {
                //存储二级标签信息
                Date.MAP = new ArrayList<>();
                Date.MAP_TWO = new HashMap<>();
                OrderService orderService = new OrderServiceImpl();
                orderService.listStyle();
                request.getSession().setAttribute("admin",admin);
                request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request,response);
            }
        }

        /**
         * @description 展示管理员个人信息
         */
        if ("show".equals(opr)){
            admin = (Admin) request.getSession().getAttribute("admin");
            admin = service.getUser(admin);
            request.setAttribute("admin",admin);
            request.getRequestDispatcher("/WEB-INF/views/admin/admin-info.jsp").forward(request,response);
        }

        /**
         * @description         修改管理员个人信息
         * @param admin         session域中的管理员信息
         * @param adminpwd      管理员密码
         */
        if ("update".equals(opr)){
            admin = (Admin) request.getSession().getAttribute("admin");

            String adminpwd = request.getParameter("adminpwd");

            if (admin.getAdminPwd().equals(adminpwd)){
                if (request.getParameter("repwd").equals(request.getParameter("newpwd"))){
                    admin.setAdminPwd(request.getParameter("newpwd"));
                    admin = service.updateUser(admin);
                    request.setAttribute("admin",admin);
                }
            }
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
        }
        /**
         * @description         查询所有用户信息
         * @param admin         session域中的管理员信息
         * @param adminpwd      管理员密码
         * @param page          用户进行分页处理
         * @param currPageNo    当前页数
         * @param
         */
        if ("list".equals(opr)){
            Page page = new Page();
//          int currPageNo = Integer.parseInt(request.getParameter("currPageNo"));

            //设置分页中需要的数据
//            page.setCurrPageNo(currPageNo);
//            page.setTotalCount(service.userCount());

            //查看所有用户
            userList = service.listUser();


            for (User user : userList) {
                System.out.println(user);
            }

            request.setAttribute("userList",userList);
            request.getRequestDispatcher("/WEB-INF/views/admin/user-list.jsp").forward(request,response);
        }
        /**
         * @description         删除用户
         * @param user          用户对象
         */
        if ("delete".equals(opr)){
            User user = new User();

            //拿到前台获取的id
            user.setId(Integer.parseInt(request.getParameter("id")));
            service.deleteUser(user);
            request.getRequestDispatcher("/AdminServlet?opr=list").forward(request,response);
        }
        /**
         * @description         前台验证----管理员登录验证
         * @param adminname     管理员名字
         * @param adminpwd      管理员密码
         * @param printwriter   输出流
         * @author              wy
         */
        if ("test".equals(opr)){
            String adminname = request.getParameter("adminname");
            String adminpwd = request.getParameter("adminpwd");
            PrintWriter printWriter = response.getWriter();

            //判断用户名密码是否正确
            boolean testPwd = service.testPwd(adminname, adminpwd);

            System.out.println(adminname+"   "+adminpwd+"   "+testPwd);
            if (testPwd){
                printWriter.print("true");
                printWriter.flush();
                printWriter.close();
            }else {
                printWriter.print("false");
                printWriter.flush();
                printWriter.close();
            }
        }

        if("adduser".equals(opr)){
            request.getRequestDispatcher("/WEB-INF/views/admin/user-add.jsp").forward(request,response);
        }

        if("updateuser".equals(opr)){


            User user = new User();
            user.setId(Integer.parseInt(request.getParameter("id")));
            System.out.println(user+"@@@");
            UserService userService = new UserServiceImpl();

            user = userService.getUser(user);
            System.out.println(user+"@@@@######@@");
            request.setAttribute("user",user);
            request.getRequestDispatcher("/WEB-INF/views/admin/user-edit.jsp").forward(request,response);
        }

        if("update-user".equals(opr)){
            User user = new User();
            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));
            user.setAddress(request.getParameter("address"));
            user.setPhone(request.getParameter("phone"));
            UserService userservice = new UserServiceImpl();
            user = userservice.updateUser(user);
            if (user == null)
                request.setAttribute("message","修改失败");
            else{
                request.setAttribute("message","修改成功");
                request.setAttribute("user",user);
            }
            request.getRequestDispatcher("/WEB-INF/views/admin/user-list.jsp").forward(request,response);
        }

        if("add".equals(opr)){
            System.out.println("进来了？");
            User user = new User();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));
            user.setPhone(request.getParameter("phone"));
            user.setAddress(request.getParameter("address"));
            user.setImg(request.getParameter("userImg"));

            UserService userService = new UserServiceImpl();
            userService.regist(user);

            request.getRequestDispatcher("/AdminServlet?opr=list").forward(request,response);
        }

    }
}
