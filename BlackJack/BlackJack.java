/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;
import BlackJack.Dealer;
import BlackJack.User;
import java.util.*;

/**
 *
 * @author user1
 */
public class BlackJack {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dealer d = new Dealer();
        User u = new User();
        
        System.out.println("ようこそ！");       
        //ディールまで
        d.setCard(d.deal());
        System.out.println("ディーラーの手札：" + d.myCards.get(0) + "ディーラーの枚数:" + d.myCards.size()+ "枚");        
        u.setCard(d.deal());        
        
        //特定の文字列が押されるまで無限ループさせる。
        //Hitのときも22点を越えるとjavaを終えるようにu.check.sum()で処理してある
        OUTER:
        while(true) {
            u.turnUser(u.checkSum());
            System.out.println("Please type \"h\" or \"s\"");
            Scanner scan = new Scanner(System.in);
            switch (scan.next()) {
                    case "h":
                    case "Hit":
                        u.myCards.add(d.drawCard());
                        break;
                    case "Stand":
                    case "s":
                        break OUTER;
                    default:
                        break;
            }
        }
        //ディーラーのターン
        d.turnDealer(d.checkSum());
        
        //結果の表示
        System.out.println("ディーラーの手札：" + d.myCards);        
        System.out.println("ディーラーの点数：" + d.open());
        if(d.open() > u.open()){
            System.out.println("ディーラの勝利です");
        }else if(d.open() == u.open()){
            System.out.println("引き分けです");
        }else{
            System.out.println("あなたの勝利です");
        }
    
     
    }
        
}
