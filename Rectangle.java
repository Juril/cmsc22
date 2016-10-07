public class Rectangle extends Shape{
	private double width;
	private double length;

	public Rectangle() {
		width = length = 1.0f;
	}

	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	public Rectangle(double width, double length, String color, boolean filled) {
		super(color, filled);
		this.width = width;
		this.length = length;
		
	}

	public double getWidth() { return width;}

	public double getLength() { return length;}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getArea() {
		return width * length;
	}

	public double getPerimeter() {
		return 2 * (width + length);
	}
	
	public String toString() {
		return String.format("A Rectangle with width = %.2f and length = %.2f which is a subclass of ", width, length) + super.toString();
	}
}