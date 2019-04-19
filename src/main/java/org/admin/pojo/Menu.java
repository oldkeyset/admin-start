package org.admin.pojo;

import javax.persistence.*;

public class Menu {
	/**
	 * menu_id
	 */
	@Id
	@Column(name = "menu_id")
	private Long menuId;

	/**
	 * 菜单编号
	 */
	@Column(name = "menu_code")
	private String menuCode;

	/**
	 * 菜单名称
	 */
	@Column(name = "menu_name")
	private String menuName;

	/**
	 * url
	 */
	@Column(name = "func_url")
	private String funcUrl;

	/**
	 * 时间戳
	 */
	private Long orderno;

	/**
	 * 引用于menu_id
	 */
	@Column(name = "group_id")
	private Long groupId;

	/**
	 * 获取menu_id
	 *
	 * @return menu_id - menu_id
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * 设置menu_id
	 *
	 * @param menuId menu_id
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * 获取菜单编号
	 *
	 * @return menu_code - 菜单编号
	 */
	public String getMenuCode() {
		return menuCode;
	}

	/**
	 * 设置菜单编号
	 *
	 * @param menuCode 菜单编号
	 */
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	/**
	 * 获取菜单名称
	 *
	 * @return menu_name - 菜单名称
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * 设置菜单名称
	 *
	 * @param menuName 菜单名称
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * 获取url
	 *
	 * @return func_url - url
	 */
	public String getFuncUrl() {
		return funcUrl;
	}

	/**
	 * 设置url
	 *
	 * @param funcUrl url
	 */
	public void setFuncUrl(String funcUrl) {
		this.funcUrl = funcUrl;
	}

	/**
	 * 获取时间戳
	 *
	 * @return orderno - 时间戳
	 */
	public Long getOrderno() {
		return orderno;
	}

	/**
	 * 设置时间戳
	 *
	 * @param orderno 时间戳
	 */
	public void setOrderno(Long orderno) {
		this.orderno = orderno;
	}

	/**
	 * 获取引用于menu_id
	 *
	 * @return group_id - 引用于menu_id
	 */
	public Long getGroupId() {
		return groupId;
	}

	/**
	 * 设置引用于menu_id
	 *
	 * @param groupId 引用于menu_id
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
}