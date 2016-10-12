package lab9.part2;

public class TestResizableCircle{
	public static void main(String[] args) {
		Circle c1 = new ResizableCircle(10.0);
		double x = c1.getPerimeter();
		double y = c1.getArea();
		System.out.println(x);
		System.out.println(y);
		((Resizable) c1).resize(50);
		System.out.printf("Perimeter: %.2f\n Area: %.2f\n",c1.getPerimeter(), c1.getArea());
	}	
}
	