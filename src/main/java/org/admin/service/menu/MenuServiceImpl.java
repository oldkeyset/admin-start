package org.admin.service.menu;

import java.util.List;

import org.admin.mapper.menu.MenuMapper;
import org.admin.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("menuService")
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuMapper menuMapper;
	
	public List<Menu> queryMenuList() {
		
		return menuMapper.selectAll();
	}

}
