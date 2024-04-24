
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title) {
		this(title, "", "", 0, 0.0f);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		this(title, category, "", 0, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this(title, category, director, 0, cost);
	}
	
	boolean equals(DigitalVideoDisc otherDisc) {
		return (this.title.equals(otherDisc.getTitle()) && this.category.equals(otherDisc.getCategory()) 
				&& this.director.equals(otherDisc.getDirector()) && this.length == otherDisc.getLength() && this.cost == otherDisc.getCost());
	}
}
