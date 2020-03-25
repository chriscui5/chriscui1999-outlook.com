package com.itheima.health.entity;

/**
 * @author:yixiaolan
 * @date:Created in 2020/3/25
 * @description:
 * @version:1.0
 */

import lombok.ToString;

import java.io.Serializable;

/**
 * 封装查询条件
 */
@ToString
public class QueryPageBean implements Serializable {
    private Integer currentPage;//页码
    private Integer pageSize;//每页记录数
    private String queryString;//查询条件

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }
}