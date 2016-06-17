/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3_1;
import java.io.Serializable;
/**
 *
 * @author user1
 */
public class ProfileBean implements Serializable {
    private String name;
    private String birth;
    private String text;
    
    public ProfileBean(){}
    
    public String getName(){ return name; }
    
    public void setName(String name){ this.name = name; }
    
    public String getBirth(){ return birth; }
    
    public void setBirth(String birth){ this.birth = birth; }
    
    public String getText(){ return text; }
    
    public void setText(String text){ this.text = text; }
    
    public boolean isSend(){ return true;}
    
    //文字列を連結しjspに返す
    public StringBuilder chainIntro(String name, String birth, String text){ 
        StringBuilder sb = new StringBuilder();
        sb.append("名前：").append(name).append("<br>誕生日：").append(birth).append("<br>文章：").append(text).append("<br>");       
        return sb;
    }
    
    
}