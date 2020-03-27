package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckGroup;
import com.itheima.health.service.CheckGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.health.common.MessageConst;

import java.util.ArrayList;
import java.util.List;
/**
 * @author:yixiaolan
 * @date:Created in 2020/3/26
 * @description:
 * @version:1.0
 */

/**
 * 检查组管理
 */
@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {
    @Reference
    private CheckGroupService checkGroupService;

    //新增
    @RequestMapping("/add.do")
    public Result add(@RequestBody CheckGroup checkGroup, Integer[] checkitemsIds){
        try {
            checkGroupService.add(checkGroup,checkitemsIds);
        }catch (Exception e){
            //新增失败
            return new Result(false,MessageConst.ADD_CHECKGROUP_FAIL);
        }
        //新增成功
        return new Result(true,MessageConst.ADD_CHECKGROUP_SUCCESS);
    }

    //分页查询
    @RequestMapping("/findPage.do")
    public PageResult findPage(@RequestBody QueryPageBean pageBean){
        PageResult pageResult = null;
        try{
            pageResult = checkGroupService.pageQuery(pageBean.getCurrentPage(),pageBean.getPageSize(),pageBean.getQueryString());
        }catch(Exception e){
            e.printStackTrace();
            pageResult = new PageResult(0L,new ArrayList());
        }
        return pageResult;
    }
    /**
     * 基于ID获取检查组数据
     * @param id 检查组ID
     * @return
     */
    @RequestMapping("/findById.do")
    public Result findById(Integer id){

        try{
            CheckGroup checkGroup = checkGroupService.findById(id);
            return new Result(true,MessageConst.ACTION_SUCCESS,checkGroup);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false,MessageConst.ACTION_FAIL);
        }
    }

    /**
     * 基于检查组I的，获取检查项选中列表
     * @param id
     * @return
     */
    @RequestMapping("/findCheckItemIdsByCheckGroupId.do")
    public Result findCheckItemIdsByCheckGroupId(Integer id){
        try{
            List<Integer> list = checkGroupService.findCheckItemsByCheckGroupId(id);
            return  new Result(true,MessageConst.ACTION_SUCCESS,list);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false,MessageConst.ACTION_FAIL);
        }
    }
    /**
     * 编辑检查组数据
     * @param checkGroup 检查组基本信息
     * @param checkitemIds 选中的检查项列表
     * @return
     */
    @RequestMapping("/edit.do")
    public Result edit(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        try{
            checkGroupService.edit(checkGroup,checkitemIds);
            return new Result(true,MessageConst.EDIT_CHECKGROUP_SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false,MessageConst.EDIT_CHECKGROUP_FAIL);
        }
    }

}