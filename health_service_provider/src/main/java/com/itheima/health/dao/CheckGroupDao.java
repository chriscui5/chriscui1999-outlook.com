package com.itheima.health.dao;

import com.github.pagehelper.Page;
import com.itheima.health.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 持久层Dao接口
 */
public interface CheckGroupDao {
    /**
     * 添加检查组
     * @param checkGroup
     */
    void add(CheckGroup checkGroup);

    /**
     * 添加检查组的检查项
     * @param map
     */
    void   addCheckGroupAndCheckItem(Map map);

    Page<CheckGroup> selectByCondition(@Param("queryString") String queryString);
    /**
     * 获取某一项检查组数据
     * @param id
     * @return
     */
    CheckGroup findById(@Param("id") Integer id);

    /**
     * 获取某一检查组的检查项ID列表
     * @param id
     * @return
     */
    List<Integer> findCheckItemIdsByCheckGroupId(@Param("id")Integer id);
    /**
     * 基于ID，更新检查组基本信息
     * @param checkGroup
     */
    void edit(CheckGroup checkGroup);

    /**
     * 基于检查组ID，删除与之关联的检查项
     * @param id
     */
    void deleteCheckItemsListByCheckGroupId(@Param("id")Integer id);
    /**
     * 获取所有检查组数据
     * @return
     */
    List<CheckGroup> findAll();
}