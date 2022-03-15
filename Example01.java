package test;

import java.sql.*;

public class Example01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		Statement stmt=null;
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		String createSql=
				"CREATE TABLE member"+
		       "(no   NUMBER,"+
			   "name  VARCHAR2(10)," +
		       "pwd   VARCHAR2(10))";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection(url, "scott", "tiger");
			
			stmt=con.createStatement();
			stmt.executeUpdate(createSql);
			
			System.out.println("number TABLE 생성완료");
			
			
		}catch(ClassNotFoundException e) {
			System.out.println("\n Driver Loading 시 Exception 발생\n");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("\nJDBC 절차 중 Exception 발생"+e.getErrorCode());
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				System.out.println("\nJDBC 절차 중 Exception 발생"+e.getErrorCode());
				e.printStackTrace();
			}
		}

	}

}
