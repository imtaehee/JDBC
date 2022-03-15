package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.util.Scanner;

public class Example02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,"scott","tiger");
		
		//Statement stmt=con.createStatement();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("인자입력");
		
		int no=Integer.parseInt(sc.nextLine());
		String id=sc.nextLine();
		String pwd=sc.nextLine();
		
		//String sql="INSERT INTO member VALUES(' "+no+" ', ' "+id+" ', ' "+ pwd+" ')";
		//stmt.executeUpdate(sql);
		PreparedStatement pstmt=con.prepareStatement("INSERT INTO member VALUES(?,?,?)");
		
		pstmt.setInt(1, no);
		pstmt.setString(2, id);
		pstmt.setString(3, pwd);
		pstmt.executeUpdate();
		
		sc.close();
		//if(stmt != null) stmt.close();
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();

	}

}
