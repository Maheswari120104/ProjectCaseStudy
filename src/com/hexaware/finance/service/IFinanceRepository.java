package com.hexaware.finance.service;

import java.sql.Date;
import java.util.List;

import com.hexaware.finance.bean.Expenses;
import com.hexaware.finance.bean.Users;
import com.hexaware.finance.casestudy.exception.ExpenseNotFoundException;
import com.hexaware.finance.casestudy.exception.UserNotFoundException;

public interface IFinanceRepository {
	boolean createUser(Users user);
	boolean createExpense(Expenses expense);
	boolean deleteUser(int userId) throws UserNotFoundException;
	boolean deleteExpenses(int expenseId) throws ExpenseNotFoundException;
	List<Expenses> getAllExpenses(int userId) throws UserNotFoundException;
	boolean updateExpense(int userId,Expenses expense);
	boolean login(String username,String password );
    List<Expenses> getExpenseRange(int userId,Date d1,Date d2 );
}
