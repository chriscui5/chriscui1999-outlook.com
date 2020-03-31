package com.itheima.health.service;

import com.itheima.health.entity.PageResult;
import com.itheima.health.pojo.Setmeal;

public interface SetmealService {
    /**
     * 添加体验套餐
     * @param setmeal 体检套餐基本信息
     * @param checkgroupIds 检查组选定列表
     */
    public void add(Setmeal setmeal, Integer[] checkgroupIds);
    /**
     * 分页获取套餐数据
     * @param currentPage 当前页码
     * @param pageSize 默认条数
     * @param queryString 查询条件
     * @return
     */
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
}
