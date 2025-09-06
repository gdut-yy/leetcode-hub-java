import java.util.HashMap;
import java.util.Map;

public class Solution3663 {
    public int getLeastFrequentDigit(int n) {
        Map<Integer, Integer> cnt = new HashMap<>();
        while (n > 0) {
            int d = n % 10;
            cnt.merge(d, 1, Integer::sum);
            n /= 10;
        }

        int mn = Integer.MAX_VALUE;
        int ans = 0;
        for (int x = 0; x <= 9; x++) {
            if (!cnt.containsKey(x)) continue;
            Integer c = cnt.get(x);
            if (c < mn) {
                ans = x;
                mn = c;
            }
        }
        return ans;
    }
}
/*
3663. 出现频率最低的数字
https://leetcode.cn/problems/find-the-least-frequent-digit/description/

第 164 场双周赛 T1。

给你一个整数 n，找出在其十进制表示中出现频率 最低 的数字。如果多个数字的出现频率相同，则选择 最小 的那个数字。
以整数形式返回所选的数字。
数字 x 的出现频率是指它在 n 的十进制表示中的出现次数。
提示:
1 <= n <= 2^31 - 1

模拟。
时间复杂度 O(logn)。
 */