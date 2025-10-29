package c205;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Arc205_c {
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
        List<int[]> ch = new ArrayList<>();
        List<int[]> c1 = new ArrayList<>(); // val, index
        List<int[]> c2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            ch.add(new int[]{s, t});
            if (s < t) {
                c1.add(new int[]{s, i});
            } else {
                c2.add(new int[]{s, i});
            }
        }
        // 按s升序排序
        ch.sort(Comparator.comparingInt(a -> a[0]));

        // 检查t是否非递减
        for (int i = 0; i < n - 1; i++) {
            if (ch.get(i)[1] > ch.get(i + 1)[1]) {
                out.println("No");
                return;
            }
        }

        // 对c1按value降序排序
        c1.sort(Comparator.comparingInt(a -> -a[0]));
        // 对c2按value升序排序
        c2.sort(Comparator.comparingInt(a -> a[0]));

        List<Integer> ans = new ArrayList<>();
        for (int[] iv : c1) {
            ans.add(iv[1] + 1);
        }
        for (int[] iv : c2) {
            ans.add(iv[1] + 1);
        }

        out.println("Yes");
        out.println(ans.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
/*
C - No Collision Moves
https://atcoder.jp/contests/arc205/tasks/arc205_c

题目大意：
在一条数线上有 N 人。
人 i (1<= i<= N) 最初位于坐标 Si ，并希望最终移动到坐标 Ti 。可以保证 S1,S2,...,SN,T1,T2,...,TN 都是不同的。
你固定了 (1,2,...,N) 的一个排列 P=(P1,P2,...,PN) ，并依次执行了 N 次操作。在 i-th 运算 (1<= i<= N) 中，将人 P_i 从坐标 S_{P_i} 沿数线上最短的路径移动到坐标 T_{P_i} 。但是，如果移动路径上还有另一个人，就会发生争斗。
请判断是否存在不会发生打斗的 P ，如果存在，请找出一个。

https://atcoder.jp/contests/arc205/editorial/13827
======

Input 1
4
1 3
2 4
7 5
8 10
Output 1
Yes
3 2 1 4

Input 2
2
1 3
4 2
Output 2
No

Input 3
5
19 17
1 10
9 14
3 11
8 13
Output 3
Yes
3 5 1 4 2
 */
