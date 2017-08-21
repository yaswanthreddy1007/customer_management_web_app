package singh.navjot.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import singh.navjot.model.User;

// DAO | Data Access Object
public class JDBCHelper 
{
	Connection con;
	PreparedStatement pStmt;
	
	public JDBCHelper() 
	{
		try {
			//1. Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("--Driver Loaded--");
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
	}
	
	public void openConnection()
	{
		try {
			
			//2. Create the Connection
			String url = "jdbc:mysql://localhost/customer_db";
			String user = "root";
			String pass = "";
			
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("--Connection Created--");
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
	}
	
	public int registerUser(User user)
	{
		
		int i = 0;
		
		try {
			
			
			//3. Create SQL Statement
			String sql = "insert into user_table values(null, ?, ?, ?,?)";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getEmail());
			pStmt.setString(3, user.getPassword());
			pStmt.setString(4, "0");
			
			//4. Execute SQL Statement
			i = pStmt.executeUpdate();
			if(i>0){
				System.out.println(user.getName()+" Registered");
			}else{
				System.out.println(user.getName()+" not Registered");
			}
			
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
			e.printStackTrace();
		}
		
		return i;
	}
	
	public void incrementpoints(String email)
	{
		int i=0;
		int points = getpoints(email);
		
		points = points + 2;
		
	
		try {
			
			String sql = "update user_table set POINTS=? where EMAIL=?";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, String.valueOf(points) );
			pStmt.setString(2, email);
			
			i = pStmt.executeUpdate();
			if(i>0)
			{
				System.out.println("points updated");
			}
			else {
				System.out.println("points didn't updated");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String existinguser(User user) 
	{	
		String existingemail = "";
		try {
			String sql = "select * from user_table where email=?";
			
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, user.getEmail());
			
			ResultSet rs = pStmt.executeQuery();
			boolean userexist = rs.next();
			if(userexist)
			{
				existingemail = rs.getString(3);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("exception: "+e+"\n");
			e.printStackTrace();
		}
		return existingemail;
	}
	
	public int getpoints(String email)
	{
		int points=-1;
		try {
			
			String sql = "select POINTS from user_table where email=?";
			
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, email);
			
			ResultSet rs = pStmt.executeQuery();
			boolean userexist = rs.next();
			if(userexist)
			{ System.out.print("exist");
				points = Integer.valueOf(rs.getString(1));
			}
			
		}catch (Exception e) {
			System.out.println("Some Exception: "+e);	e.printStackTrace();	}
		
		return points;
	}
	
	public HashMap loginUser(User user)
	{
		boolean login = false;
		String name = "";
		String email = "";
		HashMap<String,String> hm=new HashMap<String,String>(); 
		try{
			
			
			//3. Create SQL Statement
			String sql = "select * from user_table where email = ? and password = ?";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, user.getEmail());
			pStmt.setString(2, user.getPassword());
			
			ResultSet rs = pStmt.executeQuery();
			
			login = rs.next();
			if(login == true)
			{
				hm.put("keyname", rs.getString(2));
				hm.put("keyemail", rs.getString(3));
				hm.put("keylogincheck", "true");
			}
			else {
				hm.put("keyname", name);
				hm.put("keyemail", email);
				hm.put("keylogincheck", "false");
			}
			
			
		}catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
		return hm;
	}
	
	public ArrayList retrieveUsers()
	{
		ArrayList<String> userslist=new ArrayList<String>();
		
		try {
			String sql = "select EMAIL from user_table";
			pStmt = con.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			
			while(rs.next())
			{
				if(!rs.getString(1).equals("navjotsingh9633@gmail.com"))
				{
					userslist.add(rs.getString(1));
				}
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return userslist;
	}
	
	public void closeConnection()
	{
		try {
			pStmt.close();
			con.close();
			System.out.println("Connection closed");
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
	}
	
}
