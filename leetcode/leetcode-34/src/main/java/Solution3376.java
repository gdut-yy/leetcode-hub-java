import java.util.List;

public class Solution3376 {
    public int findMinimumTime(List<Integer> strength, int K) {
        int n = strength.size();
        int[] strengths = strength.stream().mapToInt(Integer::intValue).toArray();
        int[] permute = new int[n];
        for (int i = 0; i < n; i++) permute[i] = i;

        int ans = Integer.MAX_VALUE;
        int maxRound = 1;
        for (int i = 2; i <= n; i++) maxRound *= i;
        for (int i = 0; i < maxRound; i++) {
            ans = Math.min(ans, getAns(strengths, K, permute));
            nextPermutation(permute);
        }
        return ans;
    }

    int getAns(int[] strengths, int k, int[] permute) {
        int n = strengths.length;
        int res = 0;
        int x = 1;
        for (int i = 0; i < n; i++) {
            int stre = strengths[permute[i]];
            // k*b >= stre
            res += (stre + x - 1) / x;
            x += k;
        }
        return res;
    }

    private void nextPermutation(int[] a) {
        int n = a.length;
        int i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return;
        int j = n - 1;
        while (j >= 0 && a[i] >= a[j]) j--;
        swap(a, i, j);
        reverse(a, i + 1);
    }

    private void swap(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

    private void reverse(int[] a, int st) {
        for (int l = st, r = a.length - 1; l < r; l++, r--) {
            swap(a, l, r);
        }
    }
}
/*
3376. 破解锁的最少时间 I
https://leetcode.cn/problems/minimum-time-to-break-locks-i/description/

第 145 场双周赛 T2。

Bob 被困在了一个地窖里，他需要破解 n 个锁才能逃出地窖，每一个锁都需要一定的 能量 才能打开。每一个锁需要的能量存放在一个数组 strength 里，其中 strength[i] 表示打开第 i 个锁需要的能量。
Bob 有一把剑，它具备以下的特征：
- 一开始剑的能量为 0 。
- 剑的能量增加因子 X 一开始的值为 1 。
- 每分钟，剑的能量都会增加当前的 X 值。
- 打开第 i 把锁，剑的能量需要到达 至少 strength[i] 。
- 打开一把锁以后，剑的能量会变回 0 ，X 的值会增加一个给定的值 K 。
你的任务是打开所有 n 把锁并逃出地窖，请你求出需要的 最少 分钟数。
请你返回 Bob 打开所有 n 把锁需要的 最少 时间。
提示：
n == strength.length
1 <= n <= 8
1 <= K <= 10
1 <= strength[i] <= 10^6
 */