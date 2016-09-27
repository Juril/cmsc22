import java.util.*;

public class StringStack{
	private String[] elements;
	private int count;
	public static final int DEFAULT_SIZE = 10;

	StringStack() {
		this(DEFAULT_SIZE);
	}

	StringStack(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size too small.");
		} else {
			elements = new String[size];
			count = 0;
		}
	}
	public int size() {
		return count;
	}

	public void push(String item) {
		if(count >= elements.length) {
			//expand()
			elements = Arrays.copyOf(elements, elements.length + DEFAULT_SIZE);
		}
		elements[count++] = item;
	}

	public String pop() {
		if(count == 0) {
			throw new ArrayIndexOutOfBoundsException("No string attached. Hehehehe");
		} else {
			return elements[--count];
		}
	}
	public String pop(int n) {
		String holder = new String();
		for(int i = 0; i < n; i++) {
			holder = pop();
		}
		return holder;
	}

	public String peek() {
		if(count == 0) {
			return "EMPTY";
		} else {
			return elements[count - 1];
		}
	}

	public String toString()  {
		String temp = elements[0];
		for(int i = 1; i < count; i++) {
			temp += ", " + elements[i];
		}
		return temp;
	}

	public static void main(String[] args) {
		StringStack stack = new StringStack(2);
		stack.push("paper");
		stack.push("tissue");
		stack.push("plastic");

		System.out.println(stack); // paper, tissue, plastic
		System.out.println(stack.size()); // 3

	}
}
