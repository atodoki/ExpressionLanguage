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
public class Mult extends BiExpr{
    public Mult(){
        
    }
    public Mult(Expr a, Expr b){
        //expr = "("+a.print()+" * "+b.print()+")";

        one = a;
        two = b;
    }
    
    public int value(){
        return two.value() * one.value();
    }
    
    public String print(){
        expr = "("+one.print()+" * "+two.print()+")";
        return expr;
    }
}
