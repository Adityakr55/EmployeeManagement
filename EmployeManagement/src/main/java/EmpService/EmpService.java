package EmpService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpService {
	private static Scanner sc = new Scanner(System.in);
	private static String url = "jdbc:postgresql://localhost:5432/EmployeeManagement?user=postgres&password=123";
	private static Connection con;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Connection done");
			con = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int save() {
		int res = 0;
		System.out.println("Enter the employe id");
		int id = sc.nextInt();
		System.out.println("Enter employee name");
		String name = sc.next();
		System.out.println("enter employee age");
		int age = sc.nextInt();
		System.out.println("Enter the salary of employee");
		int salary = sc.nextInt();
		
		String sql = "Insert into Emp values(?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setInt(3, age);
			pstm.setInt(4, salary);
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return res;
	}
	
	public int update() {
		int update = 0;
		System.out.println("Press 1 to update id");
		System.out.println("Press 2 to update name");
		System.out.println("Press 3 to update age");
		System.out.println("Press 4 to update salary");
		
		System.out.println("Enter your choice:- ");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("Enter the previous id");
			int previd = sc.nextInt();
			System.out.println("Enter the new id");
			int newid = sc.nextInt();
			
			String sql = "update emp set id = ? where id = ?";
			try {
				PreparedStatement pstm = con.prepareStatement(sql);
				pstm.setInt(1, newid);
				pstm.setInt(2, previd);
				
				update =  pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("Enter the ");
		}
		return update;
	}
}