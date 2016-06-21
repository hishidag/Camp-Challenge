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
abstract class Human {
    ArrayList<String> myCards = new ArrayList<>();
    
    public abstract int open();
    public abstract void setCard(ArrayList array);
    public abstract boolean checkSum();
    
}
