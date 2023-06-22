package com.pdd.wiki.resp;

import java.util.List;

public class PageResp<T> {
    /**
     * @total 总数
     * 列表数据 - 不确定 - 泛型（通用）
     */
    private Long total;
    private List<T> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String  toString() {
        return "PageResp{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}