/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectoriented1;

/**
 *
 * @author user1
 */
public class ObjectLesson {
    public int num = 0;
    public String str = "";
    
    public void setField(){
        this.num = 2;
        this.str = "Hello";
    }
    
    
    public void printClass(){
        System.out.println(this.num + this.str);
    }
    
}
