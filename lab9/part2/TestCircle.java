package lab9.part2;

public class TestCircle{
	public static void main(String[] args) {
		GeometricObject c1 = new Circle(5.0);
		double x = c1.getPerimeter();
		double y = c1.getArea();
		System.out.println(x);
		System.out.println(y);
	}	
}
	