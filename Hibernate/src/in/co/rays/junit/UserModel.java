package in.co.rays.junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserModel {
	public static UserBean findByPk(int pk) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from emp where id =?");
		ps.setInt(1, pk);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getNString(2));
			bean.setSalary(rs.getShort(3));
		}
		return bean;

	}

	public static void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into emp values(?, ?, ?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getSalary());

		int i = ps.executeUpdate();

		System.out.println("Data Inserted " + i);

	}

}
