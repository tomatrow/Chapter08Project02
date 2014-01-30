abstract class Movie {
	public static enum Rating {
		G,PG,PG_13,R;
	}
	private Rating _rating;
	private int _idNumber;
	private String _title;

	Movie() {
		this(null,0xC0FFEE,null);
	}
	Movie(Rating rating, int idNumber, String title) {	
		setRating(rating);
		setIdNumber(idNumber);
		setTitle(title);
	}

	// getters
	public Rating rating() {
		return _rating;
	}
	public int idNumber() {
		return _idNumber;
	}
	public String title() {
		return _title;
	}

	// setters
	public void setIdNumber(int idNumber) {
		if (idNumber < 0) {
			throw new IllegalArgumentException("ID must be positive");
		}
		_idNumber = idNumber;
	}
	public void setRating(Rating rating) {
		_rating = rating;
	}
	public void setTitle(String title) {
		_title = title;
	}

	// fees are in cents
	abstract int calcLateFees();

	// Object
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		else if (this.getClass() != o.getClass())
			return false;
		else {
			Movie otherMovie = (Movie)o;
			boolean idNumberIsEqual = this.idNumber() == otherMovie.idNumber();
			return idNumberIsEqual;
		}
	}
	@Override
	public int hashCode() {
		return this.rating().ordinal() ^ this.idNumber() ^ this.title().hashCode();
	}


}