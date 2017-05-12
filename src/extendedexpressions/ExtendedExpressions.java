/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extendedexpressions;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


/**
 *
 * @author arieltodoki
 */
public class ExtendedExpressions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        Expr c = new Plus(new Mult(new Var("x"), new LitNum(3)),new Plus(new LitNum(5), new AssignExpr(new Var("x"), new LitNum(7))));
//
//        Expr d = new Mult(new LitNum(3), new And(new LitNum(5), new Greater(new LitNum(1),new LitNum(0))));
//
//        Expr e = new LitNum(-17);
//
//        Expr f = new Read();
//
//        Expr g = new Plus(new Read(), new Mult(new LitNum(2), new LitNum(3)));
//
//        Expr h = new Plus(new AssignExpr(new Var("x"), new LitNum(2)), new Mult(new Var("x"), new AssignExpr(new Var("x"), new LitNum(7))));
// 
//        Expr i = new Plus(new Plus(new AssignExpr(new Var("x"), new LitNum(3)), new Mult(new LitNum(2), new PreInc(new Var("x")))),new Plus(new Mult(new LitNum(3), new PostInc(new Var("x"))),new AssignExpr(new Var("x"), new LitNum(1))));
//        
//        Expr j = new Plus(new Mult(new Mult(new PostDec(new Var("x")), new Read()),new PreDec(new Var("x"))), new Mult(new AssignExpr(new Var("x"), new Var("y")), new AssignExpr(new Var("y"), new LitNum(3))));
//      
//        Expr[] tests = {c,d,e,f,g,h,i,j};
//        
//        for(int n = 0; n<tests.length; n++){
//        
//            System.out.println(tests[n].print());
//            System.out.println(tests[n].value());
//            System.out.println("\n");
//            tests[n].clear();
//        }
        
        
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> precedence = new HashMap<>();
        //Add to the hashmap
        precedence.put("(", 0);
        precedence.put(")", 0);
        precedence.put("|", 1);
        precedence.put("&", 1);
        precedence.put("==", 2);
        precedence.put("<", 2);
        precedence.put(">", 2);
        precedence.put("-", 3);
        precedence.put("+", 3);
        precedence.put("*", 4);
        precedence.put("=", 5);
        
        while(!sc.hasNext("end")){
            Stack<Expr> arg = new Stack<>();
            Stack<String> op = new Stack<>();
            String[] tokens = sc.nextLine().split(" ");
            
            for(int i = 0; i<tokens.length; i++){
                if (tokens[i].matches("\\d+")){
                    arg.push(new LitNum(Integer.parseInt(tokens[i])));
                }
                else if(tokens[i].matches("READ")){
                    arg.push(new Read());
                }
                else if(tokens[i].matches("\\w+")){
                    arg.push(new Var(tokens[i]));
                }
                else if(tokens[i].matches("\\w+[+][+]")){
                    arg.push(new PostInc(new Var(tokens[i].replaceAll("[+][+]", ""))));
                }
                else if(tokens[i].matches("\\w+[-][-]")){
                    arg.push(new PostDec(new Var(tokens[i].replaceAll("[-][-]", ""))));
                }
                else if(tokens[i].matches("[+][+]\\w+")){
                    arg.push(new PreInc(new Var(tokens[i].replaceAll("[+][+]", ""))));
                }
                else if(tokens[i].matches("[-][-]\\w+")){
                    arg.push(new PreDec(new Var(tokens[i].replaceAll("[-][-]", ""))));
                }
                
                //operators
                else if(tokens[i].equalsIgnoreCase("(")){
                    op.push(tokens[i]);
                }
                else if(op.empty()||op.peek().equalsIgnoreCase("(")||precedence.get(op.peek())< precedence.get(tokens[i])){
                    op.push(tokens[i]);
                }
                else if(precedence.get(op.peek())>=precedence.get(tokens[i])){
                    do{
                    String popped = op.pop();
                    Expr right = new Expr();
                    Expr left = new Expr();
                    if(!arg.empty()){
                        right = arg.pop();
                    }
                    else{
                        System.exit(0);
                    }
                    if(!arg.empty()){
                        left = arg.pop();
                    }
                    else{
                        System.exit(0);
                    }
                    switch(popped){
                        case "=":
                            arg.push(new AssignExpr(left,right));
                            break;
                        case "*":
                            arg.push(new Mult(left, right));
                            break;
                        case "+":
                            arg.push(new Plus(left, right));
                            break;
                        case "-":
                            arg.push(new Sub(left, right));
                            break;
                        case ">":
                            arg.push(new Greater(left, right));
                            break;
                        case "<":
                            arg.push(new Less(left, right));
                            break;
                        case "==":
                            arg.push(new Equals(left, right));
                            break; 
                        case "&":
                            arg.push(new And(left, right));
                            break;
                        case "|":
                            arg.push(new Or(left, right));
                            break;
                        case "(":
                            break;
                        
                    }
                    }while(!op.empty()&&!op.peek().equalsIgnoreCase("(")&&precedence.get(op.peek())>=precedence.get(tokens[i]));
                    if(!tokens[i].equalsIgnoreCase(")")){
                        op.push(tokens[i]);
                    }
                    if(op.peek().equalsIgnoreCase("(")){
                        op.pop();
                    }
                }
                else{
                    System.out.println("ERROR");
                }
                

            }
            
            while(!op.empty()){
                String popped = op.pop();
                Expr right = new Expr();
                Expr left = new Expr();
                if(!arg.empty()){
                    right = arg.pop();
                }
                else{
                    System.exit(0);
                }
                if(!arg.empty()){
                    left = arg.pop();
                }
                else{
                    System.exit(0);    
                }
                    switch(popped){
                        case "=":
                            arg.push(new AssignExpr(left,right));
                            break;
                        case "*":
                            arg.push(new Mult(left, right));
                            break;
                        case "+":
                            arg.push(new Plus(left, right));
                            break;
                        case "-":
                            arg.push(new Sub(left, right));
                            break;
                        case ">":
                            arg.push(new Greater(left, right));
                            break;
                        case "<":
                            arg.push(new Less(left, right));
                            break;
                        case "==":
                            arg.push(new Equals(left, right));
                            break; 
                        case "&":
                            arg.push(new And(left, right));
                            break;
                        case "|":
                            arg.push(new Or(left, right));
                    }
            }
            System.out.println(arg.pop().print());
        }
        

    }

}
