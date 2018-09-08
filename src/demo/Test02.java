
package demo;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by dd  on  2018/9/8.
 * 时间限制：1秒
 *空间限制：32768k
 *魔法权值
 * 给出n个字符串，对于每个n个排列p，安排列给出的顺序（p[0],p[1]....p[n-1])
 * 依次连接这n个字符串都能得到一个长度为这些字符串长度之和的字符串，所以按照
 * 这个方法一共可以生成n！个字符串。一个字符串的权值等于把这个字符串循环左移
 * i次后得到的字符串仍和原字符串全等的数量，i的取值为[1,字符串长度]。求这些
 * 字符串最后生成的n！个字符串中权值为k的有多少个。
 * 注：定义把一个串循环左移1次等价于把这个串的第一个字符移动到最后一个字符的后面。
 *
 * 输入描述：每组测试用例仅包含一组数据，每组数据第一行为两个正整数n，K，n的
 * 大小不超过8，K不超过200.接下来有n行，每行一个长度不超过20且仅包含大写字母的字符串。
 *
 * 输出描述：输出一个整数代表权值为K的字符串数量。
 *
 * 输入例子1：
 * 3 2
 * AB
 * RAAB
 * RA
 * 输出例子1：
 * 3
 *
 * 思路：字符串全排列，得到每个字符串的权值，与k比较，count++
 */
public class Test02 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int K = scanner.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = scanner.next();
            }

            long pre1 = System.currentTimeMillis();



            getNumWeightK(n, K, strs);
            long aft1 = System.currentTimeMillis();

            System.out.println("method 1 takes: "+(aft1-pre1)+" ms!");
        }
        scanner.close();
    }

    public static void getNumWeightK(int n, int K, String[] strs) {
        int count = 0;
        ArrayList<String> strings = new ArrayList<String>();
        permutation(strings, strs, 0);
        for (int i = 0; i < strings.size(); i++) {
            int weightTemp = getWeight(strings.get(i));
            if (weightTemp == K) {
                count++;
            }
        }
        System.out.println(count);
    }

   /* // 循环移位得到的权重 超时
   public static int getWeight(String s) {
        int weight = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char temp = cs[0];
            for (int j = 0; j < s.length() - 1; j++) {
                cs[j] = cs[j + 1];
            }
            cs[s.length() - 1] = temp;
            String rotateS = new String(cs);
            if (rotateS.equals(s)) {
                weight++;
            }
        }
        return weight;
    }*/
    //求一个字符的权重
    public static int getWeight(String s) {
        int weight = 0;
        int len = s.length();
        for(int i=0;i<s.length();i++){
            if(s.substring(0, i).equals(s.substring(len - i, len)) && s.substring(0, len-i).equals(s.substring(i, len))){
                weight++;
            }
        }
        return weight;
    }

    // 全排列
    public static void permutation(ArrayList<String> strings, String[] strs, int k) {
        if (k == strs.length) { // 去除重复排列
            String temp = "";  //一开始用StringBuffer类来保存，就超时了。所以尽量不要用StringBuffer
            for (int i = 0; i < strs.length; i++) {
                temp += strs[i];
            }
            strings.add(temp);// 不需要去除重复的排列
        }
        else{
            for (int i = k; i < strs.length; i++) {
                swap(strs, i, k);
                permutation(strings, strs, k + 1);
                swap(strs, i, k);
            }
        }
    }

    public static void swap(String[] strs, int i, int j) {
        if (i != j) {
            String t = strs[i];
            strs[i] = strs[j];
            strs[j] = t;
        }
    }
}
