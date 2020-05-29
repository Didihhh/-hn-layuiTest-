package com.aaa.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.biz.DeptBiz;
import com.aaa.dao.DeptMapper;
import com.aaa.entity.Dept;
import com.aaa.entity.MyUserInfo;
import com.aaa.util.ResultEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeptBizImpl implements DeptBiz{
	
	@Autowired
	DeptMapper deptMapper;

	@Override
	public PageInfo<Dept> showDeptInfo(int page, int limit,int status,String deptName) {
		 //开始分页,第一个参数是当前第几页，第二个参数是一页显示多少行
        PageHelper.startPage(page,limit);
        List<Dept> deptInfo = deptMapper.selectDeptInfo(status,deptName);
        //结束分页,pageInfo封装了分页之后所有数据
        PageInfo<Dept> pageInfo = new PageInfo<Dept>(deptInfo);
        return pageInfo;
	}
	@Override
	public void addDept(Dept dept) {
		// TODO Auto-generated method stub
		deptMapper.insert(dept);
	}

	@Override
	public void deleteDept(Integer deptID) {
		// TODO Auto-generated method stub
		deptMapper.deleteByPrimaryKey(deptID);
	}
	
	@Override
	public void updateDept(Dept dept)
	{
		deptMapper.updateByPrimaryKey(dept);
	}

}
