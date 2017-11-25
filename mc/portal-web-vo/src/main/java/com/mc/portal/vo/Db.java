package com.mc.portal.vo;

import java.io.Serializable;

import lombok.Data;


/**
 * The persistent class for the db database table.
 * 
 */
@Data
public class Db implements Serializable {
	private static final long serialVersionUID = 1L;

	private String alterPriv;

	private String alterRoutinePriv;

	private String createPriv;

	private String createRoutinePriv;

	private String createTmpTablePriv;

	private String createViewPriv;

	private String deletePriv;

	private String dropPriv;

	private String executePriv;

	private String grantPriv;

	private String indexPriv;

	private String insertPriv;

	private String lockTablesPriv;

	private String referencesPriv;

	private String selectPriv;

	private String showViewPriv;

	private String updatePriv;

	public Db() {
	}
}