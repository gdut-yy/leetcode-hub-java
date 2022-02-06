public class Solution6003 {
    public int minimumTime(String s) {
        int len = s.length();

        // dp
        int[] dpLeft1 = new int[len];
        int[] dpLeft2 = new int[len];
        int[] dpRight1 = new int[len];
        int[] dpRight2 = new int[len];

        // 初始状态
        if (s.charAt(0) == '1') {
            dpLeft1[0] = 1;
            dpLeft2[0] = 1;
        }
        if (s.charAt(len - 1) == '1') {
            dpRight1[len - 1] = 1;
            dpRight2[len - 1] = 1;
        }

        // 从左往右
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '1') {
                dpLeft1[i] = i + 1;
                dpLeft2[i] = Math.min(dpLeft2[i - 1] + 2, dpLeft1[i]);
            } else {
                dpLeft1[i] = dpLeft1[i - 1];
                dpLeft2[i] = dpLeft2[i - 1];
            }
        }

        // 右往左
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                dpRight1[i] = len - i;
                dpRight2[i] = Math.min(dpRight2[i + 1] + 2, dpRight1[i]);
            } else {
                dpRight1[i] = dpRight1[i + 1];
                dpRight2[i] = dpRight2[i + 1];
            }
        }

        // 上界为字符串长度
        int min = len;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, dpLeft2[i] + dpRight2[i]);
        }
        return min;
    }
}
/*
6003. 移除所有载有违禁货物车厢所需的最少时间
https://leetcode-cn.com/problems/minimum-time-to-remove-all-cars-containing-illegal-goods/

第 279 场周赛 T4。

给你一个下标从 0 开始的二进制字符串 s ，表示一个列车车厢序列。s[i] = '0' 表示第 i 节车厢 不 含违禁货物，而 s[i] = '1' 表示第 i 节车厢含违禁货物。
作为列车长，你需要清理掉所有载有违禁货物的车厢。你可以不限次数执行下述三种操作中的任意一个：
1.从列车 左 端移除一节车厢（即移除 s[0]），用去 1 单位时间。
2.从列车 右 端移除一节车厢（即移除 s[s.length - 1]），用去 1 单位时间。
3.从列车车厢序列的 任意位置 移除一节车厢，用去 2 单位时间。
返回移除所有载有违禁货物车厢所需要的 最少 单位时间数。
注意，空的列车车厢序列视为没有车厢含违禁货物。

简单分析一下，因为可能存在 0010011100 的情形，没法直接贪心，单向动态规划不满足无后效性要求，尝试双向动态规划。
dpLeft1[i] 表示均从列车 左 端移除一节车厢所花费时间
dpRight1[i] 表示均从列车 右 端移除一节车厢所花费时间
dpLeft2[i] 表示均从列车 左 端移除一节车厢所花费最小时间
dpRight2[i] 表示均从列车 右 端移除一节车厢所花费最小时间
答案即为每对 dpLeft2[i] + dpRight2[i] 的最小值
 */