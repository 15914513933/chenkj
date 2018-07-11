package com.chenkj.result;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int pageNum;
	private int pageSize;
	private long totalCount;
	private int pages;
	private List<T> datas;
	private boolean isFirstPage = false;
	private boolean isLastPage = false;

	public PageBean() {
	}

	public PageBean(int pageNum, int pageSize, int totalCount, List<T> datas) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalCount = (long) totalCount;
		this.pages = (totalCount + pageSize - 1) / pageSize;
		this.datas = datas;
		this.isFirstOrLast();
	}

	private void isFirstOrLast() {
		this.isFirstPage = this.pageNum == 1;
		this.isLastPage = this.pageNum == this.pages;
	}

	public int getPageNum() {
		return this.pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getDatas() {
		return this.datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public boolean isIsFirstPage() {
		return this.isFirstPage;
	}

	public void setIsFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isIsLastPage() {
		return this.isLastPage;
	}

	public void setIsLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
}
