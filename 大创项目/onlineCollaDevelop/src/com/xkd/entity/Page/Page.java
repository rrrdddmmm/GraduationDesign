package com.xkd.entity.Page;


/**
 * 翻页模型
 * @author RBB
 *
 */
public abstract class Page {

	@Override
	public String toString() {
		return "Page [PagsAndRows=" + PagsAndRows + ", currentPage="
				+ currentPage + ", pageSize=" + pageSize + ", rows=" + rows
				+ ", totalPage=" + totalPage + "]";
	}
	@SuppressWarnings("unused")
	private Integer add;
	private Integer PagsAndRows;//在抽象service层设置
	// 分页时输入的参数
	protected Integer currentPage = 1; // 当前页,在controller层设置
	private Integer pageSize = 10; // 每页显示最大行数//在此处设置
	// 用于计算总页数
	private Integer rows=0; // 总行数//在抽象service层设置
	// 由rows和pageSize计算而来
	private Integer totalPage;// 总页数//在抽象service层设置
	protected Page(){}
	protected Page(Integer currentPage){this.currentPage=currentPage;}
	public Integer getTotalPage() {
		if (rows % pageSize == 0) {
			totalPage = rows / pageSize;
		} else {
			totalPage = rows / pageSize + 1;
		}
		return totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		/*
		 * 总行数发生改变时,可能引起总页数的变化,
		 * 从而可能导致当前页大于总页数,在此处理一下这个情况.
		 * */
		if (currentPage <= 0 || currentPage > getTotalPage()) {
			if(currentPage <= 0){
				this.currentPage = 1;
			}
			if(currentPage >= getTotalPage()){
				this.currentPage = getTotalPage();
			}
		}else{
			this.currentPage = currentPage;
		}
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public Integer getPagsAndRows() {
		return PagsAndRows;
	}
	public void setPagsAndRows(Integer pagsAndRows) {
		PagsAndRows = pagsAndRows;
	}
	public void setAdd(Integer add) {
		this.add = add;
	}
	public Integer getAdd() {
		return PagsAndRows+pageSize;
	}
	
}
