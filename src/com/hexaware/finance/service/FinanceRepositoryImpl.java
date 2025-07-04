package com.hexaware.finance.service;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import com.hexaware.finance.dao.*;
import com.hexaware.finance.bean.Expenses;
import com.hexaware.finance.bean.Users;
import com.hexaware.finance.casestudy.exception.ExpenseNotFoundException;
import com.hexaware.finance.casestudy.exception.UserNotFoundException;

public class FinanceRepositoryImpl implements IFinanceRepository{
  FinanceDAO dao= new FinanceDAO();
	@Override
	public boolean createUser(Users user) {
		boolean created=dao.createUser(user);
		return created;
	
	}

	@Override
	public boolean createExpense(Expenses expense) {
		boolean created=dao.createExpense(expense);
		return created;
	
		// TODO Auto-generated method stub
	}

	@Override
	public boolean deleteUser(int userId) {
		boolean deleted = false;
		try {
			deleted = dao.deleteUser(userId);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return deleted;
	}

	@Override
	public boolean deleteExpenses(int expenseId) throws ExpenseNotFoundException {
		// TODO Auto-generated method stub
		boolean deleted = false;
		deleted = dao.deleteExpenses(expenseId);
		return deleted;
	}

	@Override
	public List<Expenses> getAllExpenses(int userId) {
		// TODO Auto-generated method stub
		List<Expenses>expenseList=new ArrayList<>();
		try {
			expenseList=dao.getAllExpenses(userId);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expenseList;
	}

	@Override
	public boolean updateExpense(int userId, Expenses expense) {
		// TODO Auto-generated method stub
		boolean updated=dao.updateExpense(userId, expense);
		return updated;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		boolean login=dao.login(username, password);
		return login;
	}

	@Override
	public List<Expenses> getExpenseRange(int userId, Date d1, Date d2) {
		// TODO Auto-generated method stub
		List<Expenses>expenseList=new ArrayList<>();
		expenseList=dao.getExpenseRange(userId, d1, d2);
		return expenseList;
	}
}
  
	
