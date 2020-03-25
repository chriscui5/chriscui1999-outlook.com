package com.itheima.health.dao;

import com.github.pagehelper.Page;
import com.itheima.health.pojo.CheckItem;
import org.apache.ibatis.annotations.Param;

public interface CheckItemDao {

    void add(CheckItem checkItem);
    /**
     * 基于分页插件进行分页查询
     * @param queryString
     * @return
     */
    Page<CheckItem> selectByCondition(@Param("queryString") String queryString);
    /**
     * 基于检查项ID，查询是否有关联数据
     * @param checkItemId 检查项ID
     * @return
     */
    Long countCheckItemsById(@Param("checkItemId") Integer checkItemId);

    /**
     * 基于ID删除
     * @param id 检查项ID
     */
    void deleteCheckItemById(@Param("id") Integer id);
    /**
     * 基于ID，获取数据
     * @param id ID
     * @return 对象
     */
    public CheckItem findById(Integer id);
    /**
     * 更新检查项
     * @param checkItem
     */
    public void edit(CheckItem checkItem);
}
