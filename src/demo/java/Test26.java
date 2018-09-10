package demo.java;

/**
 * Created by dd  on  2018/9/11.
 * [问答题]
 * 题目描述
 * 以下函数用于将一颗二叉搜索树转换成一个有序的双向链表。要求不能创建任何新的节点，只能调整树种节点指针的指向。
 * 如输入下图中左边的二叉搜索树，则输出转换后的排序双向链表：
 *       10
 *     /      \
 *    6      14
 *   /  \      /  \
 * 4    8    12    16
 * 转换成：
 *  4 <=> 6 <=> 8 <=> 10 <=> 12  <=> 14 <=> 16
 *
 * 请指出程序代码中错误的地方（问题不止一处，请尽量找出所有你认为错误的地方）：
 *
 * 1  #include <stack>
 * 2  using namespace std;
 * 3
 * 4  struct TreeNode {
 * 5        int val;
 * 6        TreeNode *left, *right;
 * 7  };
 * 8
 * 9  TreeNode* Convert(TreeNode* root){
 * 10         if (root == NULL)
 * 11             return root;
 * 12
 * 13         TreeNode* listHead = NULL;
 * 14         TreeNode* listLastNode = NULL;
 * 15
 * 16         stack<TreeNode*> s;
 * 17         while(root){
 * 18             while(root){
 * 19                 root=root->left;
 * 20                 s.push(root);
 * 21             }
 * 22             root=s.top();
 * 23             s.pop();
 * 24             if (listHead == NULL){
 * 25                 listHead = root;
 * 26             }else{
 * 27                 listLastNode->right = root;
 * 28             }
 * 29             listLastNode = root;
 * 30             root= root->right;
 * 31         }
 * 32         return listHead;
 * 33 }
 */
public class Test26 {
}
