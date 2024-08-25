package p863;

import java.util.Arrays;
import java.util.Scanner;

public class CF863E {
    static int n;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        lr = new int[n][3];
        for (int i = 0; i < n; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
            lr[i][2] = i;
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(lr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        for (int i = 1; i < n; i++) {
            if (lr[i - 1][1] >= lr[i][1]) {
                int idx = lr[i][2] + 1;
                return String.valueOf(idx);
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (lr[i - 1][1] + 1 >= lr[i + 1][0]) {
                int idx = lr[i][2] + 1;
                return String.valueOf(idx);
            }
        }
        return "-1";
    }
}
/*
E. Turn Off The TV
https://codeforces.com/contest/863/problem/E

灵茶の试炼 2022-10-04
题目大意：
输入 n(≤2e5) 和 n 个闭区间，区间左右端点在 [0,1e9] 内，区间的编号从 1 开始。
你需要从中删除一个区间，使得删除前后，所有区间的并集不变（只考虑整数）。
如果不存在这样的区间，输出 -1；否则输出该区间的编号。

rating 2000
https://codeforces.com/contest/863/submission/174510216
方法一：会议室/上下车模型。把每个区间都+1，如果存在一个区间，其范围内的值都 ≥2，那么可以移除该区间。
实现：离散化/动态开点+线段树维护区间最小值。
注意把区间右端点也加入，保证「空位」也被考虑进去了。
方法二：贪心。按照左端点从小到大排序，左端点相同按右端点从大到小排序。
先遍历一遍，如果 a[i-1].right ≥ a[i].right，那么区间 a[i] 被区间 a[i-1] 包含。
否则说明右端点也单调递增，那么再次遍历，判断当前区间的左右相邻区间的并集能否包含当前区间，即 a[i-1].right+1 ≥ a[i+1].left。
实现见代码。
======

input
3
1 3
4 6
1 7
output
1

input
2
0 10
0 10
output
1

input
3
1 2
3 4
6 8
output
-1

input
3
1 2
2 3
3 4
output
2
 */
