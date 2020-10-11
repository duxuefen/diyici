package com.iflytek.vuedemo.pojo;

public class Page {
    private Integer total;
    private Integer pagenum = 1;
    private Integer pagesize = 5;

    private Object data;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", pagenum=" + pagenum +
                ", pagesize=" + pagesize +
                ", data=" + data +
                '}';
    }
}
