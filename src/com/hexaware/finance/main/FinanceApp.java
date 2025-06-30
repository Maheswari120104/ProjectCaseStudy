package com.hexaware.finance.main;
import com.hexaware.finance.bean.ExpenseCategories;
import com.hexaware.finance.bean.Expenses;
import com.hexaware.finance.bean.Users;
import com.hexaware.finance.casestudy.exception.ExpenseNotFoundException;
import com.hexaware.finance.casestudy.exception.UserNotFoundException;
import com.hexaware.finance.dao.FinanceDAO;
import com.hexaware.finance.util.PropertyUtil;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import

public class FinanceApp {
public static void main(String[] args) {
	while(true){
		FinanceDAO dao=new FinanceDAO();
		Scanner sc=new Scanner(System.in);
		System.out.println("Finance App");
		System.out.println("1.create user");
		System.out.println("2.create expense");
		System.out.println("3.delete user");
		System.out.println("4.delete expense");
		System.out.println("5.get all expenses");
		System.out.println("6.update expense");
		System.out.println("7.login user");
		System.out.println("8.Expenses between a particular range of dates");
		System.out.println("9.property file");
		System.out.println("10.exit");		
		//String constr=PropertyUtil.getPropertyString("db.properties");
		//System.out.println("Connection URL: "+constr);
		int opt=sc.nextInt();
		switch(opt) {
		case 1:
			while(true) {
				System.out.println("enter id");
				int id=sc.nextInt();
				System.out.println("enter name");
				String name=sc.next();
				System.out.println("enter password");
                String password=sc.next();
        		System.out.println("enter email");
        		String email=sc.next();
        		Users u=new Users(id,name,password,email);
        		
        		boolean s=dao.createUser(u);
        		if(s==true) {
        			System.out.println("account is created successfully");
        			
        		}
        		else {
        			System.out.println("account creation failed");
        			
        		}
        		break;
        		
        		}
			break;
		case 2:
			while(true) {
				
					System.out.println("enter user id");
					int id=sc.nextInt();
					System.out.println("enter name");
					String name=sc.next();
					System.out.println("enter password");
	                String password=sc.next();
	        		System.out.println("enter email");
	        		String email=sc.next();
	        		
				System.out.println("enter expense_id");
				int expenseid=sc.nextInt();
				System.out.println("enter user_id");
				int user_id=sc.nextInt();
				System.out.println("enter amount");
                Long amount=sc.nextLong();
        		System.out.println("enter category_id");
        		int category_id=sc.nextInt();
        		System.out.println("enter date");
        		String date=sc.next();
        		Date d=Date.valueOf(date);
        		sc.nextLine();
        		System.out.println("enter description");
        		String description=sc.next();
        		System.out.println("enter category name");
        		String category_name=sc.next();
        		Users u=new Users(id,name,password,email);
        		ExpenseCategories c=new ExpenseCategories(category_id,category_name);
        		Expenses e=new Expenses(expenseid,u,amount,c,d,description);
        		boolean v=dao.createExpense(e);
        		
        		if(v==true) {
        			System.out.println("expense account is created successfully");
        			
        		}
        		else {
        			System.out.println("account creation failed");
        			
        		}
        		break;
				}
			break;
				case 3:
					System.out.println("enter id");
					int id=sc.nextInt();
			boolean b = false;
			try {
				b = dao.deleteUser(id);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
					if(b==true) {
	        			System.out.println("deleted successfully");
	        			
	        		}
	        		else {
	        			System.out.println("deletion failed");
	        			
	        		}
					break;
				case 4:
					System.out.println("enter id");
					int id1=sc.nextInt();
			boolean b1 = false;
			try {
				b1 = dao.deleteExpenses(id1);
				
			} catch (ExpenseNotFoundException e) {
				System.out.println(e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					if(b1==true) {
	        			System.out.println("deleted successfully");
	        			
	        		}
	        		else {
	        			System.out.println("deletion failed");
	        			
	        		}
					break;
				case 5:
					System.out.println("enter id");
					int id2=sc.nextInt();
			try {
				System.out.println(dao.getAllExpenses(id2));
				throw new UserNotFoundException("error:user id is not found");
			} catch (UserNotFoundException e) {
				System.out.println(e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					break;
				case 6:
					System.out.println("enter user id");
					int id4=sc.nextInt();
					Expenses exp=new Expenses();
					System.out.println("enter expense id");
					exp.setExpenseId(sc.nextInt());
					System.out.println("enter the amount");
					exp.setAmount(sc.nextLong());
					System.out.println("enter the date");
					String date=sc.next();
	        		Date d=Date.valueOf(date);
					exp.setDate(d);
					sc.nextLine();
					System.out.println("enter the description");
					String s=sc.nextLine();
					exp.setDescription(s);
					System.out.println("enter the category Id");
					ExpenseCategories c=new ExpenseCategories();
					c.setCategoryId(sc.nextInt());
					exp.setCategoryId(c);
					
					
					boolean m=dao.updateExpense(id4, exp);
					if(m==true) {
	        			System.out.println("updated successfully");
	        			
	        		}
	        		else {
	        			System.out.println("updation failed");
	        			
	        		}
					break;
				case 7:
					System.out.println("enter name");
					String name=sc.next();
					System.out.println("enter password");
					String password=sc.next();
					boolean login=dao.login(name, password);
					if(login) {
						System.out.println("login successfull");
					}
					else {
						System.out.println("unsuccessfull login");
					}
					break;
				case 8:
					List<Expenses>expenseList=new ArrayList<>();
					System.out.println("enter id");
					int id5=sc.nextInt();
					sc.nextLine();
					System.out.println("enter date");
					String date1=sc.nextLine();
					System.out.println("enter date");
					String date2=sc.nextLine();
					Date d1=Date.valueOf(date1);
					Date d2=Date.valueOf(date2);
					
					expenseList=dao.getExpenseRange(id5, d1, d2);
					
					System.out.println(expenseList);
					break;
				case 9:
					String constr=PropertyUtil.getPropertyString("db.properties");
					System.out.println("Connection URL: "+constr);
				case 10:
					System.exit(1);
					break;
					
				default:
						System.out.println("invalid option");
						break;
		}
		}
	
					
		}


	}


