package p1870;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1870D {
    static int n;
    static int[] a;
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            k = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<int[]> st = new ArrayList<>(); // i, c
        st.add(new int[2]);
        for (int i = 0; i < n; i++) {
            int c = a[i];
            while (c <= st.getLast()[1]) {
                st.removeLast();
            }
            st.add(new int[]{i + 1, c});
        }

        int h = (int) 1e9;
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < st.size(); i++) {
            int d = st.get(i)[1] - st.get(i - 1)[1];
            h = Math.min(h, k / d);
            k -= d * h;
            output.append((h + " ").repeat(st.get(i)[0] - st.get(i - 1)[0]));
        }
        return output.toString();
    }
}
/*
D. Prefix Purchase
https://codeforces.com/contest/1870/problem/D

灵茶の试炼 2024-07-31
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 c(1≤c[i]≤1e9)。
然后输入 k(1≤k≤1e9)。
你有 k 块钱和一个长为 n 的全 0 数组 a。
每次操作，你可以花费 c[i]，把 a[0],a[1],...,a[i] 都加一，前提是 c[i] <= k。
输出你能得到的字典序最大的 a。

rating 1800
首先要保证 a[0] 尽量大，其最大值为 floor(k / min(c))，且这个 min(c) 的位置越靠右越好。
但是，还可能有剩余的钱。
比如 c=[10,12,13]，k=25，那么 a[0]=floor(25/10)=2，还剩下 25-10*2=5 块钱。
我们也可以通过花费两次 12（相当于在 10 的基础上，额外花费两次 2），让 a[0]=a[1]=2。
继续，在 12 的基础上，额外花费 1，让 a[2]=1。
所以最终的数组是 a=[2,2,1]，相当于花费一次 c[1]=12 和一次 c[2]=13。
具体要怎么花钱呢？
如果左边有一个较大的 c，右边有一个较小的 c，那么左边这个 c 是绝对不会用到的。
这启发我们用单调栈处理 c。
遍历 c，用单调栈处理出 c 的一个严格递增的子序列，然后按照子序列中的元素操作。
设当前还剩下 k 块钱，子序列相邻两个 c 的差是 d，相邻两个 c 的下标之差是 m，那么可以额外让 m 个元素变成 k/d，注意 k/d 不能超过之前计算出的所有 k/d 的最小值。
代码 https://codeforces.com/contest/1870/submission/272717966
======

Input
4
3
1 2 3
5
2
3 4
7
3
3 2 1
2
6
10 6 4 6 3 4
7
Output
5 0 0
2 1
2 2 2
2 2 2 2 2 1
 */
