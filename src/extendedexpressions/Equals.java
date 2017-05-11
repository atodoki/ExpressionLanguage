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
public class Equals extends BiExpr{
    public Equals(){
        
    }
    public Equals(Expr a, Expr b){
        one = a;
        two = b;
    }
    
    public int value(){
        int b = two.value();
        int a = one.value();
        
        if(a==b){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public String print(){
        expr = "("+one.print()+" == "+two.print()+")";
        return expr;
    }
    
}
