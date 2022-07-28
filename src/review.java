public class review {
	int user_id;
	int movie_id;
	String review;
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
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "review [user_id=" + user_id + ", movie_id=" + movie_id
				+ ", review=" + review + "]";
	}
	public review(){}
	public review(int user_id,int movie_id,String review)
	{
		this.user_id=user_id;
		this.movie_id=movie_id;
		this.review=review;
	}
}
