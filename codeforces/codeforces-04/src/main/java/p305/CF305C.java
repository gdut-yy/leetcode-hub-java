package p305;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF305C {
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
        int maxV = 0;
        Set<Integer> bit = new HashSet<>();
        for (int v : a) {
            while (bit.contains(v)) {
                bit.remove(v);
                v++;
            }
            bit.add(v);
            maxV = Math.max(maxV, v);
        }
        int ans = maxV + 1 - bit.size();
        return String.valueOf(ans);
    }
}
/*
C. Ivan and Powers of Two
https://codeforces.com/contest/305/problem/C

灵茶の试炼 2022-06-02
题目大意：
给你一个有序数组 a，长度不超过 1e5，0<=a[i]<=2e9。
请你求出 2^a[0]+2^a[1]+...+2^a[n-1] 的二进制中的 0 的个数。（^ 表示幂）

rating 1600
https://codeforces.com/problemset/submission/305/159205281
用 set 模拟二进制加法，set 中存储比特位为 1 的位置。
添加 2^a[i] 时，如果第 a[i] 个比特位为 1，则不断进位直到找到 0。进位的意思是将这一位从 set 中去掉。
最后答案为 max(set)-len(set)+1。
时间复杂度：每个比特位至多被添加和删除各一次，所以是 O(n) 的（如果你用的是哈希表的话）。
======

input
4
0 1 1 1
output
0

input
1
3
output
3
 */
