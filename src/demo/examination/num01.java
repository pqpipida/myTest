package demo.examination;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dd  on  2018/9/9.
 * 头条01 自己的答案
 */
public class num01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        String str = null;
        System.out.println("请输入您想输入的字符串：");
        str = s.next();
        long pre1 = System.currentTimeMillis();

            cal(str);
            long aft1 = System.currentTimeMillis();
        //System.out.println(max);
            System.out.println("method 1 takes: " + (aft1 - pre1) + " ms!");
        }


    public static void  cal(String s) {
        int[] hash = new int[500];
        int max = 0;
        int i = 0, j = 0;
        //String b = String.valueOf(s);
        while (i < s.length() && j <s.length()) {
            if (hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)] = 1;
                j++;
                max = (j - i) > max ? (j - i) : max;

            } else {
                hash[s.charAt(i)] = 0;
                i++;
            }
        }
        System.out.println("最长字符串为" + max);

    }

}
 /*网上答案*/
/*import java.util.Scanner;

public class num01 {
	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		String str=scan.next();

		int[] v = new int[10000];
	    int j = 0;
	    int i = 0;
	    int res = 0;
	    for (i = 0; i < str.length(); i++) {
	        while (j < str.length() && v[str.charAt(j)]==0) {
	            v[str.charAt(j)] = 1;
	            res = Math.max(res, j-i + 1);
	            j ++;
	        }
	        v[str.charAt(i)] = 0;
	    }
		System.out.println(res);
	}

}*/


