package p1166;

import java.util.Arrays;
import java.util.Scanner;

public class CF1166C {
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
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) a[i] = -a[i];
        }
        Arrays.sort(a);

        long ans = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            while (a[l] * 2 < a[i]) {
                l++;
            }
            ans += i - l;
        }
        return String.valueOf(ans);
    }
}
/*
C. A Tale of Two Lands
https://codeforces.com/contest/1166/problem/C

灵茶の试炼 2025-05-20
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
如果数对 (x,y) 满足如下要求，则称 (x,y) 是好数对。
设 |x| 和 |y| 是线段 A 的两个端点。（注意可能 |x| > |y|）
设 |x-y| 和 |x+y| 是线段 B 的两个端点。
需要满足：线段 B 完全包含线段 A。（允许端点相同）
输出有多少个下标对 (i,j)，满足 i<j 且 (a[i],a[j]) 是好数对。

rating 1500
注意到，元素正负号不影响线段端点。
例如把 y 取相反数：
|x+y| = |x-(-y)|
|x-y| = |x+(-y)|
x 取相反数、x 和 y 都取相反数的情况类似。
所以可以先把所有 a[i] 取绝对值，然后从小到大排序。
排序后，设 x=a[i]，y=a[j]，满足 i<j。
那么 x+y 必然 >= y，我们只需保证 y-x<=x，即 2x>=y。
用同向双指针解决。
代码 https://codeforces.com/contest/1166/submission/320295740
代码备份（洛谷）
======

Input
3
2 5 -3
Output
2

Input
2
3 6
Output
1
 */
