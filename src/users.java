
public class users {
	//int user_id;
	String user_name;
	String email;
	String password;
	//public int getUser_id() {
	//	return user_id;
	//}
	//public void setUser_id(int user_id) {
		//this.user_id = user_id;
	//}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "users [user_name=" + user_name
				+ ", email=" + email + ", password=" + password + "]";
	}
	public users(){}
	public users(String user_name,String email,String password)
	{
		super();
		//this.user_id= user_id;
		this.user_name= user_name;
		this.email= email;
		this.password= password;
	}
}
