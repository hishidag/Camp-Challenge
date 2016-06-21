/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;
import java.util.*;
/**
 *
 * @author user1
 */
public class Dealer extends Human{
    ArrayList<String> cards = new ArrayList<>();    
    
    public Dealer(){
        for(String mark : new String[]{"♠","♥","♦","♣"}){
            for(String num : new String[]{"A ","2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10","J ","Q ","K "}){
                cards.add(mark + num);
            }
        }
    }
    
    public ArrayList deal(){
        ArrayList deal = new ArrayList();           
        for(int i=1; i <= 2;i++){
            deal.add(this.drawCard());
        }
        return deal;
    }
     
    public ArrayList hit(){
        ArrayList<String> hit = new ArrayList<>();       
        hit.add(this.drawCard());    
        return hit;
    }
    
    
    //カードを引くのはhitもdealも一緒
    public String drawCard(){
        Random rand = new Random();
        
        int hit = rand.nextInt(cards.size());
        String str = cards.get(hit);
        cards.remove(hit);
        
        return str;
    }
    
    
    @Override
    public void setCard(ArrayList str){
        this.myCards = str; 
    }
    
    @Override
    public boolean checkSum(){
        return this.open() < 17;
    } 
           
    public void turnDealer(boolean type){
        if(type){
            //手札が17点以上になるまで無限ループ
            while(true){
                this.myCards.add(this.drawCard());
                this.turnDealer(this.checkSum());
            }
        }
        if(this.open() > 21){
            System.out.println("ディーラーはバストしました。あなたの勝ちです");
            System.out.println("ディーラの点数：" + this.open());
            System.out.println("ディーラーの手札：" + this.myCards);
            System.exit(0);
        }            
    }
    
    @Override
    public int open(){
        int sum = 0;
        int suma = 0;
        int a = 0;
        for(String card : myCards){
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
                    suma += 10;
                    break;
                //Aの枚数を数える                    
                case "A":
                    a++;
                    suma += 1;
                    break;
                default:
                    sum += Integer.parseInt(num);
                    suma += Integer.parseInt(num);
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
    

