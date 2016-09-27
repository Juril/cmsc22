import java.util.*;

public class StringQueue{
	private String[] elements;
	private int count;
	public static final int DEFAULT_SIZE = 10;

	StringQueue() {
		this(DEFAULT_SIZE);
	}

	StringQueue(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size too small.");
		} else {
			elements = new String[size];
			count = 0;
		}
	}
	public void enqueue(String name){
		if(count == elements.length){
			expand();
		}
		elements[count++] = name;
	}
	public String dequeue(){
		if(count == 0){
			throw new ArrayIndexOutOfBoundsException("No string attached. Hehehehe");
		}
		else{
			String temp = elements[0];
			for(int i = 0; i <= count - 1; i++){
				elements[i] = elements[i+1];
			}
			count--;
			return temp;
		}
	}
	public String dequeue(int pos){
		String holder = new String();
		for(int i = 0; i < pos; i++) {
			holder = dequeue();
		}
		return holder;
	}

	public int size() {
		return count;
	}

	public void singit(String name, int pos){
		if(pos > count){
			enqueue(name);
		}
		else{	
			if(count == elements.length){
				expand();
			}		
			for(int i = count - 1; i >= pos - 1; i--){
				elements[i + 1] = elements[i];
			}
			count++;
			elements[pos - 1] = name;
		}
	}

	public void expand(){
		elements = Arrays.copyOf(elements, elements.length + DEFAULT_SIZE);
	}

	public String peek() {
		if(count == 0) {
			return "EMPTY";
		} else {
			return elements[0];
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
		StringQueue q = new StringQueue(2);
		q.enqueue("jojo");
		q.enqueue("celcel");
		q.enqueue("lukas");
		q.singit("nico",2);
		q.singit("ciriaco",1);
		q.singit("miss cris",2);
		System.out.println(q.peek());
		System.out.println(q); // ciriaco bad bitch, miss cris badass, jojo, nico bad boy, celcel, bosxz lukas

		System.out.println(q.size()); // 6
		q.dequeue();
		System.out.println(q.peek());
		q.dequeue(3);
		System.out.println(q); //celcel, bosxz lukas
	}
}
