package com.nuc.servlet;

import com.nuc.entiy.Book;
import com.nuc.entiy.Shop;
import com.nuc.entiy.User;
import com.nuc.service.ShopService;
import com.nuc.service.impl.ShopServiceImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ShopServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String opr = request.getParameter("opr");
        System.out.println(opr);

        ShopService shopService = new ShopServiceImpl();
        User user = (User) request.getSession().getAttribute("user");
        Shop shop = new Shop();
        Book book = new Book();
        if(opr.equals("list")){

            //查看用户所有购物记录
            List<Shop> list = shopService.listShop(user);
            request.setAttribute("list",list);
        }else if(opr.equals("add")){

            //添加书籍到购物车
            book.setBookid(Integer.parseInt(request.getParameter("bookid")));
            book.setBookNum(1);
            shopService.addShop(book,user);
        }else if(opr.equals("delete")){

            //删除购物某一栏
            shop.setShopId(Integer.parseInt(request.getParameter("shopid")));
            shopService.deleteShop(shop,user);
        }else if(opr.equals("update")){

            //修改购物车信息
            shop.setShopId(Integer.parseInt(request.getParameter("shopid")));
            shopService.updateShop(shop,user);
        }else if(opr.equals("sum")){
            String ids[] = request.getParameterValues("ids");
            System.out.println(Arrays.toString(ids));
            //点击清算之后
            shopService.sumMoney(user,ids);

        }else  if(opr == "add1"){
            book.setBookNum(1);
            book.setBookid(Integer.parseInt(request.getParameter("bookid")));
            shopService.addShop(book,user);

        }else if(opr == "delete1"){
            book.setBookNum(-1);
            book.setBookid(Integer.parseInt(request.getParameter("bookid")));
            shopService.addShop(book,user);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println(request.getParameter("opr"));
        doPost(request,response);
    }
}
