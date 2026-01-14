import java.util.Arrays;

public class Solution3796 {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int[] maxVal = new int[n];
        Arrays.fill(maxVal, Integer.MAX_VALUE);
        for (int[] r : restrictions) {
            maxVal[r[0]] = r[1];
        }

        int[] a = new int[n];
        for (int i = 0; i < diff.length; i++) {
            a[i + 1] = Math.min(a[i] + diff[i], maxVal[i + 1]);
        }
        int ans = a[n - 1];
        for (int i = n - 2; i > 0; i--) {
            a[i] = Math.min(a[i], a[i + 1] + diff[i]);
            ans = Math.max(ans, a[i]);
        }
        return ans;
    }
}
/*
3796. 找到带限制序列的最大值
https://leetcode.cn/problems/find-maximum-value-in-a-constrained-sequence/description/

第 173 场双周赛 T3。

给你一个整数 n，一个二维整数数组 restrictions，以及一个长度为 n - 1 的整数数组 diff。你的任务是构造一个长度为 n 的序列，记为 a[0], a[1], ..., a[n - 1]，使其满足以下条件：
- a[0] 为 0。
- 序列中的所有元素都是 非负整数 。
- 对于每个下标 i (0 <= i <= n - 2)，满足 abs(a[i] - a[i + 1]) <= diff[i]。
- 对于每个 restrictions[i] = [idx, maxVal]，序列中位置 idx 的值不得超过 maxVal（即 a[idx] <= maxVal）。
你的目标是在满足上述所有条件的情况下，构造一个合法的序列并 最大化 该序列中的 最大 值。
返回一个整数，表示最优序列中出现的 最大 值。
提示:
2 <= n <= 10^5
1 <= restrictions.length <= n - 1
restrictions[i].length == 2
restrictions[i] = [idx, maxVal]
1 <= idx < n
1 <= maxVal <= 10^6
diff.length == n - 1
1 <= diff[i] <= 10
restrictions[i][0] 的值是唯一的。

两次扫描，传播约束 https://leetcode.cn/problems/find-maximum-value-in-a-constrained-sequence/solutions/3872153/liang-ci-sao-miao-fa-pythonjavacgo-by-en-p7qc/
 */