package ex18lambda;

import java.util.function.Consumer;

public class Ex06Define3Consumer {

	public static void main(String[] args) {
		
		/*
		interface Consumer<T>{
			void accept(T t);
		}
		 */
		
		Consumer<String> c1 = (String s) -> {
			System.out.println(s + " 는 가수입니다.");
		};
		c1.accept("빅뱅");
		
		Consumer<String> c2 = (String str) -> {
			System.out.println(str + "은 과일입니다.");
		};
		c2.accept("Strawberry");
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
