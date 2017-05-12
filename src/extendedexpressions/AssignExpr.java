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
public class AssignExpr extends Expr{
    Expr one;
    Expr two;
    

    public AssignExpr(Expr a, Expr b){
        one = a;
        two = b;
        //int num = b.value();
        //hm.put(a.print(), num);
        //hm.put(one.print(), two.value());
        //expr = "("+a.print()+" = "+b.print()+")";
        //value = (int)hm.get(a.print());
    }
    
    public int value(){
        hm.put(one.print(), two.value());
        return (int)hm.get(one.print());
    }
    
    public String print(){
        expr = "("+one.print()+" = "+two.print()+")";
        return expr;
    }
    
}
