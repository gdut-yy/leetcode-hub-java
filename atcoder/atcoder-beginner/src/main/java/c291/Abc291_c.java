package c291;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc291_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String s) {
        int x = 0, y = 0;
        Set<Long> set = new HashSet<>();
        set.add(0L);
        for (char ch : s.toCharArray()) {
            if (ch == 'R') {
                x++;
            } else if (ch == 'L') {
                x--;
            } else if (ch == 'U') {
                y++;
            } else {
                y--;
            }
            long val = x * 200005L + y;
            if (set.contains(val)) {
                return "Yes";
            } else {
                set.add(val);
            }
        }
        return "No";
    }
}
/*
C - LRUD Instructions 2
https://atcoder.jp/contests/abc291/tasks/abc291_c

题目大意：
高桥在二维平面上。从原点开始，他走了 N 步。
N 次移动由长度为 N 的字符串表示，如下所示:
第 i 步之后，Takahashi 的坐标是:
- (x+1,y) if the i-th character of S is R;
- (x−1,y) if the i-th character of S is L;
- (x,y+1) if the i-th character of S is U; and
- (x,y−1) if the i-th character of S is D,
where (x,y) is his coordinates before the move.
确定 Takahashi 是否在 N 次移动过程中多次访问相同的坐标(包括起点和终点)。

哈希表 判断。
======

Input 1
5
RLURU
Output 1
Yes

Input 2
20
URDDLLUUURRRDDDDLLLL
Output 2
No
 */