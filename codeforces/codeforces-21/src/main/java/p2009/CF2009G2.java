package p2009;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CF2009G2 {
    static Scanner scanner = new Scanner(System.in);
    static int n, k, q;
    static int[] a;

    public static void main(String[] args) {
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            q = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                a[i] += n - 2 - i;
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] mn = new int[n - k + 1];
        int[] cnt = new int[n * 2 - 1];
        int[] cc = new int[n + 1];
        int maxC = 0;
        for (int r = 0; r < n; r++) {
            int v = a[r];

            cc[cnt[v]]--;
            cnt[v]++;
            cc[cnt[v]]++;
            maxC = Math.max(maxC, cnt[v]);

            int l = r + 1 - k;
            if (l < 0) {
                continue;
            }
            mn[l] = k - maxC;

            v = a[l];
            cc[cnt[v]]--;
            cnt[v]--;
            cc[cnt[v]]++;
            if (cc[maxC] == 0) {
                maxC--;
            }
        }

        List<int[]>[] qs = new ArrayList[n - k + 1]; // r, i
        Arrays.setAll(qs, e -> new ArrayList<>());
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            qs[l - 1].add(new int[]{r - k, i});
        }

        long[] ans = new long[q];
        List<data> st = new ArrayList<>();
        st.add(new data(mn.length, -1, 0));
        for (int i = mn.length - 1; i >= 0; i--) {
            int v = mn[i];
            int r = i;
            while (st.getLast().v >= v) {
                r = st.getLast().r;
                st.removeLast();
            }
            st.add(new data(r, v, st.getLast().s + (r - i + 1L) * v));
            for (int[] p : qs[i]) {
                int j = sortSearch(st.size(), (i0) -> st.get(i0).r < p[0]) - 1;
                ans[p[1]] = st.getLast().s - st.get(j - 1).s - (long) (st.get(j).r - p[0]) * st.get(j).v;
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    // func Search(n int, f func(int) bool) int { ... }
    static int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    record data(int r, int v, long s) {
    }
}
/*
G2. Yunli's Subarray Queries (hard version)
https://codeforces.com/contest/2009/problem/G2

灵茶の试炼 2024-11-07
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，q 之和 ≤2e5。
每组数据输入 n k(1≤k≤n≤2e5) q(1≤q≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)。
对于一个数组 b，你可以执行若干次操作，每次操作可以把一个 b[i] 改成任意值。
定义 f(b) 表示使 b 中存在长度至少为 k 的连续递增子数组的最小操作次数。（连续递增：对任意 i 满足 b[i+1] = b[i] + 1）
然后输入 q 个询问，每个询问输入 l 和 r，下标从 1 开始，保证 r-l+1 >= k。
定义 a[i..j] 表示 a 的下标从 i 到 j 的子数组。
对于每个询问，输出 f(a[l..l+k-1]) + f(a[l..l+k]) + ... + f(a[l..r])。

rating 2200
连续递增，等价于 a[j] = a[i] + (j-i)，即 a[j] - j = a[i] - i。
所以把 a[i] 变成 a[i] - i，这样「连续递增」就变成了「元素值都相等」。
首先，跑一个定长滑动窗口，计算每个长为 k 的子数组的众数出现次数，那么「k - 众数出现次数」就是这个子数组最少需要修改的元素个数。
这可以用有序集合 map / 懒删除堆 / cnt 的 cnt 统计。代码采用的最后一种，效率最高。
每个子数组的「k - 众数出现次数」记录在一个长为 n-k+1 的数组 mn 中。
一个长为 k+1 的子数组的 f 值，等于 2 个长为 k 的子数组的「k - 众数出现次数」的最小值。
一个长为 k+2 的子数组的 f 值，等于 3 个长为 k 的子数组的「k - 众数出现次数」的最小值。
依此类推。
然后，离线询问，从右到左遍历 mn，回答询问。
遍历 mn 的同时维护一个（底小顶大的）单调栈，例如 mn=[3,4,1,1,2]，从左到右计算最小值就是 [3,3,1,1,1]，单调栈维护 tuple{3，最右的 3 的下标，后缀和 3+3+1+1+1} 以及 tuple{1，最右的 1 的下标，后缀和 1+1+1}。
对于每个左端点在 i 的询问，根据询问的右端点，在单调栈上二分，计算子数组和。
注：单调栈底部可以放个哨兵 tuple{len(mn), -1, 0} 简化代码逻辑。
注：也可以用倍增做到在线。
代码 https://codeforces.com/problemset/submission/2009/290367724
代码备份（洛谷）
======

Input
3
7 5 3
1 2 3 2 1 2 3
1 7
2 7
3 7
8 4 2
4 3 1 1 2 4 3 2
3 6
1 5
5 4 2
4 5 1 2 3
1 4
1 5
Output
6
5
2
2
5
2
3
 */
