package org.limdongjin.book_study.ch1;
import org.limdongjin.book_study.ch1.StackImpl;
import org.limdongjin.book_study.ch1.Stack;
import org.limdongjin.book_study.ch1.ResizingArrayStack;
class StackTest {
    Stack<Integer> stack;
    
    public StackTest(){
        //stack = new StackImpl();
        stack = new ResizingArrayStack();
    }
    private void run(){ // effectively main function
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("push 1");
        System.out.println("push 2");
        System.out.println("push 3");

        for(var num : stack)
            System.out.printf("%d ", num);
        System.out.println();
        
        System.out.printf("Peek: %d\n" , stack.peek());
        
        System.out.printf("Pop %d\n", stack.pop());
        System.out.printf("Peek: %d\n", stack.peek());
        for(var num : stack)
            System.out.printf("%d ", num);
        System.out.println();
        System.out.printf("Pop %d\n", stack.pop());
        System.out.printf("Pop %d\n", stack.pop());
        for(var num : stack)
            System.out.printf("%d ", num);
        stack.push(5);
        System.out.println("push 5");
        for(var num : stack)
            System.out.printf("%d ", num);
        System.out.println();
    }
    public static void main(String[] args){
        // Stack<Integer> stack = new StackImpl();
        StackTest app = new StackTest();
        app.run();
    }
}