package com.hexaware.finance.casetudy.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hexaware.finance.bean.ExpenseCategories;
import com.hexaware.finance.bean.Expenses;
import com.hexaware.finance.bean.Users;
import com.hexaware.finance.casestudy.exception.ExpenseNotFoundException;
import com.hexaware.finance.casestudy.exception.UserNotFoundException;
import com.hexaware.finance.dao.FinanceDAO;
import com.hexaware.finance.util.DBUtil;


public class FinanceDaoTest {
	static FinanceDAO dao;
	int testUserId;
	int testExpenseId;
	@BeforeEach
public  void setup() {
	dao=new FinanceDAO();
	testUserId=(int)(Math.random()*100000);
	testExpenseId=(int)(Math.random()*100000);
	 //testUserId=9000;
	 //testExpenseId=10000;
	
	
}
	@AfterEach
    public void cleanup() throws SQLException {
        try (Connection con = DBUtil.getConnection()) {
           
            PreparedStatement stmt1 = con.prepareStatement("Delete from expenses where expense_id = ?");
            stmt1.setInt(1, testExpenseId);
            stmt1.executeUpdate();

            
            PreparedStatement stmt2 = con.prepareStatement("Delete from users where user_id = ?");
            stmt2.setInt(1, testUserId);
            stmt2.executeUpdate();
        }
    }
	@Test
	public void testcreateUser() {
		Users user=new Users(testUserId,"shree","sree123","sree123@gmail.com");
		assertTrue(dao.createUser(user),"user is created successfully");
	}
	@Test
	public void testcreateexpense() {
		Users u=new Users(testUserId,"shree","sree123","sree123@gmail.com");
		dao.createUser(u);
		ExpenseCategories exp=new ExpenseCategories(1,"Food");
		Expenses e=new Expenses(testExpenseId,u,1300L,exp,Date.valueOf("2025-01-20"),"Dinner night");
		assertTrue(dao.createExpense(e),"expense is created successfully");
	}
	
	@Test
	public void testgetAllexpenses() throws UserNotFoundException{
		Users u=new Users(testUserId,"shree","sree123","sree123@gmail.com");
		
		dao.createUser(u);
		ExpenseCategories exp=new ExpenseCategories(1,"Food");
		Expenses e=new Expenses(testExpenseId,u,1300L,exp,Date.valueOf("2025-01-19"),"party night");
		dao.createExpense(e);
		List<Expenses>expenseList=dao.getAllExpenses(testUserId);
		assertNotNull(expenseList,"expense list should not be null");
		assertFalse(expenseList.isEmpty(),"expense list is not empty");
		}
	@Test
	public void testUserNotFoundException() {
		assertThrows(UserNotFoundException.class,()->{
			dao.getAllExpenses(888);
			
		});
	}
	@Test
	public void testExpenseNotFoundException() {
		assertThrows(ExpenseNotFoundException.class,()->{
			dao.deleteExpenses(888);
		});
	}
	

}
