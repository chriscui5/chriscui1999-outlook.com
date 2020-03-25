package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.common.MessageConst;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:yixiaolan
 * @date:Created in 2020/3/25
 * @description:
 * @version:1.0
 */
@RestController
@Slf4j
@RequestMapping("/checkitem")
@CrossOrigin
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;

    /**
     * 新增检查项
     *  1.调用Service完成新增业务
     *  2.成功，返回添加成功消息
     *  3.失败，返回添加失败消息
     * @param checkItem
     * @return
     */
    @RequestMapping("/add.do")
    public Result add(@RequestBody  CheckItem checkItem){
        log.debug("add:{}",checkItem);
        try{
            // 调用Service完成新增业务
            if(checkItemService != null) {
                checkItemService.add(checkItem);
                // 成功，返回添加成功消息
                return new Result(true, MessageConst.ADD_CHECKITEM_SUCCESS);
            }else{
                log.debug("checkItemService is null ,未找到服务对象");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        // 失败，返回添加失败消息
        return new Result(false,MessageConst.ADD_CHECKITEM_FAIL);
    }

    /**
     * 分页查询
     *  1.调用Service获取分页结果数据
     *  2.成功，直接返回有内容的结果
     *  3.失败，返回初始化结果，记录为0，数据为空
     * @param queryPageBean
     * @return
     */
    @RequestMapping("/findPage.do")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        log.debug("queryBean:{}",queryPageBean);
        try{
            // 调用Service获取分页结果数据
            PageResult pageResult = checkItemService.pageQuery(queryPageBean);
            // 成功，直接返回有内容的结果
            return pageResult;
        }catch(Exception e){
            e.printStackTrace();
        }
        // 失败，返回初始化结果，记录为0，数据为空
        return new PageResult(0L,null);
    }
    /**
     * 基于ID，删除检查项
     *  1.调用Service删除检查项
     *  2.成功，返回预定义成功消息
     *  3.失败，返回异常消息
     * @param id
     * @return
     */
    @RequestMapping("/delete.do")
    public Result delete(Integer id){
        try{
            // 调用Service删除检查项
            checkItemService.deleteById(id);
            // 成功，返回预定义成功消息
            return new Result(true,MessageConst.DELETE_CHECKITEM_SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            // 失败，返回异常消息
            return new Result(false,e.getMessage());
        }
    }
    /**
     * 基于ID，获取检查项数据
     * 1. 调用Service,基于ID获取检查项对象
     * 2. 成功，返回检查项对象数据
     * 3. 失败，返回操作失败消息
     * @param id 检查项ID
     * @return
     */
    @RequestMapping("/findById.do")
    public Result findById(Integer id){
        try{
            // 调用Service,基于ID获取检查项对象
            CheckItem checkItem = checkItemService.findById(id);
            // 成功，返回检查项对象数据
            return new Result(true,MessageConst.ACTION_SUCCESS,checkItem);
        }catch(Exception e){
            e.printStackTrace();
            // 失败，返回操作失败消息
            return new Result(false,MessageConst.ACTION_FAIL);
        }
    }

    /**
     * 基于ID，更新检查项数据
     * 1.调用Service，更新数据
     * 2.成功，返回编辑成功消息
     * 3.失败，返回编辑失败消息
     * @param checkItem 检查项表单数据
     * @return
     */
    @RequestMapping("/edit.do")
    public Result edit(@RequestBody  CheckItem checkItem){
        try{
            log.debug("edit checkItem:{}",checkItem);
            // 调用Service，更新数据
            checkItemService.edit(checkItem);
            // 成功，返回编辑成功消息
            return new Result(true,MessageConst.EDIT_CHECKITEM_SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            // 失败，返回编辑失败消息
            return new Result(false,MessageConst.EDIT_CHECKITEM_FAIL);
        }
    }
}
