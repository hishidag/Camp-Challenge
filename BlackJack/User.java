/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;

/**
 *
 * @author user1
 */
public class User extends Human {

    
    
    @Override
    public void setCard(ArrayList str){
        this.myCards = str; 
    }

    @Override
    public boolean checkSum(){
        System.out.println("あなたの手札：" + this.myCards);
        System.out.println("あなたの点数は：" + this.open());
        return this.open() < 21;
    }
   
    public void turnUser(boolean type){
        if(type){
            System.out.println("Hit or Stand?");        
        }else if(this.open() == 21){
            System.out.println("ブラックジャック！あなたの勝利です");
            System.exit(0);
        }else{
            System.out.println("あなたはバストしました。あなたの負けです。");
            System.exit(0);
        }
    }
    
    
    @Override
    public int open(){
        int sum = 0;
        int a = 0;
        
        for(String card : myCards){
            //substringの第２引数のendindexは取り出す値に含まれない
            String nums = card.substring(1, 3);
            //空白を削った要素
            String num = nums.trim();
            if(null != num) 
            switch (num) {
                //J,Q,Kは10扱い
                case "J":
                case "Q":
                case "K":
                    sum += 10;
                    break;
                //Aの枚数を数える
                case "A":
                    a++;
                    break;
                default:
                    sum += Integer.parseInt(num);
                    break;
            }            
        }
        //Aの判定
        while(a > 0){
            if(sum < 11){
                sum += 11;
            }else{
                sum += 1;
            }
            a--;          
        }
        
        return sum;
    }
}
