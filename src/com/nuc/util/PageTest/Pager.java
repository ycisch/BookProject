package com.nuc.util.PageTest;

import java.util.List;

/**
 * ClassName: Pager
 * Function:  TODO
 * Date:      2019/7/18 21:09
 * author     Dell
 * version    V1.0
 */
public class Pager<E> {

    private int pageIndex;			//当前页号

    private int pageSize;			//每页条数

    private int pageOffset;			//每页的偏移量 从哪条开始

    private int totalRecords;		//总条数

    private int totalPages;			//总页数

    private List<E> datas;			//真正显示的数据的集合

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<E> getDatas() {
        return datas;
    }

    public void setDatas(List<E> datas) {
        this.datas = datas;
    }

}