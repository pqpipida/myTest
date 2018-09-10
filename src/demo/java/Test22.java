package demo.java;

/**
 * Created by dd  on  2018/9/11.
 * [问答题]
 * 题目描述
 * 以下函数用于找到整数矩阵matrix中，元素之和最大的n行m列的子矩阵的元素之和。请指出程序代码中错误的地方（问题不止一处，请尽量找出所有你认为错误的地方），并在不新增代码行的情况下将问题修复。
 *  1 int maxSubmatrixSum(std::vector<std::vector<int>> matrix,
 *  2                     int n, int m) {
 *  3   int base_sum;
 *  4   for (int i = 0; i < n; i++){
 *  5     for (int j = 0; j < m; j++){
 *  6       base_sum += matrix[i][j];
 *  7     }
 *  8   }
 *  9   int result = 0;
 * 10   for (int i = 0; i + n < matrix.size(); i++) {
 * 11     if(i  > 0){
 * 12       for (int y = 0; y < m; y++){
 * 13         base_sum += matrix[i + n][y] - matrix[i - 1][y];
 * 14       }
 * 15     }
 * 16     int real_sum = base_sum;
 * 17     if (real_sum  > result) {
 * 18       result = real_sum;
 * 19     }
 * 20     for (int j = 0; j + m < matrix.size(); j++) {
 * 21       for (int x = 0; x < n; x++) {
 * 22         real_sum += matrix[x][j + m] - matrix[x][j - 1];
 * 23       }
 * 24       if (real_sum > result) {
 * 25         result = real_sum;
 * 26       }
 * 27     }
 * 28   }
 * 29   return result;
 * 30 }
 */
public class Test22 {
}
