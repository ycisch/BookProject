package com.nuc.servlet;

import com.nuc.entiy.Shop;
import com.nuc.entiy.User;
import com.nuc.service.ShopService;
import com.nuc.service.impl.ShopServiceImpl;

import java.io.IOException;
import java.util.List;

public class ShopServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String opr = request.getParameter("opr");

        ShopService shopService = new ShopServiceImpl();
        User user = (User) request.getSession().getAttribute("user");
        Shop shop = new Shop();
        if(opr == "list"){
            List<Shop> list = shopService.listShop(user);
            request.setAttribute("list",list);
        }else if(opr == "add"){


        }else if(opr == "delete"){

        }else if(opr == "update"){

        }else if(opr == "sum"){

        }
    }
/*
* wawawawawawqweqwewqe5956592562123213213asdasdasdsadsads
*
* */
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
