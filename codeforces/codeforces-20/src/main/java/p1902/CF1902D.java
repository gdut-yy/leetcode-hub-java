package p1902;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1902D {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;
    static char[] s;

    public static void main(String[] args) {
        n = scanner.nextInt();
        q = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static int[] dirs(char c) {
        if (c == 'L') return DIRECTIONS[2];
        else if (c == 'R') return DIRECTIONS[0];
        else if (c == 'D') return DIRECTIONS[3];
        return DIRECTIONS[1];
    }

    record pair(int x, int y) {
    }

    private static String solve() {
        pair[] pre = new pair[n + 1];
        Arrays.setAll(pre, e -> new pair(0, 0));
        Map<pair, List<Integer>> pos = new HashMap<>();
        pos.computeIfAbsent(new pair(0, 0), e -> new ArrayList<>()).add(0);
        int x = 0, y = 0;
        for (int i = 0; i < s.length; i++) {
            int[] d = dirs(s[i]);
            x += d[0];
            y += d[1];
            pair p = new pair(x, y);
            pre[i + 1] = p;
            pos.computeIfAbsent(p, e -> new ArrayList<>()).add(i + 1);
        }

        String[] ans = new String[q];
        for (int qi = 0; qi < q; qi++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            pair p = new pair(x, y);
            List<Integer> ps = pos.getOrDefault(p, new ArrayList<>());
            if (!ps.isEmpty() && (ps.getFirst() < l || ps.getLast() >= r)) {
                ans[qi] = "YES";
                continue;
            }
            pair q = new pair(pre[r].x + pre[l - 1].x - p.x, pre[r].y + pre[l - 1].y - p.y);
            ps = pos.getOrDefault(q, new ArrayList<>());
            int i = searchInts(ps, l - 1);
            if (i < ps.size() && ps.get(i) <= r) {
                ans[qi] = "YES";
            } else {
                ans[qi] = "NO";
            }
        }
        return String.join(System.lineSeparator(), ans);
    }

    static int searchInts(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
D. Robot Queries
https://codeforces.com/contest/1902/problem/D

灵茶の试炼 2024-08-22
题目大意：
输入 n(1≤n≤2e5) q(1≤q≤2e5) 和长为 n 的字符串 s，只包含 UDLR。
一开始，你在平面直角坐标系的原点 (0,0)，你需要从左到右执行 s 上的操作，UDLR 分别表示向上/下/左/右移动一个单位。
然后输入 q 个询问，每个询问输入 x y(-n≤x,y≤n) l r(1≤l≤r≤n)。
你需要把原串 s 的下标从 l 到 r 这一段 reverse。（下标从 1 开始）
然后依旧从 (0,0) 出发，从左到右执行 s 上的操作，判断路径是否包含 (x,y)。
输出 YES 或 NO。
注意询问是【互相独立】的，每次询问修改的都是原串 s。

rating 1900
在线做法。
字符串对应一条从 (0,0) 出发的路径。
注意反转操作不会影响 s[1..l-1] 和 s[r+1..n] 这两段路径。
设 p 是原串 s 对应路径上的点。
记录 p 首次出现的位置 i，如果 i < l，那么答案是 YES。
记录 p 最后一次出现的位置 j，如果 j >= r，那么答案是 YES。
为了下面的计算，把所有 p 的出现位置保存到列表 pos[p] 中。
否则，看看 (x,y) 是否在 rev(s[l..r]) 这一段路径上。
我们会先从 (0,0) 出发，执行 s[1..l-1] 操作，再（等价于）执行 s[i..r] 操作。
可以利用前缀和，计算从 s[i] 到 s[r] 的「偏移量」是多少（两个位置相减）。
设 pre[0] = (0,0), pre[i] 为执行 s[1..i] 操作后的位置。
那么有 pre[l-1].x + (pre[r].x - pre[i-1].x) = x
解得 pre[i-1].x = pre[l-1].x + pre[r].x - x
同理得 pre[i-1].y = pre[l-1].y + pre[r].y - y
记 q = (pre[l-1].x + pre[r].x - x, pre[l-1].y + pre[r].y - y)
在 pos[q] 上二分查找第一个 >= l-1 的数，如果这个数 <= r，那么答案是 YES，否则是 NO。
代码 https://codeforces.com/contest/1902/submission/277588713
注：离线询问可以做到 O(n+q)。
======

Input
8 3
RDLLUURU
-1 2 1 7
0 0 3 4
0 1 7 8
Output
YES
YES
NO

Input
4 2
RLDU
0 0 2 2
-1 -1 2 3
Output
YES
NO

Input
10 6
DLUDLRULLD
-1 0 1 10
-1 -2 2 5
-4 -2 6 10
-1 0 3 9
0 1 4 7
-3 -1 5 8
Output
YES
YES
YES
NO
YES
YES
 */
