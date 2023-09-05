package c140;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc140_e {
    static int n;
    static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] pos = new int[n + 1];
        int[] L = new int[n + 2];
        int[] R = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int v = p[i];
            pos[v] = i;
            L[i] = i - 1;
            R[i] = i + 1;
        }
        long ans = 0;
        for (int v = 1; v <= n; v++) {
            int i = pos[v];
            int l = L[i], r = R[i];
            if (l > 0) {
                ans += (long) v * (l - L[l]) * (r - i);
            }
            if (r <= n) {
                ans += (long) v * (R[r] - r) * (i - l);
            }
            // 删除 v
            L[r] = l;
            R[l] = r;
        }
        return String.valueOf(ans);
    }
}
/*
E - Second Sum
https://atcoder.jp/contests/abc140/tasks/abc140_e

灵茶の试炼 2022-11-11
题目大意：
输入 n(≤1e5) 和一个 1~n 的排列 p。
输出 p 中所有长度至少为 2 的子数组的第二大元素的和。

https://atcoder.jp/contests/abc140/submissions/36373341
方法一：贡献法，对每个 p[i]，求上个、上上个、下个、下下个更大元素的位置，分别记作 L LL R RR。
具体求法见双周赛第四题（链接见右）。
那么 p[i] 对答案的贡献为 p[i] * ((L-LL)*(R-i) + (RR-R)*(i-L))。
方法二：对于排列，其实不需要单调栈。
用双向链表思考（实现时用的数组）：
把 p 转换成双向链表，按元素值从小到大遍历 p[i]，那么方法一中的 4 个位置就是 p[i] 左边两个节点和右边两个节点。
算完 p[i] 后把 p[i] 从链表中删掉。
怎么用数组实现见代码。
顺带一提，循环结束后，L[i] 和 R[i] 就是 p[i] 的上个/下个更大元素的位置。
如果要求更小元素位置，倒序遍历即可。
======

Input 1
3
2 3 1
Output 1
5

Input 2
5
1 2 3 4 5
Output 2
30

Input 3
8
8 2 7 3 4 5 6 1
Output 3
136
 */