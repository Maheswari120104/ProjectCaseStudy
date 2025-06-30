package com.hexaware.finance.bean;

public class ExpenseCategories {
    private int categoryId;
    private String categoryName;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public ExpenseCategories(int categoryId, String categoryName) {
		//super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public ExpenseCategories() {
		this.categoryId = 1;
		this.categoryName = "food";
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "categoryid:"+categoryId;
	}
}
