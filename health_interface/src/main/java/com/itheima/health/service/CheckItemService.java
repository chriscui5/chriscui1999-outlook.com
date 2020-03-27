package com.itheima.health.service;

import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.pojo.CheckItem;

import java.util.List;

/**
 * 检查项服务接口
 */
public interface CheckItemService {
    /**
     * 新增检查项
     * @param checkItem
     */
    void add(CheckItem checkItem);
    PageResult pageQuery(QueryPageBean queryPageBean);
    /**
     * 基于ID，删除检查项
     * @param id
     */
    void deleteById(Integer id);
    /**
     * 获取某一数据
     * @param id 数据ID
     * @return 对象
     */
    public CheckItem findById(Integer id);
    /**
     * 编辑数据
     * @param checkItem
     */
    public void edit(CheckItem checkItem);
    /**
     * 获取检查项列表
     * @return
     */
    List<CheckItem> findAll();
}