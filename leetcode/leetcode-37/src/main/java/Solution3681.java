public class Solution3681 {
    public int maxXorSubsequences(int[] nums) {
        int[] base = new int[32];
        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                if (((num >> i) & 1) == 1) {
                    if (base[i] == 0) {
                        base[i] = num;
                        break;
                    } else {
                        num ^= base[i];
                    }
                }
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((res ^ base[i]) > res) {
                res ^= base[i];
            }
        }
        return res;
    }
}
/*
3681. 子序列最大 XOR 值
https://leetcode.cn/problems/maximum-xor-of-subsequences/description/

第 165 场双周赛 T4。

给你一个长度为 n 的整数数组 nums，其中每个元素都是非负整数。
选择 两个 子序列 nums（它们可以为空并且 允许重叠），每个子序列保留原始元素的顺序，并且定义：
- X 是第一个子序列中所有元素的按位 XOR。
- Y 是第二个子序列中所有元素的按位 XOR。
返回 最大 的 X XOR Y 值。
子序列 是通过删除某些或不删除任何元素，而不改变剩余元素的顺序，从另一个数组派生出的数组。
注意：一个 空 子序列的 XOR 为 0。
提示：
2 <= nums.length <= 10^5
0 <= nums[i] <= 10^9

方法思路
1.问题分析：我们需要选择两个子序列，使得它们的异或值X和Y的异或结果最大。通过观察，可以发现最终结果等价于从数组中选择一个子集，使得该子集的异或和最大。
2.关键 insight：无论元素如何分配到两个子序列中，最终结果总是等于所选子集的异或和。因此，问题转化为求数组的最大异或子集。
3.算法选择：使用线性基数据结构来高效计算最大异或子集。线性基能够处理大量数据并快速找到最大异或值。
4.复杂度分析：线性基的构建和查询过程的时间复杂度均为O(n * 32)，其中n是数组长度，32是数字的位数上限。这使得算法能够高效处理大规模数据。
https://chat.deepseek.com/a/chat/s/9a482b5d-a8ae-446b-bf8b-5e291acede0e
 */