import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class moviesDAO
{
	Connection con=null;
	Statement stmt=null;
	
	public moviesDAO()
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
	public int insert(movies m)
	{
		int r=0;
		try {
			con();
			r = stmt.executeUpdate("insert into  movie(movie_name,cast,Summary,Genre,Average_rating,user_id) values('" +m.getMovie_name()+"','"+m.getCast()+
					"','" +m.getSumm()+"','"+m.getGen()+"',"+m.getRat()+","+m.getId()+");");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	public int update(movies m)
	{
		int r=0;
		try {
			con();
			r = stmt.executeUpdate("update movie set cast='"+m.getCast()+"',Summary='"+m.getSumm()+"',Genre='"+m.getGen()+"',Average_rating="+m.getRat()+",user_id="+m.getId()+" where movie_name='"+m.getMovie_name()+"';");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
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
	public Float return_rating(String name)
	{
		Float id=null;
		try
		{
			con();
			ResultSet rs = stmt.executeQuery("select Average_rating from movie where movie_name='" +name+"';");
			rs.next();
			id=rs.getFloat(1);
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return id;
	}
	public List<movies> read(String genre){
		List<movies> ls=new ArrayList<>();
		try {
			con();
			ResultSet rs = stmt.executeQuery("select * from movie where Genre='"+genre+"';");
			while (rs.next())
				ls.add(new movies(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getInt(7)));
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return ls;
	}
	public List<movies> read_movie(String name){
		List<movies> ls=new ArrayList<>();
		try {
			con();
			ResultSet rs = stmt.executeQuery("select * from movie where movie_name='"+name+"';");
			while (rs.next())
				ls.add(new movies(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getInt(7)));
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return ls;
	}
	public List<movies> read_movietop10(){
		List<movies> ls=new ArrayList<>();
		try {
			con();
			ResultSet rs = stmt.executeQuery("select * from movie order by Average_rating desc limit 10;");
			while (rs.next())
				ls.add(new movies(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getInt(7)));
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return ls;
	}
	public List<movies> read_movietop10genre(String gen){
		List<movies> ls=new ArrayList<>();
		try {
			con();
			ResultSet rs = stmt.executeQuery("select * from movie where Genre='"+gen+"' order by Average_rating desc limit 10;");
			while (rs.next())
				ls.add(new movies(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getInt(7)));
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return ls;
	}
}