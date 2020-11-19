package org.limdongjin.Foo;
import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;

class Qoo {
	public static void main(String[] args){
		System.out.println("J");
		List<Integer> list = Arrays.asList(1,2 ,3);
		System.out.println(list); 
		list.forEach((value) -> System.out.println(value));
		list.forEach(new Consumer<Integer>(){
			@Override
			public void accept(Integer t){ System.out.println(t); }
		});
		
		Consumer<Integer> consumer = (value) -> System.out.println(value);
		list.forEach(consumer);  
	}
}
