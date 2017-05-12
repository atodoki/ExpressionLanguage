/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extendedexpressions;

import java.util.Scanner;

/**
 *
 * @author arieltodoki
 */
public class Read extends Expr{
    public Scanner sc = new Scanner(System.in);


    public Read(){

    }
    
    public int value(){
        value= Integer.parseInt(sc.nextLine());
        return value;
    }
    
    public String print(){
//        value = Integer.parseInt(sc.nextLine());
//        expr= ""+value;
        expr = "READ";
        return expr;
    }
    
}
