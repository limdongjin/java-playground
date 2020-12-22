package org.limdongjin.book_study.ch1;

import java.util.Arrays;

import org.limdongjin.data_structure.Stack;
import org.limdongjin.data_structure.StackImpl;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.RuntimeException;
import javax.naming.OperationNotSupportedException;
import org.limdongjin.book_study.ch1.TestUtil;
import java.util.ArrayList;

class Evaluator {
    private Stack<Double> operandStack;
    private Stack<String> operatorStack;
    private List<String> tokens;

    private final static List<String> SKIP = Arrays.asList("\n", "@", "#", "$", "\0", "(");

    private final static Predicate<String> IS_MUL = str -> str.equals("*");
    private final static Predicate<String> IS_SUB = str -> str.equals("-");
    private final static Predicate<String> IS_PLUS = str -> str.equals("+"); 
    private final static Predicate<String> IS_SQRT = str -> str.equals("sqrt") || str.equals("SQRT");
    private final static Predicate<String> IS_DIV = str -> str.equals("/");

    public Evaluator(String inputString){
        operandStack = new StackImpl();
        operatorStack = new StackImpl();
        
        tokens = Arrays.asList(inputString.split(" "))
                        .stream()
                        .filter(e -> !SKIP.contains(e))
                        .collect(Collectors.toList());
    }
    
    private static boolean isOperator(String token){
        return IS_PLUS.or(IS_SUB)
                     .or(IS_DIV)
                     .or(IS_MUL)
                     .or(IS_SQRT)
                     .test(token);
    }

    private void calcOp(){
        double res;
        
        Calculator calculator = new Calculator(this.operatorStack.pop());

        for(int i =0; i < calculator.requiredNumOfOperand(); i++)
            calculator.pushOperand(this.operandStack.pop());
       
        res = calculator.run();
        
        this.operandStack.push(res);
    }

    private void pushToken(String token){
        if(isOperator(token)){
            this.operatorStack.push(token);
            return;
        }
        this.operandStack.push(Double.parseDouble(token));
    }
    public Double run(){        
        for(String token : this.tokens){
            if(token.equals(")")){
                calcOp();
                continue;
            }
            pushToken(token);
        }
        
        return this.operandStack.peek();
    }
    
    private class Calculator {
        private final String operation;
        private Stack<Double> operands; 

        Calculator(String operation){
            this.operation = operation;
            operands = new StackImpl<Double>();
        }
        
        public void pushOperand(Double operand){
            this.operands.push(operand);
        }
        public int requiredNumOfOperand(){
            if(IS_SQRT.test(this.operation)) return 1;
            return 2;
        }
        private double run(){
            double res = 0.0;
            int numOfOperand = this.operands.size();
            List<Double> operandList = new ArrayList();
            
            for(int i = 0; i < numOfOperand; i++){
                operandList.add(this.operands.pop());
            }

            if(IS_PLUS.test(this.operation)){
                res = operandList.get(0) + operandList.get(1);
            }else if(IS_MUL.test(this.operation)){
                res = operandList.get(0) * operandList.get(1);
            }else if(IS_SUB.test(this.operation)){ 
                res = operandList.get(0) - operandList.get(1);
            }else if(IS_SQRT.test(this.operation)){
                res = Math.sqrt(operandList.get(0));
            }else if(IS_DIV.test(this.operation)){
                res = operandList.get(0) / operandList.get(1); 
            } else{
                throw new RuntimeException("Operation Error" + this.operation);
            }

            return res;
        }
    }
    
    public static void main(String[] args){
        double res = 0.0;

        String s1 = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) ";
        System.out.println(s1);
        Evaluator evaluator = new Evaluator(s1);
        res = evaluator.run();
        System.out.println(res);
        // => 101.0
        

        String s2 = "( ( 1 + sqrt ( 5.0 ) ) / 2.0 )";
        System.out.println(s2);
        evaluator = new Evaluator(s2);
        res = evaluator.run();
        System.out.println(res);
        
        // => 1.61803...

        String s3 = "( ( 1 + 5 ) - ( 6 + 7 ) )";
        System.out.println(s3);
        evaluator = new Evaluator(s3);
        res = evaluator.run();
        System.out.println(res);
        // -7.0
    }
}