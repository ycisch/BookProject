package com.nuc.Filter;

import com.nuc.util.PageTest.SystemContext;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



/**
 * 分页配置过滤器
 *
 */
public class SystemContextFilter implements Filter {

    private int pageSize;

    public void destroy() {

    }


    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        try{
            int pageOffset = 0;

            //初始进入列表页面的时候pager.offset是没有的，后期被pager-taglib标签库接管之后，是有的
            if(request.getParameter("pager.offset") != null)
            {
                pageOffset = Integer.parseInt(request.getParameter("pager.offset"));
            }

            System.out.println("起始条目为:"+pageOffset);

            // 在过滤器中设置好threadlocal变量值，这个值
            SystemContext.setPageOffset(pageOffset);
            SystemContext.setPageSize(this.pageSize);

            //去到真正请求的Servlet，也就是在去servelt之前已经设置好threadload变量
            chain.doFilter(request, response);
        }finally{

            //finallly是在response返回客户端时候才执行，这个时候，代渲染的html已经生成了 是作为HTTP协议 response的第4部分 响应正文
            //什么意思》？渲染好之后，线程中的pageoffset 一个是pageSize就没有用了 干掉
            SystemContext.removePageOffset();
            SystemContext.removePageSize();
        }

    }


    public void init(FilterConfig config) throws ServletException {
        try{
            pageSize = Integer.parseInt(config.getInitParameter("pageSize"));

        }catch(NumberFormatException e)
        {
            pageSize = 3;
        }
    }

}
