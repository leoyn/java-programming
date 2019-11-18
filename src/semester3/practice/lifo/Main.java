package semester3.practice.lifo;

public class Main {

	public static void main(String[] args) throws Exception {
		LifoMemory lifo = LifoMemory.create(3, "java.lang.String");
				
		lifo.push("test1");
		lifo.push("test2");
		lifo.push("test3");
		
		System.out.println(lifo.pop());
		System.out.println(lifo.pop());
		
		lifo.push("test4");
		lifo.push("test5");
		
		System.out.println(lifo.pop());
	}
}
