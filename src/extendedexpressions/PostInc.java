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
public class PostInc extends Expr{
    
    String var;
    public PostInc(Var v){
        var = v.print();

        //expr = "("+var+"++)";
    }
    
    public int value(){
        value = (int)hm.get(var);
        hm.replace(var, value+1);
        return value;
    }
    
    public String print(){
        expr = "("+var+"++)";
        return expr;
    }
}
