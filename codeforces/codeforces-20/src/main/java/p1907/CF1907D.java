package p1907;

import java.util.Scanner;

public class CF1907D {
    static int n;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            lr = new int[n][2];
            for (int i = 0; i < n; i++) {
                lr[i][0] = scanner.nextInt();
                lr[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int left = 0;
        int right = (int) (1e9 + 10);
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    static boolean checkMid(int mid) {
        int L = 0, R = 0;
        for (int i = 0; i < n; i++) {
            if (R + mid < lr[i][0] || lr[i][1] < L - mid) {
                return false;
            }
            L = Math.max(L - mid, lr[i][0]);
            R = Math.min(R + mid, lr[i][1]);
        }
        return true;
    }
}
/*
D. Jumping Through Segments
https://codeforces.com/contest/1907/problem/D

题目大意：
Polycarp 正在为一款游戏设计关卡。该层由数轴上的 n 段组成，其中第 i 段从坐标为 li 的点开始，到坐标为 ri 的点结束。
玩家从坐标为 0 的点开始关卡。在一次移动中，它们可以移动到距离不超过 k 的任何点。在第 i 次移动之后，玩家必须在第 i 段内着陆，即在坐标 x 上，使得 li≤x≤ri。这意味着:
- 在第一次移动之后，它们必须在第一个段内(从 l1 到 r1);
- 在第二次移动之后，他们必须在第二段内(从 l2 到 r2);
- ．．．
- 在第 n 次移动之后，它们必须在第 n 段内(从 ln 到 rn)。
如果玩家按照上述规则到达第 n 个关卡，则认为该关卡已经完成。经过一番思考，Polycarp 意识到用 k 的某些值来完成关卡是不可能的。
Polycarp 不希望关卡太简单，所以他要求你确定最小整数 k
有了它，就有可能完成关卡。

二分
======

input
4
5
1 5
3 4
5 6
8 10
0 1
3
0 2
0 1
0 3
3
3 8
10 18
6 11
4
10 20
0 5
15 17
2 2
output
7
0
5
13
 */