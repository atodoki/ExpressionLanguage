/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extendedexpressions;

/**
 *
 * @author arieltodoki
 */
public class Sub extends BiExpr{


    public Sub(Expr a, Expr b){
        one = a;
        two = b;
        //expr = "("+a.print()+" - "+b.print()+")";
    }
    
    public int value(){
        int b = two.value();
        int a = one.value();
        
        return a - b;
    }
    
    public String print(){
        expr = "("+one.print()+" - "+two.print()+")";
        return expr;
    }
    
}
