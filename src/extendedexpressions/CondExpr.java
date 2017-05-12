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
public class CondExpr extends Expr{
    Expr one;
    Expr two;
    Expr three;
    boolean bool;
    

    public CondExpr(Expr a, Expr b, Expr c){
        bool = a.value() == 1; //move this out of constructor
        one = a;
        two = b;
        three = c;
        
        //expr = "("+a.print()+" ? "+b.print()+" : "+c.print()+")";
    }
    
    public int value(){
        if(bool){
            return two.value();
        }
        else{
            return three.value();
        }
    }
    
    public String print(){
        expr = "("+one.print()+" ? "+two.print()+" : "+three.print()+")";
        return expr;
    }
    
}
