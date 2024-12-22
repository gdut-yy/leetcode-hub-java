package p1883;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CF1883F {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Map<Integer, Integer> r = new HashMap<>();
        for (int i = 0; i < n; i++) {
            r.put(a[i], i);
        }

        long ans = 0;
        Set<Integer> vis = new HashSet<>();
        int rs = r.size();
        for (int i = 0; i < n; i++) {
            if (!vis.contains(a[i])) {
                vis.add(a[i]);
                ans += rs;
            }
            if (r.get(a[i]) == i) {
                rs--;
            }
        }
        return String.valueOf(ans);
    }
}
/*
F. You Are So Beautiful
https://codeforces.com/contest/1883/problem/F

灵茶の试炼 2024-06-25
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
输出 a 有多少个非空连续子数组 b，满足 b 是 a 的唯一子序列（不存在其他的子序列等于 b）。
注：子序列不一定连续。

rating 1400
考察子数组最左边和最右边的元素。
条件一：子数组最左边的元素 a[L]，其左侧不能有等于 a[L] 的元素，否则子序列不唯一。
条件二：子数组最右边的元素 a[R]，其右侧不能有等于 a[R] 的元素，否则子序列不唯一。
结论：满足这两个条件，则子序列是唯一的。
证明：用反证法证明。
假设子序列不唯一，那么另一个子序列的不同下标一定位于 [L,R] 内部（如果位于 [L,R] 外面就破坏了条件一或条件二），但是这个范围内的所有下标我们都选了，不可能存在一个子序列没有而另一个子序列有的情况，矛盾，故原命题成立。
怎么计算子数组个数呢？
前后缀分解。
处理出每个 a[i] 首次和最后一次出现的位置。（实际只需要处理最后一次）
枚举 a[i] 作为左端点，那么 a[i] 必须是首次出现的元素，我们还需要知道 >=i 的且是最后一次出现的元素的个数，具体见代码。
https://codeforces.com/problemset/submission/1883/266720706
======

Input
6
1
1
2
1 1
3
1 2 1
4
2 3 2 1
5
4 5 4 5 4
10
1 7 7 2 3 4 3 2 1 100
Output
1
1
4
7
4
28
 */
