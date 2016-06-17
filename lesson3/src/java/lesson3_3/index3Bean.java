/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3_3;
import java.io.Serializable;

/**
 *
 * @author user1
 */
public class index3Bean implements Serializable{
    private int first ;
    private int five ;
    private boolean type;
   
    
    public index3Bean(){}
   
    /*
    public int getIndex1(){ return first; }
    
    public void setIndex1(int first){ this.first = first;}
    
    public int getIndex2(){ return five;}
    
    public void setIndex2(int five){this.five = five;}
    
    public boolean getIndex3(){ return type;}
    
    public void setIndex3(boolean type){ this.type = type ;}
    */
    
    
    //引数が３つのメソッドの定義 
    public Integer squareIndex(int first){
        return squareIndex( first , 5 , false);
    }
    
    public Integer squareIndex(int first,boolean type){
        return squareIndex( first , 5 , type);
    }
    
    public Integer squareIndex(int first,int five){
        return squareIndex( first , five , false);
    }
    
    public Integer squareIndex(int first,int five,boolean type){        
        if(type){
            return (first * five) * (first * five) ;
        }else{
            return (first * five) ;
        }
    }
    
}

