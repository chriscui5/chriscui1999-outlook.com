package com.itheima.health.service;

import com.itheima.health.entity.PageResult;
import com.itheima.health.pojo.CheckGroup;

import java.util.List;

/**
 * 检查组服务接口
 */
public interface CheckGroupService {
    /**
     * 添加检查组
     * @param checkGroup 检查组基本信息
     * @param checkItemIds 检查项ID列表
     */
    public void add(CheckGroup checkGroup, Integer[] checkItemIds);
    /**
     * 分页显示检查组
     * @param currentPage 当前页码
     * @param pageSize	  默认条数
     * @param queryString 查询条件
     * @return
     */
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
    /**
     * 基于ID，获取检查组对象
     * @param id 检查组ID
     * @return
     */
    CheckGroup findById(Integer id);

    /**
     * 基于检查组ID获取检查项ID列表
     * @param id
     * @return
     */
    List<Integer> findCheckItemsByCheckGroupId(Integer id);
    /**
     * 编辑检查组
     * @param checkGroup 检查基本数据
     * @param checkitemIds 检查项选择列表
     */
    public void edit(CheckGroup checkGroup,Integer[] checkitemIds);

}