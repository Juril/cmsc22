public class Shape {
	private String color;
	private boolean filled;

	public Shape() {
		color = "green";
		filled = true;
	}

	public Shape(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	public String getColor() { return color;}

	public boolean isFilled() { return filled;}

	public void setColor(String color) { this.color = color;}

	public void setFilled(boolean filled) { this.filled = filled;}

	public String toString() {
		return String.format("A Shape with color of %s and %s", color, filled ? "filled" : "not filled");
	}
}