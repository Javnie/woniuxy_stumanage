package com.woniuxy.vo;

import java.util.List;

public class PageBean<T> {
    private List<T> data; //一页数据
    private int totalPage; //总页数
    private int pageSize; //每页的数量

    public PageBean() {
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
