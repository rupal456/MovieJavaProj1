import java.util.List;
import java.util.Scanner;
public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Type 1 for new user\nType 2 for existing user\nType 3 to exit");
			System.out.println("User Input:");
			int ip=sc.nextInt();
			if(ip==1)
			{
				String waste=sc.nextLine();
				System.out.print("Enter name:");
				String name=sc.nextLine();
				//System.out.println("Enter id:");
				//int id=sc.nextInt();
				System.out.print("Enter email:");
				String email=sc.nextLine();
				System.out.print("Enter password:");
				String pass=sc.nextLine();
				users u=new users(name,email,pass);
				usersDAO udao=new usersDAO();
				System.out.println(u);
				udao.insert(u);
				System.out.println("New user created!");
				continue;
			}
			else if(ip==2)
			{
				usersDAO udao=new usersDAO();
				String waste1=sc.nextLine();
				System.out.println("Enter email ID:");
				String ip1=sc.nextLine();
				System.out.println("Enter user password:");
				String ip2=sc.nextLine();
				users emps=udao.read(ip1,ip2);
				System.out.println(emps);
				while(true){
				System.out.println("Type 1 to add a new movie\nType 2 to edit a movie\nType 3 to add a review\nType 4 to add rating to a movie"
						+"\nType 5 to view movies by genre\nType 6 to view movie details\nType 7 to view top 10 movies overall\nTye 8 to view top 10 movies by genre\nType 56 to logout");
				System.out.println("User Input:");
				int i1=sc.nextInt();
				//Add a new movie
				if(i1==1)
				{
					moviesDAO mdao=new moviesDAO();
					String waste=sc.nextLine();
					System.out.println("Enter movie_name:");
					String name=sc.nextLine();
					System.out.println("Enter cast:");
					String cast=sc.nextLine();
					System.out.println("Enter summary:");
					String summ=sc.nextLine();
					System.out.println("Enter genre:");
					String gen=sc.nextLine();
					//System.out.println("Enter rating:");
					Float rat=0.0f;
					int id=mdao.id_return(ip1);
					System.out.println(id);
					movies m=new movies(name,cast,summ,gen,rat,id);
					mdao.insert(m);
					System.out.println("New movie added!");
					continue;
				}
				//Edit a movie
				else if(i1==2)
				{
					moviesDAO mdao=new moviesDAO();
					String waste=sc.nextLine();
					System.out.println("Enter movie_name:");
					String name=sc.nextLine();
					System.out.println("Enter cast:");
					String cast=sc.nextLine();
					System.out.println("Enter summary:");
					String summ=sc.nextLine();
					System.out.println("Enter genre:");
					String gen=sc.nextLine();
					//System.out.println("Enter rating:");
					Float rat=mdao.return_rating(name);
					int id=mdao.id_return(ip1);
					System.out.println(id);
					movies m=new movies(name,cast,summ,gen,rat,id);
					mdao.update(m);
					System.out.println("Movie updated!");
					continue;
				}
				//Add a review
				else if(i1==3)
				{
					reviewDAO rdao=new reviewDAO();
					String waste=sc.nextLine();
					System.out.println("Enter movie_name:");
					String name=sc.nextLine();
					System.out.println("Enter review:");
					String rev=sc.nextLine();
					int id=rdao.id_return(ip1);
					//System.out.println(id);
					int movie_id=rdao.movie_id_return(name);
					review r=new review(id,movie_id,rev);
					rdao.insert(r);
					System.out.println("New review for movie '"+name+"' added!");
					continue;
				}
				//Add rating
				else if(i1==4)
				{
					ratingDAO rdao=new ratingDAO();
					String waste=sc.nextLine();
					System.out.println("Enter movie_name:");
					String name=sc.nextLine();
					System.out.println("Enter rating:");
					int rat=sc.nextInt();
					int id=rdao.id_return(ip1);
					//System.out.println(id);
					int movie_id=rdao.movie_id_return(name);
					rating r=new rating(id,movie_id,rat);
					rdao.insert(r);
					System.out.println("New rating for movie '"+name+"' added!");
					continue;
				}
				//View movies by genre
				else if(i1==5)
				{
					moviesDAO mdao=new moviesDAO();
					String waste=sc.nextLine();
					System.out.println("Enter genre:");
					String gen=sc.nextLine();
					int id=mdao.id_return(ip1);
					//System.out.println(id);
					//movies m=new movies(name,cast,summ,gen,rat,id);
					System.out.println("Movies in "+gen+" genre are:");
					List<movies> ls=mdao.read(gen);
					System.out.println(ls);
					//mdao.update(m);
					//System.out.println("Movie updated!");
					continue;
				}
				//Search for a movie via movie_name
				else if(i1==6)
				{
					moviesDAO mdao=new moviesDAO();
					String waste=sc.nextLine();
					System.out.println("Enter movie_name:");
					String name=sc.nextLine();
					int id=mdao.id_return(ip1);
					//System.out.println(id);
					//movies m=new movies(name,cast,summ,gen,rat,id);
					System.out.println("Details of movie "+name+" are:");
					List<movies> ls=mdao.read_movie(name);
					System.out.println(ls);
					//mdao.update(m);
					//System.out.println("Movie updated!");
					continue;
				}
				//top 10 movies
				else if(i1==7)
				{
					moviesDAO mdao=new moviesDAO();
					String waste=sc.nextLine();
					//System.out.println("Enter movie_name:");
					//String name=sc.nextLine();
					int id=mdao.id_return(ip1);
					//System.out.println(id);
					//movies m=new movies(name,cast,summ,gen,rat,id);
					System.out.println("Overall top 10 movies are:");
					List<movies> ls=mdao.read_movietop10();
					System.out.println(ls);
					//mdao.update(m);
					//System.out.println("Movie updated!");
					continue;
				}
				//top 10 movies by genre
				else if(i1==8)
				{
					moviesDAO mdao=new moviesDAO();
					String waste=sc.nextLine();
					System.out.println("Enter genre:");
					String gen=sc.nextLine();
					int id=mdao.id_return(ip1);
					//System.out.println(id);
					//movies m=new movies(name,cast,summ,gen,rat,id);
					System.out.println("Top 10 movies of "+gen+" genre are:");
					List<movies> ls=mdao.read_movietop10genre(gen);
					System.out.println(ls);
					//mdao.update(m);
					//System.out.println("Movie updated!");
					continue;
				}
				else if(i1==56)
				{
					break;
				}
				}
				continue;
			}
			else if(ip==3)
			{
				System.out.println("Bye!");
				return;
			}
			else
			{
				System.out.println("Invalid Input ");
				continue;
			}
		}	
		}
}