package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class root {
	Connection con;
	String Driver = "";
	String url = "jdbc:mysql://localhost:3306/?useSSL=false&user=root&password=root&serverTimezone=Asia/Seoul";
	String userid = "madang";
	String pwd = "madang";
	public root(){
		
		try { /* 드라이버를 찾는 과정 */
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Class.forName()으로 드라이버를 로딩한다. 드라이버 이름을 Class.forName에 입력한다.
		try { /* 데이터베이스를 연결하는 과정 */
			con = DriverManager.getConnection(url, userid, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void sql() {
		
	}
	
}

