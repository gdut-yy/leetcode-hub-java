public class Solution2005 {
}
/*
$2005. 斐波那契树的移除子树游戏
https://leetcode.cn/problems/subtree-removal-game-with-fibonacci-tree/

斐波那契树是一种按这种规则函数 order(n) 创建的二叉树：
- order(0) 是空树。
- order(1) 是一棵只有一个节点的二叉树。
- order(n) 是一棵根节点的左子树为 order(n - 2) 、右子树为 order(n - 1) 的二叉树。
Alice 和 Bob 在玩一种关于斐波那契树的游戏，由 Alice 先手。在每个回合中，每个玩家选择一个节点，然后移除该节点及其子树。只能删除根节点 root 的玩家输掉这场游戏。
给定一个整数 n，假定两名玩家都按最优策略进行游戏，若 Alice 赢得这场游戏，返回 true 。若 Bob 赢得这场游戏，返回 false 。
一棵二叉树的子树 tree 是由 tree 中某个节点及其所有后代节点组成的树。树 tree 也可当作自身的子树。
提示：
1 <= n <= 100

Sprague-Grundy & Colon Principle
博弈论SG函数 T2
https://leetcode.cn/problems/subtree-removal-game-with-fibonacci-tree/solution/bo-yi-lun-sghan-shu-t2-by-candyore-s7id/
 */