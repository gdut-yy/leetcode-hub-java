import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3377 {
    static final int MAX_N = (int) 1e4;
    static boolean[] np;

    static {
        np = new boolean[MAX_N + 1];
        np[1] = true;
        for (int i = 2; i * i <= MAX_N; i++) {
            if (!np[i]) {
                for (int j = i * i; j <= MAX_N; j += i) {
                    np[j] = true;
                }
            }
        }
    }

    public int minOperations(int n, int m) {
        if (!np[n] || !np[m]) {
            return -1;
        }

        int lenN = Integer.toString(n).length();
        int[] dis = new int[(int) Math.pow(10, lenN)];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[n] = n;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{n, n});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int disX = top[0];
            int x = top[1];
            if (x == m) {
                return disX;
            }
            if (disX > dis[x]) {
                continue;
            }
            int pow10 = 1;
            for (int v = x; v > 0; v /= 10) {
                int d = v % 10;
                if (d > 0) { // 减少
                    int y = x - pow10;
                    int newD = disX + y;
                    if (np[y] && newD < dis[y]) {
                        dis[y] = newD;
                        pq.add(new int[]{newD, y});
                    }
                }
                if (d < 9) { // 增加
                    int y = x + pow10;
                    int newD = disX + y;
                    if (np[y] && newD < dis[y]) {
                        dis[y] = newD;
                        pq.add(new int[]{newD, y});
                    }
                }
                pow10 *= 10;
            }
        }
        return -1;
    }
}
/*
3377. 使两个整数相等的数位操作
https://leetcode.cn/problems/digit-operations-to-make-two-integers-equal/description/

第 145 场双周赛 T3。

给你两个整数 n 和 m ，两个整数有 相同的 数位数目。
你可以执行以下操作 任意 次：
- 从 n 中选择 任意一个 不是 9 的数位，并将它 增加 1 。
- 从 n 中选择 任意一个 不是 0 的数位，并将它 减少 1 。
任意时刻，整数 n 都不能是一个 质数，意味着一开始以及每次操作以后 n 都不能是质数。
进行一系列操作的代价为 n 在变化过程中 所有 值之和。
请你返回将 n 变为 m 需要的 最小 代价，如果无法将 n 变为 m ，请你返回 -1 。
提示：
1 <= n, m < 10^4
n 和 m 包含的数位数目相同。

rating 2070 (clist.by)
 */