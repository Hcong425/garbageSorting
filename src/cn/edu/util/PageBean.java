package cn.edu.util;

import java.util.List;

public class PageBean<T> {
	private int pageNum; // 当前页数
	private String way;
	private String line;
	private int totalCount; // 总记录数
	private int totalPage; // 总页数
	private int pageSize; // 每页显示的记录数
	private List<T> list; // 每页显示数据的集合.

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public PageBean(int pageNum, String way, String line, int totalCount, int totalPage, int pageSize, List<T> list) {
		super();
		this.pageNum = pageNum;
		this.way = way;
		this.line = line;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.list = list;
	}

	public PageBean() {
		super();
	}

	@Override
	public String toString() {
		return "PageBean [pageNum=" + pageNum + ", way=" + way + ", line=" + line + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", pageSize=" + pageSize + ", list=" + list + "]";
	}

}
