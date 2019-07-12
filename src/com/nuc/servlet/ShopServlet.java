package com.nuc.servlet;

import java.io.IOException;

public class ShopServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String opr = request.getParameter("opr");
        if(opr == "list"){

        }else if(opr == "add"){

        }else if(opr == "delete"){

        }else if(opr == "update"){

        }else if(opr == "sum"){

        }
    }
/*
* wawawawawawqweqwewqe5956592562
*
* */
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
