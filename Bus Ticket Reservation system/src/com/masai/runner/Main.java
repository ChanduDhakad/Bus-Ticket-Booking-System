package com.masai.runner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.masai.dao.TicketDao;
import com.masai.dao.TicketDaoImpl;
import com.masai.utility.DButil;

public class Main {

	public static void main(String[] args) {
	
		
		int number=1;
		
		while(number!=2)
		{
			
			System.out.println();
			System.out.println("====================================================");
			System.out.println("  Welcome to Bus Ticket Reservation System");
			System.out.println("====================================================");
			
			
			
			Scanner input=new Scanner(System.in);
			TicketDao dao=new TicketDaoImpl();
			
			
			System.out.println();
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println();
			
			
			System.out.println("Enter your choice:");
			int choice =input.nextInt();
			
			if(choice ==1) {
				
				System.out.println();
				
				System.out.println("Enter username: ");
				String username = input.next();
				
				System.out.println("Enter Password: ");
				String password = input.next();
				
				
			String login=dao.adminLogin(username, password);
			System.out.println();
			
			System.out.println(login);
			
		
			if(login.equals("Wrong Credentials"))
			{
				System.out.println("Inside if block ");
				number = 1;
				continue;
			}
			
			System.out.println("1. Insert Bus Details");
			System.out.println("2. Go back");
			System.out.println("3. Exit");
			
			System.out.println();
			System.out.println("Enter your choice:");
			int insertorNot = input.nextInt();
			
			if(insertorNot==1) {
				
				
				System.out.println("Enter BusName: ");
				String busname = input.next();
				
				System.out.println("Enter Source: ");
				String source = input.next();
				
				System.out.println("Enter Destination: ");
				String destination = input.next();
				
				System.out.println("Enter BusType: ");
				String bustype = input.next();
				
				System.out.println("Enter Seats Avilable: ");
				int seats = input.nextInt();
				
				System.out.println("Enter ArrivalTime: ");
				String arrivalTime = input.next();
				
				System.out.println("Enter DepartureTime: ");
				String departureTime = input.next();
				
				
				String result = dao.insertBusDetails(busname, source, destination, bustype, seats, arrivalTime, departureTime);
			     System.out.println(result);
				

			}
				else if(insertorNot==2)
				{
					number = 1;
				}
				else if(insertorNot==3)
				{
					number = 2;
				}
				else
				{
					System.out.println("Please Enter Correction Input!");
				}
				
			
			}	
			
			else if(choice ==2)
			{
				System.out.println();
				System.out.println("1. Book Ticket");
				System.out.println("2. Cancel Ticket");
				System.out.println("3. Go back");
				System.out.println("4. Exit");
			
			

				System.out.println();
				System.out.println("Enter your choice: ");
				int bookorNot =input.nextInt();
	
				
			
			
			
			if(bookorNot==1) {
				
				System.out.println();
				
				try (Connection conn=DButil.provideConnection()){
					
					
					PreparedStatement ps=conn.prepareStatement("select * from busdetails");
					
					ResultSet rs = ps.executeQuery();
					
					
					System.out.println("BUSNO SEATS SOURCE DESTINATION ");
					
					while(rs.next()) {
						
						System.out.print("  "+rs.getInt("busname")+"  ");
						
						System.out.print(rs.getInt("seats")+"   ");
						
						System.out.print(rs.getString("source")+"  ");
						System.out.print(rs.getString("destination"));
						
					      System.out.println();
						
					}
					
				
					
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				} 
				
						System.out.println();
						System.out.println("Enter Source Location: ");
						String source = input.next();
						
						System.out.println("Enter Destination Location: ");
						String destination = input.next();
						
						System.out.println("Enter Your Name: ");
						String name = input.next();
						
						System.out.println("Enter Your Age: ");
						int age = input.nextInt();
						
						
						String res = dao.confirmTicket(source, destination, name, age );
						
						System.out.println();
						System.out.println(res);
						number = 1;
					
				} 
				
				else if(bookorNot==2)
					{
						System.out.println("Enter BusNo: ");
						int busno = input.nextInt();
						   
						System.out.println("Enter Name: ");
						String name =input.next();
						
						
						String result = dao.ticketCancel(busno, name);
						
						
						System.out.println();
						
						System.out.println(result);
						
					}
						else if(bookorNot==3)
						{
							number = 1;
						}
						else if(bookorNot==4)
						{
							number = 2;
						}
						else
						{
							System.out.println("Please Enter Correction Information Next Time!");
						}
		
		}
			
			
			
			
			
		}
		
		
	}

}
