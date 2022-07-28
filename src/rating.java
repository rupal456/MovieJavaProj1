
public class rating {
	int user_id;
	int movie_id;
	int rating;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "rating [user_id=" + user_id + ", movie_id=" + movie_id
				+ ", rating=" + rating + "]";
	}
	public rating(){}
	public rating(int user_id,int movie_id,int rating)
	{
		this.user_id=user_id;
		this.movie_id=movie_id;
		this.rating=rating;
	}
}
