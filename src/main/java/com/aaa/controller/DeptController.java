package com.aaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aaa.biz.DeptBiz;
import com.aaa.entity.Dept;
import com.aaa.entity.LayUiTable;
import com.aaa.util.ResultEntity;
import com.github.pagehelper.PageInfo;

@RestController
public class DeptController {

	@Autowired
	DeptBiz deptBiz;
//	根据关键字查询数据并且分页显示
	@RequestMapping("/show/dept")
	public LayUiTable showDeptInfo(
			@RequestParam(value="page", defaultValue="1") Integer page,
			@RequestParam(value="limit", defaultValue="5") Integer limit,
			@RequestParam(value="status", defaultValue="-1") Integer status,
			@RequestParam(value="deptName", defaultValue="") String deptName
			) {
        //开始查询
        PageInfo<Dept> pageInfo = deptBiz.showDeptInfo(page, limit,status,deptName);
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        //设置分页之后的返回值
        layUiTable.setCount(pageInfo.getTotal());
        layUiTable.setData(pageInfo.getList());
        return layUiTable;
    }
	@RequestMapping("/add/dept")
	public ResultEntity<Dept> addDept(Dept dept)
	{
		deptBiz.addDept(dept);
		return ResultEntity.successWithoutData();
	}
	
	@RequestMapping("/delete/dept")
	public ResultEntity<Dept> deleteDept(@RequestParam(value="deptId")Integer deptID)
	{
		deptBiz.deleteDept(deptID);
		return ResultEntity.successWithoutData();
	}
	
	@RequestMapping("/update/dept")
	public ResultEntity<Dept> updateDept(Dept dept)
	{
		deptBiz.updateDept(dept);
		return ResultEntity.successWithoutData();
	}
}
