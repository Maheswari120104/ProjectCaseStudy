package com.hexaware.finance.bean;

import java.sql.Date;
import java.time.LocalDate;


public class Expenses {
	private int expenseId;
	private Users userId;
	private Long amount;
	private ExpenseCategories categoryId;
    private Date date;
    private String description;
	public Expenses() {
		this.expenseId=0;
		this.userId=new Users();
		this.amount=(long) 0;
		this.categoryId=new ExpenseCategories();
		this.date=date;
		this.description="";
		
		// TODO Auto-generated constructor stub
	}
	public Expenses(int expenseId, Users userId, Long amount, ExpenseCategories categoryId, Date date, String description) {
		
		this.expenseId = expenseId;
		this.userId = userId;
		this.amount = amount;
		this.categoryId = categoryId;
		this.date = date;
		this.description = description;
	}
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public ExpenseCategories getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(ExpenseCategories categoryId) {
		this.categoryId = categoryId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
	    return "ExpenseID: " + expenseId +
	           ", UserID: " + (userId != null ? userId.getUserId() : "null") +
	           ", Amount: " + amount +
	           ", Date: " + date +
	           ", Description: " + description +
	           ", CategoryID: " + (categoryId != null ? categoryId.getCategoryId() : "null");
	}

}
