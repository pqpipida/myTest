package demo.java;

/**
 * Created by dd  on  2018/9/11.
 * 题目描述
 * 小T最近迷上了一款跳板游戏
 * 已知空中有N个高度互不相同的跳板，小T刚开始在高度为0的地方，每次跳跃可以选择与自己当前高度绝对值差小于等于H的挑板，跳跃过后到达以跳板为轴的镜像位置，问小T在最多条K次的情况下能跳多高？（任意时刻，高度不能为负）
 * 输入描述
 * 第一行三个整数 N,K,H
 * 以下N行，每行一个整数Ti，表示第i个跳板离地的高度
 * 输出描述
 * 一个整数，表示最高能跳到的高度
 * 输入样例
 *         输入
 *         3 3 2
 *         1
 *         3
 *         6
 *         输出
 *         8
 *         说明
 *         小T初始在高度0的地方
 *         第一次跳跃只能选择高度为1的跳板，结束后到达高度为2的地方，计算方式：
 *         高度1=初始高度+（跳板高度-初始高度）*2=0+（1-0）*2=2
 *         第二次跳跃只能选择高度为3的跳板，结束后达到高度为4的地方，计算方式：
 *         高度2=高度1+（跳板2高度-高度1）*2=2+（3-2）*2=4
 *         第二次跳跃只能选择高度为6的跳板，结束后达到高度为8的地方，计算方式：
 *         高度3=高度2+（跳板3高度-高度2）*2=4+（6-4）*2=8
 */
public class Test37 {

}