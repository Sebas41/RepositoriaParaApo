package model;

public class Book extends Item {

	private String review;
	private Genre genre;
	private double price;
	private double unitsSold;

	public Book(String id, String name,int pagesNumber,String review,String publicationDate, 
    Genre genre, String url,
    double price,double unitsSold,long readedPages) {
    super(id,name,pagesNumber,publicationDate,url,readedPages);
    this.review=review;
    this.genre = genre;
    this.price = price;
    this.unitsSold=unitsSold;
	}

	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}

    public Double getIngreso() {
        return null;
    }

    public void setIngreso(double d) {
    }

}

