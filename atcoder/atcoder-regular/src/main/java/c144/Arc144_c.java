package c144;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Arc144_c {
    static int n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int k2 = k * 2;
        int m = n - n % k2 - k2;
        if (m < 0) {
            return "-1";
        }

        int i = 1;
        List<Integer> ans = new ArrayList<>();
        while (i <= m) {
            for (int j = 0; j < k; j++) {
                ans.add(i + k + j);
            }
            for (int j = 0; j < k; j++) {
                ans.add(i + j);
            }
            i += k2;
        }
        if (n % k2 <= k) {
            for (int j = 0; j < k + n % k2; j++) {
                ans.add(i + k + j);
            }
            for (int j = 0; j < k; j++) {
                ans.add(i + j);
            }
        } else {
            for (int j = 0; j < k; j++) {
                ans.add(i + k + j);
            }
            for (int j = 0; j < n % k; j++) {
                ans.add(i + j);
            }
            for (int j = n % k; j < k + n % k; j++) {
                ans.add(i + k2 + j);
            }
            for (int j = n % k; j < k; j++) {
                ans.add(i + j);
            }
            for (int j = 0; j < n % k; j++) {
                ans.add(i + k2 + j);
            }
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C - K Derangement
https://atcoder.jp/contests/arc144/tasks/arc144_c

灵茶の试炼 2022-12-08
题目大意：
输入 n 和 k (k<n≤3e5)。
请构造一个字典序最小的 1~n 的排列 p（下标从 1 开始），使得 abs(p[i]-i)≥k 对每个 i 都成立。
如果无法构造，输出 -1。否则输出 p。

https://atcoder.jp/contests/arc144/submissions/37093582
手玩一下 k=3 的情况，发现规律是 6 个一组，每组是
i+4,i+5,i+6,i+1,i+2,i+3
这里 i=6m+1
考虑 n 不是 6 的倍数，手玩发现最后残余 (n%(k*2)) 的一组会和倒数第二组有关系：
1. 如果残余数量 ≤ k
规律如样例 2
2. 如果残余数量 > k
例如残余 4
那么最后两组就是
4,5,6,1,8,9,10,2,3,7
例如残余 5
那么最后两组就是
4,5,6,1,2,9,10,11,3,7,8
按这个规律输出，就可以做到 O(1) 空间复杂度了。
======

Input 1
3 1
Output 1
2 3 1

Input 2
8 3
Output 2
4 5 6 7 8 1 2 3

Input 3
8 6
Output 3
-1
 */