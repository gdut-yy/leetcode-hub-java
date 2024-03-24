package c127;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Arc127_d {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static long ans;

    private static String solve() {
        ans = 0;
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            idx.add(i);
        }
        dfs(idx, 17);
        return String.valueOf(ans);
    }

    static long f(int[] a, List<Integer> p, List<Integer> q) {
        if (p == null || q == null) {
            return 0;
        }
        long res = 0;
        for (int j = 0; j < 18; j++) {
            long p1 = 0, q1 = 0;
            for (Integer i : p) {
                p1 += a[i] >> j & 1;
            }
            for (Integer i : q) {
                q1 += a[i] >> j & 1;
            }
            res += (p1 * (q.size() - q1) + (p.size() - p1) * q1) << j;
        }
        return res;
    }

    static void dfs(List<Integer> idx, int j) {
        if (idx.size() <= 1) return;
        if (j < 0) {
            ans += f(a, idx, idx) / 2;
            return;
        }
        List<Integer>[] p = new ArrayList[4];
        Arrays.setAll(p, e -> new ArrayList<>());
        for (Integer i : idx) {
            int m = (a[i] >> j & 1) << 1 | (b[i] >> j & 1);
            p[m].add(i);
        }
        ans += f(a, p[0], p[1]);
        ans += f(a, p[2], p[3]);
        ans += f(b, p[0], p[2]);
        ans += f(b, p[1], p[3]);

        List<Integer> p03 = new ArrayList<>(p[0]);
        p03.addAll(p[3]);
        dfs(p03, j - 1);

        List<Integer> p12 = new ArrayList<>(p[1]);
        p12.addAll(p[2]);
        dfs(p12, j - 1);
    }
}
/*
D - Sum of Min of Xor
https://atcoder.jp/contests/arc127/tasks/arc127_d

灵茶の试炼 2023-10-20
题目大意：
输入 n(1≤n≤250000) 和两个长为 n 的数组 a b，元素范围 [0,2^18)。
定义 f(i,j) = min(a[i] ⊕ a[j], b[i] ⊕ b[j])，其中 ⊕ 表示异或。
输出所有 f(i,j) 的和，其中 i<j。
相关推荐：《灵茶八题》https://www.luogu.com.cn/blog/endlesscheng/post-ling-cha-ba-ti-ti-mu-lie-biao

既然是取 min，那么从高位往低位看，找到第一个异或不同的比特位。
例如在某个比特位上 a[i] b[i] a[j] b[j] 分别为 0 0 0 1（或者 0 1 0 0），那么后面就不用比了，a[i] ⊕ a[j] 更小，把 a[i] ⊕ a[j] 的贡献加到答案中。
怎么算贡献？对于这个比特位，把满足「a[i]=0 且 b[i]=0」的 a[i] 分到一组（记作 P），把满足「a[i]=0 且 b[i]=1」的 a[i] 分到另一组（记作 Q）。
枚举 k=0~17，那么 ∑((P 中第 k 个比特位是 1 的元素个数) * (Q 中第 k 个比特位是 0 的元素个数) + (P 中第 k 个比特位是 0 的元素个数) * (Q 中第 k 个比特位是 1 的元素个数)) * 2^k 就是贡献。另见 《灵茶八题》
一般地，根据【a[i] 当前比特位 = 0/1】和【b[i] 当前比特位 = 0/1】，分成四组：
(0,0)：表示【a[i] 当前比特位 = 0】和【b[i] 当前比特位 = 0】
(0,1)：表示【a[i] 当前比特位 = 0】和【b[i] 当前比特位 = 1】
(1,0)：表示【a[i] 当前比特位 = 1】和【b[i] 当前比特位 = 0】
(1,1)：表示【a[i] 当前比特位 = 1】和【b[i] 当前比特位 = 1】
这四组两两之间再组合，有 C(4,2)=6 种情况：
(0,0) 和 (0,1)：表示 a[i] b[i] a[j] b[j] 分别为 0 0 0 1（或者 0 1 0 0），把 a[i] ⊕ a[j] 的贡献加到答案中。
(1,0) 和 (1,1)：同上，把 a[i] ⊕ a[j] 的贡献加到答案中。
(0,0) 和 (1,0)：表示 a[i] b[i] a[j] b[j] 分别为 0 0 1 0（或者 1 0 0 0），把 b[i] ⊕ b[j] 的贡献加到答案中。
(0,1) 和 (1,1)：同上，把 b[i] ⊕ b[j] 的贡献加到答案中。
(0,0) 和 (1,1)：这两组合并在一起，继续枚举更低的比特位。这可以递归解决。
(0,1) 和 (1,0)：这两组合并在一起，继续枚举更低的比特位。这可以递归解决。
递归边界：当前比特位等于 -1，表示当前这个组中所有 a[i] 均等于 b[i]，那么直接计算 a[i] ⊕ a[j] 的贡献。
时间复杂度：O(n*18*18)
https://atcoder.jp/contests/arc127/submissions/46727373
======

Input 1
3
1 2 3
4 5 6
Output 1
4

Input 2
4
1 2 3 4
1 2 3 4
Output 2
24

Input 3
10
195247 210567 149398 9678 23694 46151 187762 17915 176476 249828
68649 128425 249346 62366 194119 117620 26327 161384 207 57656
Output 3
4019496
 */