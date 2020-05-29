package com.aaa.biz;

import com.aaa.entity.LayUiTree;
import com.aaa.entity.Menu;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MenuBiz {
	int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);
    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<LayUiTree>  selectAllMenu();

	PageInfo<Menu> showMenuInfo(Integer page, Integer limit, Integer visible, String menuName);

	void addMenu(Menu menu);

	void deleteMenu(Integer menuID);

	void updateMenu(Menu menu);
}