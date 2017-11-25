package com.mc.portal.vo;

import java.io.Serializable;

import lombok.Data;


/**
 * The persistent class for the help_category database table.
 * 
 */
@Data
public class HelpCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	private int helpCategoryId;
	private String name;
	private int parentCategoryId;
	private String url;

	public HelpCategory() {
	}
}