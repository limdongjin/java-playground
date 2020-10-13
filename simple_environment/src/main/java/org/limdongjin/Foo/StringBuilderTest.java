package org.limdongjin.foo;
import java.util.Arrays;
class StringBuilderTest {
	public static void main(String[] args){
		String helloWorldString = "Hello";
		String world = "world";
		String c = "java";	
		StringBuilder stringBuilder = new StringBuilder(helloWorldString);
		stringBuilder.append(world);
		stringBuilder.append(c);
		helloWorldString = stringBuilder.toString();
	}


}
