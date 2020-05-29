package com.aaa.biz;

import com.aaa.entity.Dept;
import com.aaa.entity.MyUserInfo;
import com.github.pagehelper.PageInfo;

public  interface  DeptBiz {
	PageInfo<Dept> showDeptInfo(int page, int limit,int status,String deptName);

	void addDept(Dept dept);

	void deleteDept(Integer deptID);

	void updateDept(Dept dept);
}
