import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ratingDAO
{
	Connection con=null;
	Statement stmt=null;
	
	public ratingDAO()
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
	public int insert(rating r1)
	{
		int r=0;
		try {
			con();
			r = stmt.executeUpdate("insert into rating(movie_id,rating,user_id) values("+r1.getMovie_id()+","+r1.getRating()+","+r1.getUser_id()+");");
	        ResultSet rs= stmt.executeQuery("select avg(Rating) from rating where movie_id="+r1.getMovie_id()+";");
	        rs.next();
	        Float f=rs.getFloat(1);
	        int x=0;
	        x=stmt.executeUpdate("Update movie set Average_rating="+f+" where movie_id="+r1.getMovie_id()+";");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
}