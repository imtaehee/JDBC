package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.util.Scanner;

public class Example03 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,"scott","tiger");
		
		//Statement stmt=con.createStatement();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("인자입력");
		String id=sc.nextLine();
		
		//String sql="DELETE FROM member WHERE  name=(' "+id+" ') ";
		//stmt.executeUpdate(sql);
		PreparedStatement pstmt=con.prepareStatement("DELETE FROM member WHERE name=?");
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		
		System.out.println("member TABLE RECORD DELETE 완료");
		
		sc.close();
		//if(stmt != null) stmt.close();
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();

	}

}
