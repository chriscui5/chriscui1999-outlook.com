package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.health.dao.CheckItemDao;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author GreenBean
 * @Date Class created on 2020/3/25
 * @Description 检查项业务实现类
 * @Version 1.0
 */
@Service
@Transactional
@Slf4j
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public void add(CheckItem item) {
        log.debug("CheckItemServiceImpl checkItem:{}",item);
        checkItemDao.add(item);
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        Page<CheckItem> page = checkItemDao.selectByCondition(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
            // 检查检查组是否有检查项数据
            Long count = checkItemDao.countCheckItemsById(id);
            // 如果有，抛出异常包含异常信息的异常
            if (count > 0){
                throw new RuntimeException("当前检查项有数据，不能删除");
            }
            checkItemDao.deleteCheckItemById(id);
    }

    /**
     * 编辑数据
     * @param checkItem
     */
    @Transactional
    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }

    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }

    /**
     * 获取某一数据
     * @param id 数据ID
     * @return 对象
     */
    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }
}
