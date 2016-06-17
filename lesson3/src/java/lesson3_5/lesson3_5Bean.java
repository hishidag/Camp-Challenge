/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3_5;
import java.io.Serializable;
import java.util.*;
import java.time.*;

/**
 *
 * @author user1
 */
public class lesson3_5Bean implements Serializable{
    private Integer id;
    private String name;
    private LocalDate birth;
    private String address;
    HashMap<Integer,Set> hMap = new HashMap<Integer,Set>();
    
    void lesson3_5Bean(){}
    
    public Integer getId(){ return id ;}
    public void setId(Integer id){ this.id = id; }
    
    public String getName(){ return name ;}
    public void setName(String name){ this.name = name; }
    
    public LocalDate getBirth(){ return birth ;}
    public void setBirth(int y, int m ,int d){ this.birth = LocalDate.of(y,m,d); }
    
    public String getAddress(){ return address ;}
    public void setAddress(String address){ this.address = address; }
    
    public Set getSet(Integer id){ return hMap.get(id); }
    
    public HashMap<Integer,Set> getMap(){ return hMap; }
    
    //key=id,value=setのMap
    public void setMap(Integer id){
        Set set = new LinkedHashSet();
        hMap.put(id, set);
        set.add(name);
        set.add(birth);
        set.add(address);
        
    }
    
    public void tom(){
        this.id = 10;
        this.name = "Tom";
        this.birth = LocalDate.of(1982, 4, 20);
        this.address = "Tokyo";    
        this.setMap(id);
    }
    
    public void john(){
        this.id = 20;
        this.name = "John";
        this.birth = LocalDate.of(1975, 12, 13);
        this.address = null;    
        this.setMap(id);
    }
    
    public void mai(){
        this.id = 30;
        this.name = "Mai";
        this.birth = LocalDate.of(2000, 1, 1);
        this.address = "Okinawa";    
        this.setMap(id);
    }
    
}
