package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.TicketDao;
import com.masai.dao.TicketDaoImpl;

public class adminLogin {
	
	

	public static void main(String[] args) {

		
		Scanner input=new Scanner(System.in);
		
		
		System.out.println("Enter username: ");
		String username=input.next();
		
		
		
		System.out.println("Enter password : ");
		String password=input.next();
		
		
		TicketDao dao=new TicketDaoImpl();
		
		String result=dao.adminLogin(username, password);
		
		
		
		
		
	}

}
