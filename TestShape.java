import java.util.*;

public class TestShape {
	
	public static void main(String[] args) {
		
	
		Shape sheep = new Shape();
		Shape shift = new Shape("magenta black", false);

		System.out.println(sheep.getColor());
		System.out.println(sheep.isFilled());
		System.out.println(shift.getColor());
		System.out.println(shift.isFilled());
		System.out.println(sheep);
		System.out.println(shift);
		sheep.setColor("Light White");
		sheep.setFilled(false);
		System.out.println(sheep);

		Circle a = new Circle();
		Circle b = new Circle(2f);
		Circle c = new Circle(3f, "Dark Black", true);

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		Rectangle q = new Rectangle();
		Rectangle w = new Rectangle(2f, 5f);
		Rectangle e = new Rectangle(3f, 4f, "Pinkish Orange", false);

		System.out.println(q);
		System.out.println(w);
		System.out.println(e);

		Square skwir = new Square();
		Square squeer = new Square(4f);
		Square squire = new Square(6f, "Tae", true);

		System.out.println(skwir);
		System.out.println(squeer);
		System.out.println(squire);
	}
}