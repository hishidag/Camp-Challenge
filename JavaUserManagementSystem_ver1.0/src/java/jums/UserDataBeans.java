/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;
import java.io.Serializable;
import jums.checkCharacter.checkEnum;
/**
 *
 * @author user1
 */
public class UserDataBeans implements Serializable {
    String name     = "";
    String year     = ""; 
    String month    = "";
    String day      = "";
    String type     = ""; 
    String tell     = ""; 
    String comment  = "";   
    
    public void UserDateBeans(){}
    
    public String escapeSpecialCharaters(String str){
        if(str == null) {return "";}
        str = str.replaceAll("&","&amp");
        str = str.replaceAll("<", "&lt");
        str = str.replaceAll(">","&gt");
        str = str.replaceAll("\"", "&quot;");
        str = str.replaceAll("'", "&apos;");
        return str;
    }
    
    public String getName(){ return this.name;}
    public void setName(String name){ this.name = this.escapeSpecialCharaters(name);}
    
    public String getYear(){ return this.year;}
    public void setYear(String year){ this.year = this.escapeSpecialCharaters(year);}
      
    public String getMonth(){ return this.month;}
    public void setMonth(String month){ this.month = this.escapeSpecialCharaters(month);}
    
    public String getDay(){ return this.day;}
    public void setDay(String day){ this.day = this.escapeSpecialCharaters(day);}
    
    public String getType(){ return this.type;}
    public void setType(String type){ this.type = this.escapeSpecialCharaters(type);}
    
    public String getTell(){ return this.tell;}
    public void setTell(String tell){ this.tell = this.escapeSpecialCharaters(tell);}
    
    public String getComment(){ return this.comment;}
    public void setComment(String comment){ this.comment = this.escapeSpecialCharaters(comment);}
    
    public void setAllContents(String name,String year,String month,String day,String type,String tell,String comment){
        this.setName(name);
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
        this.setType(type);
        this.setTell(tell);
        this.setComment(comment);        
    }
    
}
