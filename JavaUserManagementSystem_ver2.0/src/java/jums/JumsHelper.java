package jums;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;


/**
 * 画面系の処理や表示を簡略化するためのヘルパークラス。定数なども保存されます
 * @author hayashi-s
 */
public class JumsHelper {
    
    //トップへのリンクを定数として設定
    private final String homeURL = "index.jsp";
    private final String searchresultURL = "SearchResult?";
    private final String resultdetailURL = "ResultDetail?";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //メニューを表示するためのdiv要素です。
    //このメニューにホームページ、新規登録ページ、検索ページへのリンクがあります
    public String menu(){
        return 
"   <div id=\"menu\">\n" +
"        <div class=\"pure-menu\">\n" +
"            <a class=\"pure-menu-heading\">jums</a>\n" +
"            <ul class=\"pure-menu-list\">\n" +
"                <li class=\"pure-menu-item\">\n" +
"                    <a class=\"pure-menu-link\" href=\"index.jsp\">Home</a>\n" +
"                </li>\n" +
"                <li class=\"pure-menu-item\">\n" +
"                    <a class=\"pure-menu-link\" href=\"insert\">新規登録</a>\n" +
"                </li>\n" +
"                <li class=\"pure-menu-item\">\n" +
"                    <a class=\"pure-menu-link\" href=\"Search\">検索(修正・削除)</a>\n" +
"                </li>\n" +
"            </ul>\n" +
"        </div>\n" +
"    </div>";
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    /**検索画面へのリンクを返却。
    * @param name 検索した名前
    * @param year 検索した生年
    * @param type 検索した業種
    * @throws UnsupportedEncodingException UTF-8は存在するので特に関係なし
    * @return リンク先URL。HTML表記用の処理済。
    **/
    public String searchresult(String name,int year,int type) throws UnsupportedEncodingException{
        name = URLEncoder.encode("", "UTF-8");
        return "<a href=\""+searchresultURL+"name="+"&year="+year+"&type="+type+"\">検索結果へ戻る</a>";
    }
    /**詳細画面へのリンクを返却。
    * @param id 詳細画面に表示されるデータのuserID
    * @return リンク先URL。HTML表記用の処理済。
    **/
    public String resultdetail(int id){
        return "<a href=\""+resultdetailURL+"id="+ id + "\">詳細画面へ戻る</a>";
    }
    
    /**
     * 入力されたデータのうち未入力項目がある場合、チェックリストにしたがいどの項目が
     * 未入力なのかのhtml文を返却する
     * @param chkList　UserDataBeansで生成されるリスト。未入力要素の名前が格納されている
     * @return 未入力の項目に対応する文字列
     */
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "名前";
                }
                if(val.equals("year")){
                    output +="年";
                }
                if(val.equals("month")){
                    output +="月";
                }
                if(val.equals("day")){
                    output +="日";
                }
                if(val.equals("type")){
                    output +="種別";
                }
                if(val.equals("tell")){
                    output +="電話番号";
                }
                if(val.equals("comment")){
                    output +="自己紹介";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
    /**
     * 種別は数字で取り扱っているので画面に表示するときは日本語に変換
     * @param i
     * @return 
     */
    public String exTypenum(int i){
        switch(i){
            case 1:
                return "営業";
            case 2:
                return "エンジニア";
            case 3:
                return "その他";
        }
        return "";
    }
 
    public int getYear(Date d){
       return Integer.parseInt(new SimpleDateFormat("yyyy").format(d));
    }
    
    public int getMonth(Date d){
       return Integer.parseInt(new SimpleDateFormat("MM").format(d));
    }
    
    public int getDay(Date d){
       return Integer.parseInt(new SimpleDateFormat("dd").format(d));
    }
    
    /*
    種別を表す項目を文字化して返却
    */
    public String getTypeForm(){
        return getTypeForm(true,0);
    }
    public String getTypeForm(int type){
        return getTypeForm(true,type);
    }
    public String getTypeForm(Boolean flag,int type){
        String str = "";
        for(int i = 1 ; i <=3 ; i++){
            str += "<input type=\"radio\" name=\"type\" value="+ i;
            if(flag && i == type){
                str += " checked";
            }
            str += ">" + this.exTypenum(i) + "<br>";
        }
        return str;
    }
    
    /*
    生年月日をあらわす項目を文字化して返却
    */
    public String getYearForm(){
        return getYearForm(true,0);
    }
    public String getYearForm(Integer year){
        return getYearForm(true,year);
    }
    public String getYearForm(Boolean type,Integer year){
        String str = "";
        str += "<select name=\"year\"><option value=\"\">----</option>";
        for(int i = 1950; i <= 2010 ; i++){
            str += "<option value="+ i;
            if(type && year == i){
                str += " selected = \"selected\"";
            }
            str +=">"+ i +"</option>";
        }
        str += "</select>年";
        return str;
    }
    
    public String getMonthForm(){
        return getMonthForm(true,0);
    }  
    public String getMonthForm(Integer month){
        return getMonthForm(true,month);
    }
    public String getMonthForm(Boolean type,Integer month){
        String str = "";
        str += "<select name=\"month\"><option value=\"\">--</option>";
        for(int i = 1; i <= 12 ; i++){
            str += "<option value="+ i;
            if(type && month == i){
                str += " selected = \"selected\"";
            }
            str+= ">" + i + "</option>";
        }
        str += "</select>月";
        return str;
    }
    
    public String getDayForm(){
        return getDayForm(true,0);
    }
    public String getDayForm(Integer day){
        return getDayForm(true,day);
    }
    public String getDayForm(Boolean type,Integer day){
        String str = "";
        str += "<select name=\"day\"><option value=\"\">--</option>";
        for(int i = 1; i <= 31 ; i++){
            str += "<option value="+ i ;
            if(type && day == i){
                str += " selected = \"selected\"";
            }
            str += ">"+ i + "</option>";
        }
        str += "</select>日";
        return str;
    }    
    
}