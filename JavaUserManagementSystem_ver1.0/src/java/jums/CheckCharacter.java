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
 * Formから受け取った文字列をチェックするクラスです
 * 
 * 
 */
public class CheckCharacter {   
    //ひとつでもOKではない項目が出てきた場合にfalseに
    public boolean isAllCheck;
    //呼び出した際にtrueで初期化
    public CheckCharacter(){
        isAllCheck = true;
    }
    //エラーの種類定義
    public enum checkEnum{
        emptyerr,
        tellerr,
        numbererr,
        ok
    }
    //エラー文章定義
    public final String errorString(checkEnum checkEnum){
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
    //空でなければ可
    public String checkCharacter(String str){
        if("".equals(str) || str == null){
            return errorString(checkEnum.emptyerr);
        }
        return errorString(checkEnum.ok);
    }
    //数字か"-"のみ可
    public String checkTell(String str){
        if("".equals(str) || str == null){
            return errorString(checkEnum.emptyerr);
        }else if(!str.matches("[-0-9]+")){
            return errorString(checkEnum.tellerr);
        }        
        return errorString(checkEnum.ok);
    }
    //数字のみ可
    public String checkNumber(String str){
        if("".equals(str) || str == null){
            return errorString(checkEnum.emptyerr);
        }else if(!str.matches("[0-9]+")){
            return errorString(checkEnum.numbererr);
        }
        return errorString(checkEnum.ok);
    }    

}
