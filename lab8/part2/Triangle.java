public abstract class Triangle extends Shape{
	protected double side1;
	protected double side2;
	protected double side3;
	
	public Triangle(double side1, double side2, double side3){
		if(side1+side2<side3 || side1+side3<side2 || side2+side3<side1){
			throw new IllegalArgumentException("Triangle sides error");
		}
		else{
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
	}
	
	public double getPerimeter() {
		return (side1 + side2 + side3) / 2;
	}
	
	public double getArea() {
		double p = getPerimeter() / 2;
		return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
	}
}