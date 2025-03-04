package EmpService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			
			String idupdatesql = "update emp set id = ? where id = ?";
			try {
				PreparedStatement pstm = con.prepareStatement(idupdatesql);
				pstm.setInt(1, newid);
				pstm.setInt(2, previd);
				
				update =  pstm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			
		case 2:
			System.out.println("Enter the id of the employee you want to update the name:");
			int idForName = sc.nextInt();
			System.out.println("Enter the new name");
			String name = sc.next();
			String nameupdatesql = "update emp set name = ? where id = ?";
			try {
				PreparedStatement pstm = con.prepareStatement(nameupdatesql);
				pstm.setString(1, name);
				pstm.setInt(2, idForName);
				update = pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 3:
			System.out.println("Enter the id of the employee you want to update the age:");
			int idForAge = sc.nextInt();
			System.out.println("Enter the new age:");
			int newage = sc.nextInt();
			String ageupdatesql = "update emp set age = ? where id = ?";
			try {
				PreparedStatement pstm = con.prepareStatement(ageupdatesql);
				pstm.setInt(1, newage);
				pstm.setInt(2, idForAge);
				update = pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 4:
			System.out.println("Enter the id of the employee you want to update the salary:");
			int idForSal = sc.nextInt();
			System.out.println("Enter the new salary:");
			int newSalary = sc.nextInt();
			String salaryupdatesql = "update emp set salary = ? where id = ?";
			try {
				PreparedStatement pstm = con.prepareStatement(salaryupdatesql);
				pstm.setInt(1, newSalary);
				pstm.setInt(2, idForSal);
				update = pstm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		return update;
	}
	
	public int delete() {
		int delete = 0;
		System.out.println("Enter the employee id you want to delete:");
		int iddelete = sc.nextInt();
		String deletesql = "delete from emp where id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(deletesql);
			pstm.setInt(1, iddelete);
			delete = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delete;
	}
	
	public int fetch() {
		int fetch = 0;
		Statement stm;
		try {
			stm = con.createStatement();
			String sql = "select * from emp order by id";
			ResultSet res = stm.executeQuery(sql);
			
			while(res.next()) {
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getInt(3));
				System.out.println("================");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fetch;
	}
	
	public int close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
}
