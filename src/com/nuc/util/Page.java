package com.nuc.util;


import java.util.List;

public class Page {
    //总页数
    private  int totalPageCout=0;
    //页面大小，即每页显示记录数
    private int pageSize=12;
    //总记录数
    private int totalCount=0;
    //当前页码
    private int currPageNo=0;

    public int getTotalPageCout() {
        return totalPageCout;
    }

    public void setTotalPageCout(int totalPageCout) {
        this.totalPageCout = totalPageCout;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize>0) {
            this.pageSize = pageSize;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount>0){
            this.totalCount = totalCount;
            //计算总页数
            totalPageCout=this.totalCount%pageSize==0?(this.totalCount/pageSize):(this.totalCount/pageSize+1);
        }

    }

    public int getCurrPageNo() {
        if (totalPageCout==0){
            return  0;
        }
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        if (currPageNo>0) {
            this.currPageNo = currPageNo;
        }
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalPageCout=" + totalPageCout +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", currPageNo=" + currPageNo +
                '}';
    }
}
