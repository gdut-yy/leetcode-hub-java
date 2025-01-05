public class Solution2086 {
    public int minimumBuckets(String hamsters) {
        // 没有办法收集所有房屋的雨水
        if (hamsters.equals("H") || hamsters.startsWith("HH") || hamsters.endsWith("HH") || hamsters.contains("HHH")) {
            return -1;
        }
        // 统计 "H.H" 次数
        int cntHPointH = 0;
        // 固定大小滑动窗口
        int left = 0;
        while (left + 2 < hamsters.length()) {
            if (hamsters.charAt(left) == 'H' && hamsters.charAt(left + 1) == '.' && hamsters.charAt(left + 2) == 'H') {
                cntHPointH++;
                left += 3;
            } else {
                left++;
            }
        }
        // 统计 'H' 次数
        int cntH = 0;
        for (char ch : hamsters.toCharArray()) {
            if (ch == 'H') {
                cntH++;
            }
        }
        return cntH - cntHPointH;
    }
}
/*
2086. 喂食仓鼠的最小食物桶数
https://leetcode.cn/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/description/

第 66 场双周赛 T2。

给你一个下标从 0 开始的字符串 hamsters ，其中 hamsters[i]  要么是：
- 'H' 表示有一个仓鼠在下标 i ，或者
- '.' 表示下标 i 是空的。
你将要在空的位置上添加一定数量的食物桶来喂养仓鼠。如果仓鼠的左边或右边至少有一个食物桶，就可以喂食它。更正式地说，如果你在位置 i - 1 或者 i + 1 放置一个食物桶，就可以喂养位置为 i 处的仓鼠。
在 空的位置 放置食物桶以喂养所有仓鼠的前提下，请你返回需要的 最少 食物桶数。如果无解请返回 -1 。
提示：
1 <= hamsters.length <= 10^5
hamsters[i] 要么是 'H' ，要么是 '.' 。

容易枚举出所有无解情况，直接返回 -1。
在有解情况下，假设有 n 个 'H'，最多需要 n 个水桶。
若存在 "H.H"，则可以节约 1 个水桶。
 */