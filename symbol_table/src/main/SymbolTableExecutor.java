package symbol_table.src.main;

import symbol_table.src.main.symboltable.BinarySearchST;
import symbol_table.src.main.symboltable.ISt;

    
public class SymbolTableExecutor {
    public static void main(String args[]){
        // System.out.println("hello world");
        ISt<String, Integer> mySymbolTable;
        
        mySymbolTable = new BinarySearchST<String, Integer>(5);
        
        // System.out.println(mySymbolTable.size());
        mySymbolTable.put("ABC", 24);
        // System.out.println(mySymbolTable.get(25));
        mySymbolTable.put("ABB", 23);
        mySymbolTable.put("BBD", 26);
        // System.out.println(mySymbolTable.get("hello"));
        mySymbolTable.put("ABD", 25);
        
        for(String s : mySymbolTable.keys()){
           System.out.println(s);         
        }
    }
    
    
}