package com.nuc.servlet;

import com.nuc.entiy.Book;
import com.nuc.entiy.Style;
import com.nuc.service.BookService;
import com.nuc.service.OrderService;
import com.nuc.service.impl.BookServiceImpl;
import com.nuc.service.impl.OrderServiceImpl;
import com.nuc.util.Date;
import com.nuc.util.FileUpload;
import com.nuc.util.Page;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: BookServlet
 * Function:  查询书籍 图片上传 按关键字查询书籍  修改书籍  删除书籍
 * Date:      2019/7/17 21:01
 * author     yinchen&wy&ry&wcr
 * version    V1.0
 */

public class BookServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        /**
         * @param bookService           图书Service
         * @param book                  保存图书信息
         * @param bookList              保存所有书籍信息
         * @param opr                   判断参数--执行那一部分
         * @param page                  分页处理
         */
        BookService bookService = new BookServiceImpl();
        Book book = null;
        List<Book> bookList = new ArrayList<Book>();
        String opr = request.getParameter("opr");

        /**
         * @description                 管理登录成功界面
         */
        if ("welcome".equals(opr)) {


            //设置书籍查询信息
            book = new Book();
            book.setBookStyle("1");
            bookList = bookService.listBook();
            request.setAttribute("bookList",bookList);
            request.getRequestDispatcher("admin/admin.jsp").forward(request,response);


        }
        /**
         * @description                 管理员查看所有图书
         */
        if ("list".equals(opr)){


            //Book对象
            book = new Book();
            book.setBookStyle("all");

            bookList = bookService.listBook();

            for(Book book1:bookList){
                System.out.println(book1);
            }

            //保存数据
            request.setAttribute("bookList",bookList);                             //存放所有图书到request
            request.getRequestDispatcher("/WEB-INF/views/book/book-list.jsp").forward(request,response);  //跳回后台页面

        }
        /**
         * @description                 更新图书
         */
        if ("update".equals(opr)){
            //获取需要修改的图书对象
            book = new Book();
            book.setBookid(Integer.parseInt(request.getParameter("bookId")));
            book.setBookName(request.getParameter("bookName"));
            book.setBookAuthor(request.getParameter("bookAuthor"));
            book.setBookInfo(request.getParameter("bookInfo"));
            book.setBookMoney(Float.parseFloat(request.getParameter("bookMoney")));
            book.setBookNum(Integer.parseInt(request.getParameter("bookNum")));
            book.setBookStyle(request.getParameter("bookStyle"));
            book.setBookimg(request.getParameter("bookImg"));
            book.setBookCategory(request.getParameter("bookCategory"));


            if (bookService.updateBook(book)){                                             //执行修改并判断是否修改成功
                request.setAttribute("message","修改成功！");
            }else {
                request.setAttribute("message","修改失败！");
            }

            //查询所有放到bookList
            request.setAttribute("bookList",bookList);                             //存放所有图书到request
            request.getRequestDispatcher("/BookServlet?opr=welcome&page=1").forward(request,response);  //跳回后台页面

        }
        /**
         * @description                 添加图书
         * @book                        书籍对象
         */
        if ("add".equals(opr)) {

            book = new Book();
            book.setBookid(Integer.parseInt(request.getParameter("bookId")));
            book.setBookName(request.getParameter("bookName"));
            book.setBookAuthor(request.getParameter("bookAuthor"));
            book.setBookInfo(request.getParameter("bookInfo"));
            book.setBookMoney(Integer.parseInt(request.getParameter("bookMoney")));
            book.setBookNum(Integer.parseInt(request.getParameter("bookNum")));
            book.setBookStyle(request.getParameter("bookStyle"));
            book.setBookCategory(request.getParameter("bookCategory"));
            book.setBookimg(request.getParameter("bookImg"));

            System.out.println(book+"@@@@");
            if (bookService.addBook(book)){                                                //执行添加并判断是否添加成功
                request.setAttribute("message","添加成功！");
            }else {
                request.setAttribute("message","添加失败！");
            }
            //查询所有放到bookList

            request.getRequestDispatcher("/BookServlet?opr=list").forward(request,response);  //跳回后台页面

        }
        /**
         * @description                 删除图书
         */
        if ("del".equals(opr)){
            //设置书籍对象
            book = new Book();
            book.setBookid(Integer.parseInt(request.getParameter("id")));
            if (bookService.deleteBook(book)){                                              //执行删除并判断是否删除成功
                request.setAttribute("message","删除成功！");
            }else {
                request.setAttribute("message","删除失败！");
            }

            request.getRequestDispatcher("/BookServlet?opr=welcome&page=1").forward(request,response);  //跳回后台页面

        }
        /**
         * @description               按关键字进行查询
         */
        if ("keyList".equals(opr)){

            book = new Book();
            if (request.getParameter("style").equals("id")){
                book.setBookStyle("id");
                book.setBookid(Integer.parseInt(request.getParameter("id")));
                bookList = bookService.listBookKey(book);
                book = bookList.get(0);
                request.setAttribute("book",book);
                request.getRequestDispatcher("admin/admin_update.jsp").forward(request,response);
            }else{
                book.setBookStyle("style");
                book.setBookName(request.getParameter("style"));//取得查询条件


                Date.MAP = new ArrayList<>();
                Date.MAP_TWO = new HashMap<>();
                OrderService orderService = new OrderServiceImpl();
                orderService.listStyle();

                bookList = bookService.listBookKey(book);
                request.setAttribute("type",book.getBookStyle());
                request.setAttribute("style",book.getBookName());
                request.setAttribute("style1",request.getParameter("style1"));
                request.setAttribute("bookList",bookList);
                request.getRequestDispatcher("system/menu1.jsp").forward(request,response);
            }
        }

        /**
         *@description               图片上传的时候显示图片
         */
        if ("img".equals(opr)){
            response.setContentType("text/html;charset=utf-8");
            System.out.println(request.getParameter("name"));
            String s = FileUpload.getFileUpload(request.getSession().getServletContext().getRealPath("upload/"),request);
            System.out.println(s);
            s = s.replaceAll("\\\\", "/");
            System.out.println(s);
            int index = s.indexOf('_');
            s = s.substring(index+13,s.length());
            s = "."+s;
            System.out.println(s);
            PrintWriter out=response.getWriter();
            out.print(s);
            out.flush();
            out.close();
        }

        if("addbook".equals(opr)){
            System.out.println("Test111");
            request.getRequestDispatcher("/WEB-INF/views/book/book-add.jsp").forward(request,response);
        }

        if("updatebook".equals(opr)){
            String bookid = request.getParameter("bookid");
            Book book1 = new Book();
            book1.setBookid(Integer.parseInt(bookid));
            bookService.selectBook(book1);

            request.setAttribute("book",book1);
            request.getRequestDispatcher("/WEB-INF/views/book/book-update.jsp").forward(request,response);
        }


    }
}
