import java.util.ArrayList;

public class Review {

	private int rating;
	private int ratingID;
	private String username;
	private String description;
	private static Review reviewList;

	public Review(int rating, String username, String description)
	{
		this.rating = rating;
		this.username = username;
		this.description = description;
	}

	public int getRating()
	{
		return 0;
	}

	public String toString()
	{
		String s;
		s = super.toString();
		return s;
	}

	public int getRatingID() {
    return ratingID;
  }

  public void setRatingID(int ratingID) {
    this.ratingID = ratingID;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

	public static Review getInstance()
	{
		if(reviewList == null)
		{
			reviewList = new Review();
		}
		return reviewList;
	}
}
