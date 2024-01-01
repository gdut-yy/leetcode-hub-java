package p864;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF864D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] cnt = new int[n + 1];
        for (int v : a) {
            cnt[v]++;
        }
        int ans = 0;
        boolean[] skip = new boolean[n + 1];
        int cur = 1;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            if (cnt[v] == 1) {
                continue;
            }
            while (cnt[cur] > 0) {
                cur++;
            }
            // 跳过一次（相同数字改后面的）
            if (cur > v && !skip[v]) {
                skip[v] = true;
                continue;
            }
            ans++;
            cnt[v]--;
            a[i] = cur;
            cur++;
        }
        return ans + System.lineSeparator()
                + Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Make a Permutation!
https://codeforces.com/contest/864/problem/D

灵茶の试炼 2023-10-24
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)。
最少要修改多少个元素，使得 a 是一个 1~n 的排列？
输出最少修改次数，以及修改后的 a。
如果有多个 a 符合要求，输出字典序最小的 a。

统计 a 中每个数出现了多少次，记到 cnt 数组中。
如果 x 只出现一次，那么不用改。
如果 x 出现多次，那么要改 cnt[x]-1 个数。
遍历 a，如果当前元素只剩下一个，肯定不用改。
如果还有多个。
1. 如果要改成一个比 a[i] 小的数，直接改。
2. 如果要改成一个比 a[i] 大的数：
2.1 如果第一次遇到 a[i]，跳过，改后面的数。
2.2 如果不是第一次遇到，一定要改。
用一个布尔数组 skip 记录跳过的数。
https://codeforces.com/contest/864/submission/228761298
======

input
4
3 2 2 3
output
2
1 2 4 3

input
6
4 5 6 3 2 1
output
0
4 5 6 3 2 1

input
10
6 8 4 6 7 1 6 3 4 5
output
3
2 8 4 6 7 1 9 3 10 5
 */
