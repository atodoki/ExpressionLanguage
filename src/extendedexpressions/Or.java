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
public class Or extends BiExpr{

    public Or(Expr a, Expr b){
        one = a;
        two = b;
        //expr = "("+ a.print()+" | "+b.print()+")";
    }
    
    public int value(){
        if ((one.value()!= 0)||(two.value()!=0)){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public String print(){
        expr = "("+ one.print()+" | "+two.print()+")";
        return expr;
    }
    
}
