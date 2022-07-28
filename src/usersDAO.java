import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class usersDAO
{
	Connection con=null;
	Statement stmt=null;
	
	public usersDAO()
	{	
	}
	
	public void con() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject1",
				"root", "rupal");
		// here javadb is database name, root is username and password
		stmt = con.createStatement();
	}
	public int insert(users u)
	{
		int r=0;
		try {
			con();
			r = stmt.executeUpdate("insert into users(user_name,email_id,password) values('" +u.getUser_name() +"','"+u.getEmail()+"','" +u.getPassword()+"');");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
//	public int delete(users u) {
//		int r = 0;
//		try {
//			con();
//			r = stmt.executeUpdate("delete from users where user_id ="+u.getUser_id()+";");
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//		return r;
//	}
	public users read(String id,String pass){
		List<users> emps=new ArrayList<>();
		users u = null;
		try {
			con();
			ResultSet rs = stmt.executeQuery("select * from users where email_id='"+id+"';");
			rs.next();
			//users u=new users(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
			if(!rs.getString(4).equals(pass))
				System.out.println("Invalid password!!!");
			else
			u=new users(rs.getString(2),rs.getString(3),rs.getString(4));
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return u;
	}
}
