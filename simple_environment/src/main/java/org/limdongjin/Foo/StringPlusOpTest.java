package org.limdongjin.foo;
import java.util.Arrays;
class StringPlusOpTest {
	public static void main(String[] args){
		String a = "hello";
        	String b = "world";
		String c = "Java";
		String d = "!!";
		a = (a + b + c + d) + a + d;
		// a += b;
		// a += c;
	}


}
