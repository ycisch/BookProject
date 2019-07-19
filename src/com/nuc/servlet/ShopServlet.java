package com.nuc.servlet;

import com.nuc.entiy.Book;
import com.nuc.entiy.Shop;
import com.nuc.entiy.User;
import com.nuc.service.BookService;
import com.nuc.service.ShopService;
import com.nuc.service.impl.BookServiceImpl;
import com.nuc.service.impl.ShopServiceImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/**
 * ClassName: ShopServlet
 * Function:  查看购物车信息  修改购物车信息  删除购物车信息
 * Date:      2019/7/17 21:01
 * author     yinchen&wy&ry&wcr
 * version    V1.0
 */
public class ShopServlet extends javax.servlet.http.HttpServlet {

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws IOException
     */
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String opr = request.getParameter("opr");

        BookService bookService = new BookServiceImpl();
        ShopService shopService = new ShopServiceImpl();
        User user = (User) request.getSession().getAttribute("user");
        Shop shop = new Shop();
        Book book = new Book();

        /**
         * @description                 查看用户购物记录
         * @param
         */
        if(opr.equals("list")){

            List<Shop> list = shopService.listShop(user);
            int id = 0;
            for (Shop shop1: list) {
                Book book1 = new Book();
                int num = shop1.getBookId();
                book1.setBookid(num);
                bookService.selectBook(book1);
                book1.setBookAuthor(book1.getBookMoney()*shop1.getNum()+"");
                System.out.println(book1);
                shop1.setBook(book1);
                shop1.setUser(user);
                shop1.setNumid(id);
                id++;
            }

            request.setAttribute("list",list);
            request.getRequestDispatcher("user/shopCart.jsp").forward(request,response);
        }
        /**
         * @description                 添加书籍到购物车
         * @param
         */
        if(opr.equals("add")){
            book.setBookid(Integer.parseInt(request.getParameter("bookid")));
            book.setBookNum(1);
            shopService.addShop(book,user);
            request.getRequestDispatcher("BookServlet?opr=keyList&style1=style&style=2&page=1").forward(request,response);
        }
        /**
         * @description                 删除购物车的一栏
         */
        if(opr.equals("delete")){
            shop.setShopId(Integer.parseInt(request.getParameter("shopid")));
            System.out.println(shop);
            shopService.deleteShop(shop,user);
        }
        /**
         * @description                 修改购物车信息
         */
        if(opr.equals("update")){
            //修改购物车信息
            shop.setShopId(Integer.parseInt(request.getParameter("shopid")));
            shopService.updateShop(shop,user);
        }
        /**
         * @description                 结算
         */
        if(opr.equals("sum")){
            String ids[] = request.getParameter("ids").split(",");
//            System.out.println(ids.length+"   "+Arrays.toString(ids));
            //点击清算之后
            shopService.sumMoney(user,ids);

        }
        /**
         * @description                 加一
         */
        if(opr.equals("add1")){
            book.setBookNum(1);
            book.setBookid(Integer.parseInt(request.getParameter("bookid")));
            shopService.addShop(book,user);

        }
        /**
         * @description                 减一
         */
        if(opr.equals("delete1")){
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
