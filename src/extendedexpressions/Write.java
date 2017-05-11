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
public class Write extends Expr{
    Expr one;
    public Write(Expr e){
        
    }
    
    public int value(){
        value = one.value();
        return value;
    }
    
    public String print(){
        expr = one.print();
        return expr;
    }
    
}
