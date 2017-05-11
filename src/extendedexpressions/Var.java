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
public class Var extends Expr{
    String var;
    public Var(String s){
        var = s;
    }
    
    public int value(){
        return (int)hm.get(var);
    }
    
    public String print(){
        expr = var;
        return expr;
    }
    
}
