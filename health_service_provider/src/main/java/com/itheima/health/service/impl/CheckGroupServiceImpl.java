package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.health.dao.CheckGroupDao;
import com.itheima.health.entity.PageResult;
import com.itheima.health.pojo.CheckGroup;
import com.itheima.health.service.CheckGroupService;
import com.itheima.health.service.CheckItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author GreenBean
 * @Date Class created on 2020/3/26
 * @Description check group service implementations
 * @Version 1.0
 */
@Service
@Slf4j
public class CheckGroupServiceImpl implements CheckGroupService {

    @Autowired
    private CheckGroupDao checkGroupDao;

    @Transactional
    @Override
    public void add(CheckGroup checkGroup, Integer[] checkItemIds) {
        checkGroupDao.add(checkGroup);
        log.debug("CHECKGROUP ID:{}",checkGroup.getId());

        for(Integer checkItemId : checkItemIds){
            Map<String,Integer> m = new HashMap<>();
            m.put("checkgroup_id",checkGroup.getId());
            m.put("checkitem_id",checkItemId);
            checkGroupDao.addCheckGroupAndCheckItem(m);
        }

    }

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckGroup> groups = checkGroupDao.selectByCondition(queryString);
        return new PageResult(groups.getTotal(),groups.getResult());
    }

    @Override
    public CheckGroup findById(Integer id) {
        log.debug("findById:{}",id);
        return checkGroupDao.findById(id);
    }

    @Override
    public List<Integer> findCheckItemsByCheckGroupId(Integer id) {
        return checkGroupDao.findCheckItemIdsByCheckGroupId(id);
    }

    @Transactional
    @Override
    public void edit(CheckGroup checkGroup, Integer[] checkItemIds) {
        log.debug("edit:{},{}",checkGroup,checkItemIds);
        checkGroupDao.edit(checkGroup);
        checkGroupDao.deleteCheckItemsListByCheckGroupId(checkGroup.getId());
        for (Integer checkItemId:checkItemIds){
            Map<String,Integer> maps= new HashMap<>();
            maps.put("checkgroup_id",checkGroup.getId());
            maps.put("checkitem_id",checkItemId);
            checkGroupDao.addCheckGroupAndCheckItem(maps);
        }
    }
}
