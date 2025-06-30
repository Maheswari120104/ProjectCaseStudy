package com.hexaware.finance.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.finance.bean.ExpenseCategories;
import com.hexaware.finance.bean.Expenses;
import com.hexaware.finance.bean.Users;
import com.hexaware.finance.casestudy.exception.ExpenseNotFoundException;
import com.hexaware.finance.casestudy.exception.UserNotFoundException;
import com.hexaware.finance.service.IFinanceRepository;
import com.hexaware.finance.util.DBUtil;

public class FinanceDAO implements IFinanceRepository{

	@Override
	public boolean createUser(Users user) {
		String query="insert into Users values(?,?,?,?)";
		
		try(Connection con=DBUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			
			stmt.setInt(1, user.getUserId());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getEmail());
			int rs=stmt.executeUpdate();
			if(rs>0) {
				//System.out.println("user inserted suceesfully");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createExpense(Expenses expense) {
		// TODO Auto-generated method stub
		String query="insert into expenses(expense_id, user_id, amount, date, description, category_id) values(?,?,?,?,?,?)";
		try(Connection con=DBUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setInt(1, expense.getExpenseId());
			stmt.setInt(2, expense.getUserId().getUserId());
			stmt.setLong(3,expense.getAmount());
			
			stmt.setDate(4, expense.getDate());
			stmt.setString(5, expense.getDescription());
			stmt.setInt(6,expense.getCategoryId().getCategoryId());
			int rs=stmt.executeUpdate();
			if(rs>0) {
				//System.out.println("expenses are inserted");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean deleteUser(int userId) throws UserNotFoundException{
		// TODO Auto-generated method stub
		String query="delete from Users where user_id=?";
		try(Connection con=DBUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setInt(1, userId);
			int rs=stmt.executeUpdate();
			if(rs>0) {
				return true;
			}
			else {
				throw new UserNotFoundException("error:user id is not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteExpenses(int expenseId) throws ExpenseNotFoundException {
		// TODO Auto-generated method stub
		String query="delete from expenses where expense_id=?";
		try(Connection con=DBUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setInt(1, expenseId);
			int rs=stmt.executeUpdate();
			if(rs>0) {
				//System.out.println("successfully deleted");
				return true;
			}
			else {
				throw new ExpenseNotFoundException("error:expense id is not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			// TODO Auto-generated catch block
			
		}
		return false;
	}

	@Override
	public List<Expenses> getAllExpenses(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		List<Expenses>expenseList=new ArrayList<>();
		String query="select * from expenses where user_id=?";
		try(Connection con=DBUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setInt(1, userId);
			boolean found=false;
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				found=true;
				Expenses e=new Expenses();
				Users u=new Users();
				ExpenseCategories c=new ExpenseCategories();
				e.setExpenseId(rs.getInt("expense_id"));
				u.setUserId(rs.getInt("user_id"));
				e.setUserId(u);
				e.setAmount(rs.getLong("amount"));
				//e.setCategoryId(rs.get);
			    e.setDate(rs.getDate("date"));
			    e.setDescription(rs.getString("description"));
			    ExpenseCategories exp=new ExpenseCategories();
			    exp.setCategoryId(rs.getInt("category_id"));
			    e.setCategoryId(exp);
			    expenseList.add(e);
			}
			if(!found) {
				throw new UserNotFoundException("error:user id is not found");
			}
		         		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return expenseList;
		
	}

	@Override
	public boolean updateexpense(int userId, Expenses expense) {
		// TODO Auto-generated method stub
		String query="update expenses set amount=?,date=?,description=?,category_id=? where user_id=? and expense_id=?";
		try(Connection con=DBUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
				stmt.setLong(1, expense.getAmount());
				stmt.setDate(2, expense.getDate());
				stmt.setString(3, expense.getDescription());
				stmt.setInt(4, expense.getCategoryId().getCategoryId());
				stmt.setInt(5, userId);
				stmt.setInt(6, expense.getExpenseId());
				int rs=stmt.executeUpdate();
				if(rs>0) {
					return true;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		String query="select * from users where username=? and password=?";
		try(Connection con=DBUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			Users user=new Users();
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Expenses> getexpenserange(int userId, Date d1, Date d2) {
		// TODO Auto-generated method stub
		List<Expenses> expenseList=new ArrayList<>();
		String query="select * from expenses where user_id=? and date between ?and ?";
		try(Connection con=DBUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setInt(1, userId);
			stmt.setDate(2, d1);
			stmt.setDate(3, d2);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Expenses e=new Expenses();
				e.setExpenseId(rs.getInt("expense_id"));
				e.setAmount(rs.getLong("amount"));
				e.setDate(rs.getDate("date"));
				e.setDescription(rs.getString("description"));
				Users u=new Users();
				u.setUserId(rs.getInt("user_id"));
				e.setUserId(u);
				ExpenseCategories c=new ExpenseCategories();
				c.setCategoryId(rs.getInt("category_id"));
				e.setCategoryId(c);
				expenseList.add(e);
				//return expenseList;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expenseList;
	}

}
