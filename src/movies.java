
public class movies {
	String movie_name;
	String cast;
	String summ;
	String gen;
	Float rat;
	int id;
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getSumm() {
		return summ;
	}
	public void setSumm(String summ) {
		this.summ = summ;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public Float getRat() {
		return rat;
	}
	public void setRat(Float rat) {
		this.rat = rat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "movies [movie_name=" + movie_name + ", cast=" + cast
				+ ", summ=" + summ + ", gen=" + gen + ", rat=" + rat + ", id="
				+ id + "]"+"\n";
	}
	public movies(){}
	public movies(String movie_name,String cast,String summ,String gen,Float rat,int id)
	{
		this.movie_name=movie_name;
		this.cast=cast;
		this.summ=summ;
		this.gen=gen;
		this.rat=rat;
		this.id=id;
	}
}
