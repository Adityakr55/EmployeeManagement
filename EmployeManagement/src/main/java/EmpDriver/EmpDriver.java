package EmpDriver;

import java.util.Scanner;

import EmpService.EmpService;

public class EmpDriver {
	public static void main(String[] args) {
		System.out.println("Welcome to Employee management.");
		System.out.println("Menu Details");
		
		System.out.println("Press 1 to register employee");
		System.out.println("Press 2 to update employee");
		System.out.println("Press 3 to delete employee");
		System.out.println("Press 4 to fetch employee");
		System.out.println("Press 5 to close employee");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		
		EmpService e1 = new EmpService();
		
		switch(choice) {
			
		case 1:
				int insert = e1.save();
				if(insert != 0) {
					System.out.println("Data Saved");
				}
				else {
					System.out.println("Data Not Saved");
				}
			break;
			
		case 2:
				int update = e1.update();
				if(update != 0) {
					System.out.println("Data Updated");
				}
				else {
					System.out.println("Data not updated");
				}
			
		case 3:
				int delete = e1.delete();
				if(delete != 0) {
					System.out.println("Data Deleted.");
				}
				else {
					System.out.println("Data Not Deleted.");
				}
				break;
				
		case 4:
				int fetch = e1.fetch();
				if(fetch != 0) {
					System.out.println("Data Fetched.");
				}
				else {
					System.out.println("Data Not Fetched.");
				}
		case 5:
				int close = e1.close();
				if(close != 0) {
					System.out.println("Connection Closed.");
				}
				else {
					System.out.println("Connection not closed.");
				}
		default:
			break;
		
		}
	}
}
