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
public class LitNum extends Expr{

    public LitNum(int i){
        expr = ""+i;
        value = i;
    }

}
