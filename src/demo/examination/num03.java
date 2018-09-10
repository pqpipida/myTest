package demo.examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dd  on  2018/9/9.
 * 头条 03
 */

public class num03{

    static List<String> result;
    static  char[] digits;
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner s = new Scanner(System.in);
        String str = null;
        System.out.println("请输入您想输入的字符串：");
        str = s.next();
        long pre1 = System.currentTimeMillis();

        restoreIpAddresses(str);
        long aft1 = System.currentTimeMillis();
        System.out.println("原始ip为："+result);
        System.out.println("原始ip可能数量："+result.size());
        System.out.println("method 1 takes: " + (aft1 - pre1) + " ms!");

    }


    /**
     * 回溯，为了加快速度可以提前计算下是否可行
     * */

    public static void find(int part, int value, String tmp, int index){
        if(part >3 || index>=digits.length){
            if(part ==  3 && index==digits.length){
                result.add(tmp);
            }
            return ;
        }
        if(value*10+digits[index]<=255  && value!=0){
            find(part,value*10+digits[index],tmp+(int)digits[index],index+1);
        }
        find(part+1,digits[index],tmp+"."+(int)digits[index],index+1);

    }
    public static List<String> restoreIpAddresses(String s) {
        result = new ArrayList<String>();
        if(s.length()<1)
            return result;
        digits=s.toCharArray();
        for(int i=0;i<s.length();i++)
            digits[i]-='0';
        find(0,digits[0],""+(int)(digits[0]),1);
        return result;
    }
}

/*网上答案 */
/*
import java.util.*;
*/
/*有效ip*//*

public class Main3 {
    public int  numOfIP(String s) {
        List<String> result = new ArrayList<String>();
        List<String> list = new ArrayList<String>();

        if(s.length() <=3 || s.length() > 12)
            return result.size();
        find(result, list, s , 0);
        return result.size();
    }

    public void find(List<String> result, List<String> list, String s, int begin){
        if(list.size() == 4){
            if(begin != s.length())
                return;

            StringBuffer sb = new StringBuffer();
            for(String tmp: list){
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }

        for(int i=begin; i<s.length() && i < begin+3; i++){
            String tmp = s.substring(begin, i+1);
            if(isvalid(tmp)){
                list.add(tmp);
                find(result, list, s, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isvalid(String s){
        if(s.charAt(0) == '0')
            return s.equals("0");
        int number = Integer.valueOf(s);
        return number >= 0 && number <= 255;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        Main3 m=new Main3();
        System.out.println(m.numOfIP(str));

    }

}
*/

