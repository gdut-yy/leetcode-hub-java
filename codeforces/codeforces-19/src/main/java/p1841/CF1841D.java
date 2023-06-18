package p1841;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1841D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] seg = new int[n + 1][2];
            for (int i = 1; i <= n; i++) {
                seg[i][0] = scanner.nextInt();
                seg[i][1] = scanner.nextInt();
            }
            System.out.println(solve(n, seg));
        }
    }

    private static final int MAX_N = (int) (2e5 + 2);

    // https://codeforces.com/contest/1841/submission/209465959
    private static String solve(int n, int[][] seg) {
        int[] f = new int[MAX_N];

        Arrays.sort(seg, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        for (int i = 1; i <= n; i++) {
            f[i] = Math.max(f[i], f[i - 1]);
            for (int j = i + 1; j <= n; j++) {
                if (seg[i][1] >= seg[j][0]) {
                    // int k = lower_bound(seg + 1, seg + 1 + n, make_pair(max(seg[i].second, seg[j].second) + 1, 0)) - seg;
                    int k = lowerBound(seg, Math.max(seg[i][1], seg[j][1]) + 1);
                    f[k] = Math.max(f[k], f[i] + 2);
                } else {
                    break;
                }
            }
        }
        return String.valueOf(n - Math.max(f[n], f[n + 1]));
    }

    private static int lowerBound(int[][] seg, int key) {
        int left = 0;
        int right = seg.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (seg[mid][0] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/*
D. Pairs of Segments
https://codeforces.com/contest/1841/problem/D

题目大意：
如果存在至少一个 x 使得 l1≤x≤r1 且 l2≤x≤r2,则两个线段[l1,r1]和[l2,r2]相交。
如果 k 是偶数,则由[[l1,r1],[l2,r2],...,[lk,rk]]段组成的数组称为美数组,并且可以将该数组的元素分成 k/2 对,如下所示:
- 数组的每个元素只属于数组对中的一个;
- 每对中的段彼此相交;
- 不同对中的段不相交。
例如,数组[[2,4],[9,12],[2,4],[7,7],[10,13],[6,8]]是漂亮的,因为可以按如下方式形成 3 对:
- 数组的第一个元素(segment[2,4])和数组的第三个元素(segment [2,4]);
- 数组的第二个元素(段[9,12])和数组的第五个元素(段[10,13]);
- 数组的第四个元素(段[7,7])和数组的第六个元素(段[6,8])。
如您所见,每对中的段相交,并且来自不同对的段不相交。
给定一个 n 段数组[[l1,r1],[l2,r2],...,[ln,rn]]。您必须从该数组中删除尽可能少的元素,以便生成的数组美观。

划分型 DP
======

input
3
7
2 4
9 12
2 4
7 7
4 8
10 13
6 8
5
2 2
2 8
0 10
1 2
5 6
4
1 1
2 2
3 3
4 4
output
1
3
4
 */