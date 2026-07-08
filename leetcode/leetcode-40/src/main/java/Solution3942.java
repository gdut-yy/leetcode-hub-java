import java.util.Arrays;

public class Solution3942 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int pos0 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pos0 = i;
                break;
            }
        }
        int kRot = (n - pos0) % n;
        boolean isRot = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (i + kRot) % n) {
                isRot = false;
                break;
            }
        }
        int kRef = (n - 1 - pos0) % n;
        boolean isRef = true;
        for (int i = 0; i < n; i++) {
            int expected = n - 1 - ((i + kRef) % n);
            if (nums[i] != expected) {
                isRef = false;
                break;
            }
        }
        if (!isRot && !isRef) return -1;

        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], -1);
        }
        dist[0][0] = 0;
        int[] qType = new int[2 * n];
        int[] qK = new int[2 * n];
        int head = 0, tail = 0;
        qType[tail] = 0;
        qK[tail] = 0;
        tail++;

        while (head < tail) {
            int t = qType[head];
            int k = qK[head];
            head++;
            int d = dist[t][k];

            if (t == 0) {
                int nk = (k + 1) % n;
                if (dist[0][nk] == -1) {
                    dist[0][nk] = d + 1;
                    qType[tail] = 0;
                    qK[tail] = nk;
                    tail++;
                }
                if (dist[1][k] == -1) {
                    dist[1][k] = d + 1;
                    qType[tail] = 1;
                    qK[tail] = k;
                    tail++;
                }
            } else {
                int nk = (k - 1 + n) % n;
                if (dist[1][nk] == -1) {
                    dist[1][nk] = d + 1;
                    qType[tail] = 1;
                    qK[tail] = nk;
                    tail++;
                }
                if (dist[0][k] == -1) {
                    dist[0][k] = d + 1;
                    qType[tail] = 0;
                    qK[tail] = k;
                    tail++;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        if (isRot) {
            int targetK = (n - kRot) % n;
            ans = Math.min(ans, dist[0][targetK]);
        }
        if (isRef) {
            ans = Math.min(ans, dist[1][kRef]);
        }
        return ans;
    }
}
/*
3942. 排序排列的最少操作数
https://leetcode.cn/problems/minimum-operations-to-sort-a-permutation/description/

第 503 场周赛 T3。

给你一个长度为 n 的整数数组 nums，其中 nums 是区间 [0..n - 1] 中所有数字的一个排列。
你 只能 执行以下操作：
反转 整个数组。
- 左旋一位：将第一个元素移动到数组末尾，其余元素整体向左移动一位。
- 返回将数组按 递增 顺序排序所需的 最少 操作次数。如果仅使用给定操作无法将数组排序，则返回 -1。
排列 是数组中所有元素的一种重新排列。
提示：
1 <= n == nums.length <= 10^5
0 <= nums[i] <= n - 1
nums 是从 0 到 n - 1 的整数排列。

分类讨论。
时间复杂度 O(n)。
 */