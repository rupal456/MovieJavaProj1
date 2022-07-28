import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class reviewDAO
{
	Connection con=null;
	Statement stmt=null;
	
	public reviewDAO()
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
	public int id_return(String mail)
	{
		int id=0;
		try
		{
			con();
			ResultSet rs = stmt.executeQuery("select user_id from users where email_id='" +mail+"';");
			rs.next();
			id=rs.getInt(1);
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return id;
	}
	public int movie_id_return(String name)
	{
		int id=0;
		try
		{
			con();
			ResultSet rs = stmt.executeQuery("select movie_id from movie where movie_name='" +name+"';");
			rs.next();
			id=rs.getInt(1);
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return id;
	}
	public int insert(review r1)
	{
		int r=0;
		try {
			con();
			r = stmt.executeUpdate("insert into review(user_id,movie_id,reviewtext) values("+r1.getUser_id()+","+r1.getMovie_id()+",'"+r1.getReview()+"');");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
}