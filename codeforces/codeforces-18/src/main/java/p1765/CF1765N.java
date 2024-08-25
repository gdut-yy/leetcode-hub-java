package p1765;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CF1765N {
    static char[] s;
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next().toCharArray();
            k = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int j = 0;
        for (int i = 0; i < k + 1; i++) {
            // 最小非 0 字符（且下标最小）
            if (s[i] > '0' && s[i] < s[j]) {
                j = i;
            }
        }
        // 把 j 左边的都删掉
        k -= j;
        // 保留 s[j]
        Deque<Character> st = new ArrayDeque<>();
        st.push(s[j]);
        // j 右边的正常跑单调栈即可
        for (int i = j + 1; i < s.length; i++) {
            while (st.size() > 1 && k > 0 && s[i] < st.peek()) {
                st.pop();
                k--;
            }
            st.push(s[i]);
        }
        // 还剩下操作次数，就去掉后面的（因为栈顶元素大）
        for (int i = 0; i < k; i++) {
            st.pop();
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) ans.append(st.pop());
        return ans.reverse().toString();
    }
}
/*
N. Number Reduction
https://codeforces.com/contest/1765/problem/N

灵茶の试炼 2023-10-17
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有字符串长度之和 ≤5e5。
每组数据输入一个长度 ≤5e5 的数字字符串 s，和 k(1≤k<len(s))。
s 是一个不含前导零的正整数。
你需要删除 s 中的恰好 k 个字符，使得剩余字符的字典序最小，并且是没有前导零的正整数。

rating 1500
请看题解：
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1765n
本题简单版本: 402. 移掉 K 位数字
https://leetcode.cn/problems/remove-k-digits/
======

input
5
10000
4
1337
0
987654321
6
66837494128
5
7808652
3
output
1
1337
321
344128
7052

1
1110 2
10
 */
