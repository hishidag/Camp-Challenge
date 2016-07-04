/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

/**
 *
 * @author user1
 * 課題４
 */
public class CheckCharacter {   
    public boolean isAllCheck = true;
    
    public void sanitizeCheck(){
        isAllCheck = true;
    }
    
    public enum checkEnum{
        emptyerr,
        tellerr,
        numbererr,
        ok
    }
    
    public String errorString(checkEnum checkEnum){
        if(checkEnum == checkEnum.emptyerr){
            isAllCheck = false;
            return "フォームが空です";
        }        
        if(checkEnum == checkEnum.tellerr){
            isAllCheck = false;
            return "電話番号は数字と\"-\"のみ使用できます";
        }        
        if(checkEnum == checkEnum.numbererr){
            isAllCheck = false;
            return "数字のみ使用できます";
        }
        return "OK";
    } 
    
    public String checkCharacter(String str){
        if("".equals(str) || str == null){
            return errorString(checkEnum.emptyerr);
        }
        return errorString(checkEnum.ok);
    }
    
    public String checkTell(String str){
        if("".equals(str) || str == null){
            return errorString(checkEnum.emptyerr);
        }else if(!str.matches("[-0-9]+")){
            return errorString(checkEnum.tellerr);
        }        
        return errorString(checkEnum.ok);
    }
    
    public String checkNumber(String str){
        if("".equals(str) || str == null){
            return errorString(checkEnum.emptyerr);
        }else if(!str.matches("[0-9]+")){
            return errorString(checkEnum.numbererr);
        }
        return errorString(checkEnum.ok);
    }    

}
