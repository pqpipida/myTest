package demo.java;

import java.util.*;

/**
 * Created by dd  on  2018/9/10.
 * [编程题] 最大映射
 * 时间限制：1秒
 * 空间限制：32768K
 * 有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。现在你将每个字符映射为一个 0-9 的数字，不同字符映射为不同的数字。
 * 这样每个字符串就可以看做一个整数，唯一的要求是这些整数必须是正整数且它们的字符串不能有前导零。现在问你怎样映射字符才
 * 能使得这些字符串表示的整数之和最大？
 *
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n ， 接下来有 n 行，每行一个长度不超过 12 且仅包含大写字母
 * A-J 的字符串。 n 不大于 50，且至少存在一个字符不是任何字符串的首字母。
 *
 * 输出描述:
 * 输出一个数，表示最大和是多少。
 *
 * 输入例子1:
 * 2
 * ABC
 * BCA
 *
 * 输出例子1:
 * 1875
 *
 * 解题思路：利用权重来实现
 * 根据测试用例：
 * ABC 各位上的权重为A:100; B:10; C:1
 * BCA 各位上的权重为B:100; C:10; A:1
 * 字母A的总权重100+1 = 101；字母B的总权重10+100=110；字母C的总权重为1+10=11
 * 然后按照权重大小排序：B:110-->9,A:101-->8,C:11-->7,.....，即A-->8,B-->9,C-->7,
 * 权重*映射值即为所求答案
 *
 */
public class Test03 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            String[] strs = new String[n];
            for (int i = 0; i <n; i++){

                strs[i] = scanner.next();
            }

            // long pre1 = System.currentTimeMillis();

            System.out.println(getMax(strs,n));

            // long aft1 = System.currentTimeMillis();
            // System.out.println("method 1 takes: "+(aft1-pre1)+" ms!");
        }
        scanner.close();
    }

    public static long getMax(String[] strs, int n) {

        HashMap<Character, Long> map = new HashMap<>();

        HashSet<Character> headSet = new HashSet<>();


        for(int i = 0; i < n; i++){

            int len = strs[i].length();

            headSet.add(strs[i].charAt(0));

            long count = 1;

            for(int j = len-1; j >= 0; j--){

                char c = strs[i].charAt(j);

                if(map.containsKey(c))

                    map.put(c, map.get(c)+ count);

                else

                    map.put(c, count);

                count *= 10;

            }

        }

        ArrayList<Map.Entry<Character, Long>> list = new ArrayList<>(map.entrySet());
        //还需要了解
        Collections.sort(list, new Comparator<Map.Entry<Character, Long>>() {

            @Override

            public int compare(Map.Entry<Character, Long> o1, Map.Entry<Character, Long> o2) {

                //return o1.getValue() > o2.getValue() ? -1 : 1;

                return -o1.getValue().compareTo(o2.getValue());

            }

        });

        if(list.size() == 10){

            for(int i = 9; i >=0; i--){

                if(!headSet.contains(list.get(i).getKey())){

                    list.remove(i);

                    break;

                }

            }

        }

        long res = 0;

        int i = 0;

        int k = 9;

        while(i < list.size()){

            res += list.get(i++).getValue()*(k--);

        }

        return res;

    }


}
