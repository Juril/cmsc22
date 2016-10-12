package lab9.part2;

public class ResizableCircle extends Circle implements Resizable{
	public ResizableCircle(double radius){
		super(radius);
	}

	public void resize(int percent){
		double convert = percent / 100.0;
		radius += (radius * convert);
	}
}