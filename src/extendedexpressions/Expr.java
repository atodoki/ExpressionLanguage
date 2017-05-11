/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extendedexpressions;

import java.util.HashMap;

/**
 *
 * @author arieltodoki
 */
public class Expr {
    
    public int value;
    public String expr;
    static HashMap hm = new HashMap();
   
    
//    public Expr(Expr e){
//        expr = e.print();
//    }
    
    public int value(){
        return value;
    }
    
    public String print(){
        return expr;
    }
    
    public void clear(){
        hm.clear();
    }
}
