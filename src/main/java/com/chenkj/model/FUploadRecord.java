package com.chenkj.model;

import java.sql.Timestamp;

public class FUploadRecord {
	public static String FILE_ROOT_PATH="d:/file/chenkj";
	private String id;
	private String fsection;
	private String fitem;
	private String fname;
	private String fext;
	private String fpath;
	private String creator;
	private Timestamp createtime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFsection() {
		return fsection;
	}
	public void setFsection(String fsection) {
		this.fsection = fsection;
	}
	public String getFitem() {
		return fitem;
	}
	public void setFitem(String fitem) {
		this.fitem = fitem;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFext() {
		return fext;
	}
	public void setFext(String fext) {
		this.fext = fext;
	}
	public String getFpath() {
		return fpath;
	}
	public void setFpath(String fpath) {
		this.fpath = fpath;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
}
