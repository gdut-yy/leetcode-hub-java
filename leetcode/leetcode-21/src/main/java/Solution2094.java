import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2094 {
    // O(n + k*10^k)
    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) {
            cnt[d]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 100; i <= 999; i += 2) {
            int d1 = i / 100 % 10;
            int d2 = i / 10 % 10;
            int d3 = i % 10;
            cnt[d1]--;
            cnt[d2]--;
            cnt[d3]--;
            if (cnt[d1] >= 0 && cnt[d2] >= 0 && cnt[d3] >= 0) {
                ans.add(i);
            }
            cnt[d1]++;
            cnt[d2]++;
            cnt[d3]++;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
2094. 找出 3 位偶数
https://leetcode.cn/problems/finding-3-digit-even-numbers/

第 270 场周赛 T1。

给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
你需要找出 所有 满足下述条件且 互不相同 的整数：
- 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
- 该整数不含 前导零
- 该整数是一个 偶数
例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
提示：
3 <= digits.length <= 100
0 <= digits[i] <= 9

考虑暴力。
三个for时间复杂度 O(n^3)，3的全排列为6，最坏情况数量级为 6 * 10^6
 */