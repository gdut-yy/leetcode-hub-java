import java.util.HashSet;
import java.util.Set;

public class Solution3694 {
    public int distinctPoints(String s, int k) {
        final int base = (int) (2e5 + 1);
        int n = s.length();
        long x = 0, y = 0;
        Set<Long> set = new HashSet<>();
        set.add(0L);
        for (int i = k; i < n; i++) {
            int[] add = getPoint(s.charAt(i));
            int[] del = getPoint(s.charAt(i - k));
            x += add[0] - del[0];
            y += add[1] - del[1];
            set.add(x * base + y);
        }
        return set.size();
    }

    private int[] getPoint(char c) {
        if (c == 'R') return new int[]{1, 0};
        else if (c == 'L') return new int[]{-1, 0};
        else if (c == 'U') return new int[]{0, -1};
        return new int[]{0, 1};
    }
}
/*
3694. 删除子字符串后不同的终点
https://leetcode.cn/problems/distinct-points-reachable-after-substring-removal/description/

第 166 场双周赛 T3。

给你一个由字符 'U'、'D'、'L' 和 'R' 组成的字符串 s，表示在无限的二维笛卡尔网格上的移动。
'U': 从 (x, y) 移动到 (x, y + 1)。
'D': 从 (x, y) 移动到 (x, y - 1)。
'L': 从 (x, y) 移动到 (x - 1, y)。
'R': 从 (x, y) 移动到 (x + 1, y)。
你还得到了一个正整数 k。
你 必须 选择并移除 恰好一个 长度为 k 的连续子字符串 s。然后，从坐标 (0, 0) 开始，按顺序执行剩余的移动。
返回可到达的 不同 最终坐标的数量。
提示:
1 <= s.length <= 10^5
s 只包含 'U'、'D'、'L' 和 'R'。
1 <= k <= s.length

固定长度的滑动窗口。
时间复杂度 O(n-k)。
 */