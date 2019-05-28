package com.tongu.rbac.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/**
 *  entity. @author Tools
 */
@Entity
@Table(name = "CK_T_MENU")
public class MenuEntity extends BaseEntity  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	private String menuName;
	
	/**
	 * 
	 */
	private Integer menuLevel;
	
	/**
	 * 
	 */
	private String menuFlag;
	
	/**
	 * 
	 */
	private String menuUrl;
	
	/**
	 * 
	 */
	private String parentId;
	
	/**
	 * 
	 */
	private String menuIcon;
	
	/**
	 * 
	 */
	private String isEnabled;
	
	/**
	 * 菜单类型：01-菜单/02-按钮
	 */
	private String menuType;
	
	/**
	 * 
	 */
	private String menuDesc;
	
	/**
	 * 
	 */
	private Integer menuSort; 
	
	@Getter
	@Setter
	private String menuCode;
	
	@Getter
	@Setter
	private String searchCode;

	@Column(name = "MENU_NAME", length = 255)
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "MENU_DESC", length = 500)
	public String getMenuDesc() {
		return this.menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	@Column(name = "MENU_LEVEL", length = 4)
	public Integer getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	@Column(name = "MENU_FLAG", length = 50)
	public String getMenuFlag() {
		return menuFlag;
	}

	public void setMenuFlag(String menuFlag) {
		this.menuFlag = menuFlag;
	}

	@Column(name = "MENU_URL", length = 255)
	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	@Column(name = "PARENT_ID", length = 36)
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "MENU_ICON", length = 50)
	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	@Column(name = "IS_ENABLED", length = 1)
	public String getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Column(name = "MENU_TYPE", length = 2)
	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	@Column(name = "MENU_SORT", length = 4)
	public Integer getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(Integer menuSort) {
		this.menuSort = menuSort;
	}

	
}
