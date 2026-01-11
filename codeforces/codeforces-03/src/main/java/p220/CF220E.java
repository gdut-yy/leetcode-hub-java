package p220;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF220E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // 创建排序后的数组并去重
        int[] b = Arrays.copyOf(a, n);
        Arrays.sort(b);
        int m = removeDuplicates(b);

        // 离散化
        BIT suf = new BIT(m + 1);
        for (int i = n - 1; i >= 0; i--) {
            int pos = Arrays.binarySearch(b, 0, m, a[i]) + 1;
            a[i] = pos;
            k -= suf.pre(a[i] - 1);
            suf.add(a[i], 1);
        }

        BIT pre = new BIT(m + 1);
        int l = 0;
        long ans = 0;

        for (int r = 1; r < n; r++) {
            // 从后缀中删除 a[r-1]
            suf.add(a[r - 1], -1);
            k += l - pre.pre(a[r - 1]) + suf.pre(a[r - 1] - 1);

            while (l < r) {
                // 尝试往前缀添加 a[l]
                int inv = l - pre.pre(a[l]) + suf.pre(a[l] - 1);
                if (inv > k) {
                    break;
                }
                // 添加后，总逆序对个数 <= k
                k -= inv;
                pre.add(a[l], 1);
                l++;
            }

            // 右端点为 r 时，左端点可以是 0,1,...,l-1，一共 l 个
            ans += l;
        }

        out.println(ans);
    }


    // 去重函数
    static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        int writeIndex = 1;
        for (int readIndex = 1; readIndex < arr.length; readIndex++) {
            if (arr[readIndex] != arr[readIndex - 1]) {
                arr[writeIndex++] = arr[readIndex];
            }
        }
        return writeIndex;
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int pre(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }
    }
}
/*
E. Little Elephant and Inversions
https://codeforces.com/contest/220/problem/E

灵茶の试炼 2025-12-11
题目大意：
输入 n(2≤n≤1e5) k(0≤k≤1e18) 和长为 n 的数组 a(1≤a[i]≤1e9)。
输出有多少个 (L,R)，满足 L<R 且删除子数组 [L+1,R-1] 后，剩余元素的逆序对数量至多为 k。

rating 2400
本题是 上周双周赛第四题 的补集版本。
也用值域树状数组做，本题要用同向双指针。
用两棵值域树状数组 pre 和 suf 分别维护前后缀的元素（需要离散化）。
先把所有元素都填入 suf，计算逆序对。
然后枚举 R=1,2,...,n-1（我的做法下标从 0 开始），从 suf 中删除 a[R-1]，撤销逆序对（a[R-1] 与 pre 和 suf 的逆序对）。
对于固定的 R，类似滑动窗口计算方案数的题，尝试右移左指针（扩大前缀），计算 a[L] 与 pre 和 suf 的逆序对。
如果添加 a[L] 导致逆序对总数大于 k，那么就不添加，跳出内层循环；否则添加，更新逆序对总数，L 加一，继续循环。
内层循环结束后，右端点固定为 R 时，左端点可以是 0,1,...,L-1，一共 L 个，加入答案。
代码（详细注释） https://codeforces.com/problemset/submission/220/352788601
代码备份（上面打不开的同学看这个）
======

Input
3 1
1 3 2
Output
3

Input
5 2
1 3 2 1 7
Output
6
 */
