package com.nuc.util.PageTest;

/**
 * 工具类 线程作用域的变量
 * threadLocal
 *
 * @author 86139
 *
 */
public class SystemContext {

    public static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
    public static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

    public static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();

    public static int getPageIndex() {
        return pageIndex.get();
    }

    public static void setPageIndex(int _pageIndex) {
        pageIndex.set(_pageIndex);
    }

    public static void removePageIndex() {
        pageIndex.remove();
    }

    public static int getPageSize() {
        return pageSize.get();
    }

    public static void setPageSize(int _pageSize) {
        pageSize.set(_pageSize);
    }

    public static void removePageSize() {
        pageSize.remove();
    }

    public static int getPageOffset() {
        return pageOffset.get();
    }

    public static void setPageOffset(int _pageOffset) {
        pageOffset.set(_pageOffset);
    }

    public static void removePageOffset() {
        pageOffset.remove();
    }

}