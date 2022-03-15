package test;
import java.sql.*;

/*
*FileName: CreateJDBC.java
*1.JDBC Programing 절차
*2. 각각의 JDBC Programming 절차 에서 발생하는 Exception 이해
*3. executeQuery(SQL),executeUpdate(SQL)Method이해
*/
public class CreateJDBC{

    ///Main Method
    public static void main(String[] args){

        //JDBC절차에 필요인스턴스 및 정보선언
        Connection con = null;
        Statement stmt = null;
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

        // 1. Connetion :: Login 과정을 추상화한 interface
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("1. driver loaing OK");
        
            con=DriverManager.getConnection(url,"scott","tiger");
            System.out.println("2.connection 인스턴스 생성 완료");
        

        // 2. Statement :: Query 전송을 추상화한 interface

            stmt = con.createStatement();
            System.out.println("3. statement객체 생성 완료");


        //Create Query 만들기
        String createSql =
            "CREATE TABLE firstJDBC"+
                "(no        NUMBER(3),"+
                "name    VARCHAR2(20),"+
                "email    VARCHAR2(30),"+
                "address VARCHAR2(50))";

       
            System.out.println("::QUERY 전송결과 : "+stmt.executeUpdate(createSql) );
            System.out.println("4. query전송완료");
        
           
        }catch(ClassNotFoundException e){
                System.out.println("\n==>Driver Loadint시 Exception 발생\n");
                e.printStackTrace();
        }catch(SQLException e){
            System.out.println("\n==>JDBC 절차 중 Exception 발생 : "+e.getErrorCode());
            e.printStackTrace();
        }finally {
        	try {
        	    if (stmt !=null) {
        			stmt.close();}
            	 if (con !=null) {
         		    con.close();}
        	}catch(SQLException e) {}      
        }
    }//end of main

}//end of class