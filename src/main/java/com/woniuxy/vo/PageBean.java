package com.woniuxy.vo;
/**
 * VO（Value Object/View Object - 值对象/视图对象）
 * Value Object，值对象，也称为业务对象
 * 存活在业务层的，是业务逻辑使用的，它存活的目的就是为数据提供一个生存的地方（实际上跟DO有点类似）
 */

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
