package com.aaa.controller;

import com.aaa.biz.MenuBiz;
import com.aaa.entity.LayUiTable;
import com.aaa.entity.LayUiTree;
import com.aaa.entity.Menu;
import com.aaa.util.ResultEntity;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 陈建
 * @Date: 2020/5/28 0028 6:59
 * @Version 1.0
 */
@Controller

public class MenuController {
    @Autowired
    private MenuBiz menuBiz;
    @RequestMapping("/menu/toShowMenu")
    public String toShowMenu() {
        return "menu/showMenu";
    }
    @RequestMapping("/menu/selectAllMenu")
    @ResponseBody
    public List<LayUiTree> selectAllMenu(){
        List<LayUiTree> layUiTrees = menuBiz.selectAllMenu();
        return layUiTrees;
    }
    
//	根据关键字查询数据并且分页显示
	@RequestMapping("/show/menu")      //接口路径
	@ResponseBody
	public LayUiTable showmenuInfo(
			@RequestParam(value="page", defaultValue="1") Integer page,    //第几页
			@RequestParam(value="limit", defaultValue="5") Integer limit,   //一页几条数据
			@RequestParam(value="visible", defaultValue="-1") Integer visible,  //查询条件菜单状态，如果没有就不用传输该数据
			@RequestParam(value="menuName", defaultValue="") String menuName    //查询条件菜单名字，如果没有就不用传输该数据
			) {
        //开始查询
        PageInfo<Menu> pageInfo = menuBiz.showMenuInfo(page, limit,visible,menuName);
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        //设置分页之后的返回值
        layUiTable.setCount(pageInfo.getTotal());
        layUiTable.setData(pageInfo.getList());
        return layUiTable;
    }
	@RequestMapping("/add/menu")
	@ResponseBody
	public ResultEntity<Menu> addMenu(Menu menu)
	{
		menuBiz.addMenu(menu);
		return ResultEntity.successWithoutData();
	}


	@RequestMapping("/delete/menu")
	@ResponseBody
	public ResultEntity<Menu> deleteMenu(@RequestParam(value="menuId") Integer menuID)
	{
		menuBiz.deleteMenu(menuID);
		return ResultEntity.successWithoutData();
	}
	
	@RequestMapping("/update/menu")
	public ResultEntity<Menu> updateMenu(Menu menu)
	{
		menuBiz.updateMenu(menu);
		return ResultEntity.successWithoutData();
	}
}
