public class Solution2277 {
}
/*
$2277. 树中最接近路径的节点
https://leetcode.cn/problems/closest-node-to-path-in-tree/

给定一个正整数 n，表示树中的节点数，编号从 0 到 n - 1 (含边界)。还给定一个长度为 n - 1 的二维整数数组 edges，
其中 edges[i] = [node1i, node2i] 表示有一条 双向 边连接树中的 node1i 和 node2i。
给定一个长度为 m ，下标从 0 开始 的整数数组 query，其中 query[i] = [starti, endi, nodei] 意味着对于第 i 个查询，
您的任务是从 starti 到 endi 的路径上找到 最接近 nodei 的节点。
返回长度为 m 的整数数组 answer，其中 answer[i] 是第 i 个查询的答案。
提示:
1 <= n <= 1000
edges.length == n - 1
edges[i].length == 2
0 <= node1i, node2i <= n - 1
node1i != node2i
1 <= query.length <= 1000
query[i].length == 3
0 <= starti, endi, nodei <= n - 1
这个图是一个树。

LCA（最近公共祖先）+ 分类讨论 https://leetcode.cn/problems/closest-node-to-path-in-tree/solution/by-megurine-2377/
 */