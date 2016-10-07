public class Circle extends Shape{
	protected double radius;

	public Circle() {
		super();
		radius = 1.0f;
	}

	public Circle(double rad) {
		super();
		radius = rad;
	}

	public Circle(double rad, String color, boolean filled) {
		super(color, filled);
		radius = rad;
		
	}

	public double getRadius() { return radius;}

	public void setRadius(double rad) {
		radius = rad;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	public String toString() {
		return String.format("A Circle with radius = %.2f which is a subclass of ", radius) + super.toString();
	}
}