package p1608;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF1608C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a, b));
        }
    }

    private static String solve(int n, int[] a, int[] b) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(a[i], b[i], i);
        }
        Arrays.sort(nodes, Comparator.comparingInt(o -> o.a));

        // 前后缀分解
        int[] suf = new int[n];
        suf[n - 1] = nodes[n - 1].b;
        int mn = nodes[n - 1].b;
        for (int i = n - 2; i >= 0; i--) {
            mn = Math.min(mn, nodes[i].b);
            if (nodes[i].b > suf[i + 1]) {
                suf[i] = mn;
            } else {
                suf[i] = suf[i + 1];
            }
        }

        char[] ans = new char[n];
        Arrays.fill(ans, '1');
        int pre = 0;
        for (int i = 0; i < n - 1; i++) {
            pre = Math.max(pre, nodes[i].b);
            if (pre < suf[i + 1]) {
                ans[nodes[i].idx] = '0';
            }
        }
        return new String(ans);
    }

    private static class Node {
        int a, b, idx;

        public Node(int a, int b, int idx) {
            this.a = a;
            this.b = b;
            this.idx = idx;
        }
    }
}
/*
C. Game Master
https://codeforces.com/contest/1608/problem/C

灵茶の试炼 2023-05-03
题目大意：
输入 T(≤100) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(≤1e5)，长为 n 的数组 a(1≤a[i]≤1e9)，长为 n 的数组 b(1≤b[i]≤1e9)。
a 中无重复元素，b 中无重复元素。
有 n 名选手，两个比赛场地。
第 i 个选手在第一个场地的力量是 a[i]，在第二个场地的力量是 b[i]。
每次从剩余选手中选择两名选手，以及一处比赛场地。力量小的淘汰。
n-1 次比赛后，剩下的那个人是冠军。
安排谁和谁比赛的权力在你手上（你是懂暗箱操作的），请对每位选手都作出判断，如果第 i 位选手能成为冠军，输出 1，否则输出 0。

https://codeforces.com/contest/1608/submission/203857553
方法不止一种。无需建图，下面讲只用循环的做法。
按照 a[i] 从小到大排序，方便研究。
手玩如下输入，如何让 a[i]=1 的这位选手获胜呢？
a = 1 2 3 4 5 6
b = 2 4 1 6 3 5
右边的选手可以通过第一个场地击败左边的
左边的选手可以通过第二个场地击败右边的（如果左边的选手 b[i] 大的话）
思考：
甲需要干掉 a 最大的人（只能是第二个场地），也就是找到一个 i<n 且 b[i]>b[n] 的 i。
乙干掉甲（只能是第一个场地），也就是找到一个 j>i 的人。
为了能让更左边的选手丙干掉乙（第二个场地），b[j] 越小越好。
然后再找人干掉丙（第一个场地）。
如此反复。
那么让 a[i]=1 的选手获胜的方案为：（数字表示 b[i]）
6 干掉 5
3 干掉 6（第一个场地）
4 干掉 3
1 干掉 4（第一个场地）
2 干掉 1
你能将上述过程转换成代码吗？
刚才算的是第一位选手能否获胜，如何计算其它选手能否获胜呢？
由于他可以干掉他左边的人（第一个场地）
那么把他和他左边的人的 b[i] 取最大值，合并成一名选手，就转换成上面的讨论了。
======

input
3
4
1 2 3 4
1 2 3 4
4
11 12 20 21
44 22 11 30
1
1000000000
1000000000
output
0001
1111
1
 */
