package demo;
/* Created by dd  on  2018/9/8.
* 时间限制：1秒
*空间限制：32768k
* 给定x,k,求满足x+y=x|y的第k小的正整数y。|是二进制的或(or)运算,例如3|5=7。
* 比如当x=5，k=1时返回2，因为5+1=6，不等于5|1=5，而5+2=7等于5|2=7。
* 输入描述：每组测试用例仅包含一组数据，每组数据为两个正整数x，k。满足0<x,x<=2000000000。
* 输出描述：输出一个数y。
* 输入例子：5  1
* 输出例子：2
* 下列代码使用了三个方法
* */
import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;


public class Test01 {

    static Test01 main = new Test01();

    class Node{

        public int pos; //用于存数的位置

        public int value; //该位置的值

        public boolean flag = false; //该位置是否已经设置过

        public Node(){

        }

        public Node(int pos, int value){

            this.pos = pos;

            this.value = value;

        }

        public int getPos() {

            return pos;

        }

        public void setPos(int pos) {

            this.pos = pos;

        }

        public int getValue() {

            return value;

        }

        public void setValue(int value) {

            this.value = value;

        }

        public boolean isFlag() {

            return flag;

        }

        public void setFlag(boolean flag) {

            this.flag = flag;

        }





    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()){

            int x  =scan.nextInt();

            int k = scan.nextInt();

            // 爆力方法

            long pre1 = System.currentTimeMillis();

            normCal(x, k);

            long aft1 = System.currentTimeMillis();

            System.out.println("method 1 takes: "+(aft1-pre1)+" ms!");



            // 简便方法 1  （向x的非1位置从右依次填充k的二进制）

            long pre2 = System.currentTimeMillis();

            unNormalCal(x, k);

            long aft2 = System.currentTimeMillis();

            System.out.println("method 2 takes: "+(aft2-pre2)+" ms!");



            // 简便方法 2

            long pre3 = System.currentTimeMillis();

            unNormalCal3(x, k);

            long aft3 = System.currentTimeMillis();

            System.out.println("method 3 takes: "+(aft3-pre3)+" ms!");



        }

    }





    // unNormalCal method（简便方法2，是一位大神想出来的，速度更不用说了）

    private static void unNormalCal3(int x, int k) {

        int y = 0, n =1;

        while(k>0){

            if(x%2!=0){

                //此时x的二进制最右端为1的话，一直使x右移，就是找到x的为0的位置

                while(x%2!=0){

                    n = n*2;  //每移一位，n记录一下变化的值

                    x = x/2;

                }

            }

            //如果k的二进制最右端为1，就使y加上n

            if(k%2!=0)

                y = y+n;



            n  = n*2;

            x = x/2;

            k = k/2; //同时使x,k右移，以便下一步判断

        }

        System.out.println(y);

    }



    // unNormalCal method（简便方法）

    private static void unNormalCal(int x, int k) {

        //2,000,000,000足够用int类型来存，4个字节，共32位，开始置每位为0

        List<Test01.Node> list = new ArrayList<Test01.Node>();

        for(int m =  0;m<32;m++){

            Test01.Node node = main.new Node(m, 0);

            list.add(node);

        }



        //把x转成二进制，并把x的二进制填充到32位中

        char b_x[] = Integer.toBinaryString(x).toCharArray();

        for(int i = 0; i<b_x.length;i++){

            //从32-b_x.length+i依次填充

            Test01.Node node = list.get(32-b_x.length+i);

            node.setValue(Integer.valueOf(String.valueOf(b_x[i])));

            //该位置为1的话，就直接设置为true，不变，因为x+y与x|y的唯一区别就是进位与不进位

            if(node.getValue()==1){

                node.setFlag(true);

            }

        }

        //把k转成二进制，并把k的二进制填充到32位中，依次从右向左非1的单位

        char b_k[] = Integer.toBinaryString(k).toCharArray();

        for(int i = b_k.length-1;i>=0;i--){

            for(int j=list.size()-1;j>=0;j--){

                Test01.Node node = list.get(j);

                if(!node.isFlag()){

                    //如果没有访问过，就设置该位

                    node.setValue(Integer.valueOf(String.valueOf(b_k[i])));

                    node.setFlag(true);

                    break;

                }

            }

        }

        //res_b用来存放4个字节中的所有二进制位

        String res_b = "";

        for(int j= 0;j<list.size();j++){

            res_b = res_b + String.valueOf(list.get(j).getValue());

        }

        //输出结果

        System.out.println((getInteger(res_b)-x));

    }



    // norm method（爆力方法）

    public static void normCal(int x, int k){

        int flag = 0;

        for(int i=1;i<=2000000000;i++){

            if((x+i)==(x|i)){

                flag++;

                if(flag==k){

                    System.out.println(i);

                    break;

                }

            }

        }

    }



    //binary to  integer（把二进制转化为相应的整数）

    public static int getInteger(String s){

        int x = 0;

        char s_arr[] = s.toCharArray();

        for(int i=s_arr.length-1;i>=0;i--){

            x = (int) (x + Integer.valueOf(String.valueOf(s_arr[i]))*Math.pow(2, s_arr.length-1-i));

        }

        return x;

    }



}
