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
		
		try { /* ����̹��� ã�� ���� */
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Class.forName()���� ����̹��� �ε��Ѵ�. ����̹� �̸��� Class.forName�� �Է��Ѵ�.
		try { /* �����ͺ��̽��� �����ϴ� ���� */
			con = DriverManager.getConnection(url, userid, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void sql() {
		
	}
	
}

