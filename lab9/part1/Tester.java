package lab9.part1;

public class Tester{
	public static void main(String[] args) {
		Movable m1 = new MovablePoint(5, 6, 10, 10);
		System.out.println(m1);
		m1.moveLeft();
		System.out.println(m1);
		m1.moveDown();
		System.out.println(m1);
		m1.moveDown();
		System.out.println(m1);
		m1.moveRight();
		System.out.println(m1);
		m1.moveRight();
		System.out.println(m1);
		m1.moveRight();
		System.out.println(m1);

		Movable m2 = new MovableCircle(2, 1, 20, 20, 5);
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);
		m2.moveUp();
		System.out.println(m2);
		m2.moveUp();
		System.out.println(m2);
		m2.moveLeft();
		System.out.println(m2);
		m2.moveDown();
		System.out.println(m2);
		m2.moveDown();
		System.out.println(m2);
		m2.moveDown();
		System.out.println(m2);

		Movable m3 = new MovableRectangle(0, 0, 3, 4, 20, 20);
		System.out.println(m3);
		m3.moveRight();
		System.out.println(m3);
		m3.moveRight();
		System.out.println(m3);
		m3.moveUp();
		System.out.println(m3);
		m3.moveUp();
		System.out.println(m3);
		m3.moveLeft();
		System.out.println(m3);
		m3.moveDown();
		System.out.println(m3);
		m3.moveDown();
		System.out.println(m3);
		m3.moveDown();
		System.out.println(m3);

	}

}