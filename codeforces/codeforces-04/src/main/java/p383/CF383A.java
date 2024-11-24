package p383;

import java.util.Scanner;

public class CF383A {
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
        long cnt1 = 0, ans = 0;
        for (int v : a) {
            if (v > 0) {
                cnt1++;
            } else {
                ans += cnt1;
            }
        }
        return String.valueOf(ans);
    }
}
/*
A. Milking cows
https://codeforces.com/contest/383/problem/A

灵茶の试炼 2024-03-20
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a，只包含 0 和 1。
你按照某种顺序，标记这 n 个数字。
当你标记一个数字 a[i] 时，统计 a[i] 左边所有没有被标记的 1 的个数，和右边所有没有被标记的 0 的个数，加入答案。
输出答案的最小值。

rating 1600
把 0 视作左箭头 ←，把 1 视作右箭头 →。
考虑两个箭头标记的先后顺序：
1. 两个箭头背靠背：先标记谁都不影响答案。
2. 两个箭头面对面：先标记谁都会把答案加一。
3. 两个箭头都朝右：先标记左边的，这样不影响答案。
4. 两个箭头都朝左：先标记右边的，这样不影响答案。
对于朝右的箭头，我们从左往右标记。
对于朝左的箭头，我们从右往左标记。
在这种操作顺序下，只有面对面的箭头会对答案有贡献。
所以只需要统计有多少对箭头是面对面的。
https://codeforces.com/problemset/submission/383/252029619
======

Input
4
0 0 1 0
Output
1

Input
5
1 0 1 0 1
Output
3
 */
