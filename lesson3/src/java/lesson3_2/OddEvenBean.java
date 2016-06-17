/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3_2;
import java.io.Serializable;
/**
 *
 * @author user1
 */
public class OddEvenBean implements Serializable{
    private int num;
    
    public int getNum(){ return num; }
    
    public void setNum(int num){ this.num = num; }
    
    public boolean isNum(int num){ 
        return num % 2 == 0;
    }
    
    public StringBuilder judgeOddEven(boolean isNum){
        StringBuilder sb = new StringBuilder();
        int a = getNum();
        if(isNum){
            sb.append(a).append("：偶数<br>");
        }else{
            sb.append(a).append("：奇数<br>");
        }
        return sb;
    }
            
}
