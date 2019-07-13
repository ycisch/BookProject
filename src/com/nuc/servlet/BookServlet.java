package com.nuc.servlet;

import com.nuc.entiy.Book;
import com.nuc.service.BookService;
import com.nuc.service.impl.BookServiceImpl;
import com.nuc.util.FileUpload;
import com.nuc.util.Page;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BookServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        BookService bookService = new BookServiceImpl();
        Book book = null;
        List<Book> bookList = new ArrayList<Book>();
        String opr = request.getParameter("opr");
        System.out.println(request.getParameter("style"));
        if ("welcome".equals(opr)) {                                                  /*首页展示图书*/

            bookList = bookService.listBook();                                              //查询所有放到bookList
            request.setAttribute("bookList",bookList);                             //存放所有图书到request
            request.getRequestDispatcher("system/menu.jsp").forward(request,response);  //跳回首页

        }else if ("list".equals(opr)){                                               /*后台所有展示图书*/

            bookList = bookService.listBook();                                              //查询所有放到bookList
            request.setAttribute("bookList",bookList);                             //存放所有图书到request
            request.getRequestDispatcher("admin/admin.jsp").forward(request,response);  //跳回后台页面

        }else if ("update".equals(opr)){                                            /*更新图书*/

            book = (Book) request.getAttribute("book");                                 //获取需要修改的图书对象
            if (bookService.updateBook(book)){                                             //执行修改并判断是否修改成功
                request.setAttribute("message","修改成功！");
            }else {
                request.setAttribute("message","修改失败！");
            }
            bookList = bookService.listBook();                                              //查询所有放到bookList
            request.setAttribute("bookList",bookList);                             //存放所有图书到request
            request.getRequestDispatcher("admin/admin.jsp").forward(request,response);  //跳回后台页面

        } else if ("add".equals(opr)) {                                             /*添加图书*/

            book = new Book();
            book.setBookid(Integer.parseInt(request.getParameter("bookId")));
            if (bookService.addBook(book)){                                                //执行添加并判断是否添加成功
                request.setAttribute("message","添加成功！");
            }else {
                request.setAttribute("message","添加失败！");
            }
            bookList = bookService.listBook();                                              //查询所有放到bookList
            request.setAttribute("bookList","bookList");                             //存放所有图书到request
            request.getRequestDispatcher("admin/admin.jsp").forward(request,response);  //跳回后台页面

        }else if ("del".equals(opr)){                                               /*按ID删除图书*/

            book = new Book();
            book.setBookid(Integer.parseInt(request.getParameter("bookId")));
            book.setBookName(request.getParameter("bookName"));
            book.setBookAuthor(request.getParameter("bookAuthor"));
            book.setBookInfo(request.getParameter("bookInfo"));
            book.setBookMoney(Integer.parseInt(request.getParameter("bookMoney")));
            book.setBookNum(Integer.parseInt(request.getParameter("bookNum")));
            book.setBookStyle(request.getParameter("bookStyle"));

            if (bookService.deleteBook(book)){                                              //执行删除并判断是否删除成功
                request.setAttribute("message","删除成功！");
            }else {
                request.setAttribute("message","删除失败！");
            }
            bookList = bookService.listBook();                                              //查询所有放到bookList
            request.setAttribute("bookList","bookList");                             //存放所有图书到request
            request.getRequestDispatcher("admin/admin.jsp").forward(request,response);  //跳回后台页面

        }else if ("keyList".equals(opr)){                                           /*按条件查找图书*/

            //分页条件设置
            int currPageNo = Integer.parseInt(request.getParameter("page"));
            Page page = new Page();
            page.setCurrPageNo((currPageNo-1));
            book = new Book();
            book.setBookStyle("style");
            book.setBookName(request.getParameter("style"));//取得查询条件
            page.setTotalCount(bookService.sumBook(book));
            bookList = bookService.listBookKey(book,page);                                       //查询所有放到bookList
            request.setAttribute("type",book.getBookStyle());
            request.setAttribute("style",book.getBookName());
            request.setAttribute("page",page);
            request.setAttribute("bookList",bookList);                             //存放所有图书到request
            request.getRequestDispatcher("system/menu1.jsp").forward(request,response);
//            response.sendRedirect("./system/menu1.jsp");

        }else{
            response.setContentType("text/html;charset=utf-8");
            System.out.println(request.getParameter("name"));
            String s = FileUpload.getFileUpload(request.getSession().getServletContext().getRealPath("upload/"),request);
            System.out.println(s);
            s = s.replaceAll("\\\\", "/");
            System.out.println(s);
            int index = s.indexOf('_');
            s = s.substring(index+13,s.length());
            s = ".."+s;
            System.out.println(s);
            PrintWriter out=response.getWriter();
            out.print(s);
            out.flush();
            out.close();
        }

    }
}
