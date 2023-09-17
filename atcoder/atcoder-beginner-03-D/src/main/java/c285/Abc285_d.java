package c285;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Abc285_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String[][] st = new String[n][2];
        for (int i = 0; i < n; i++) {
            st[i][0] = scanner.next();
            st[i][1] = scanner.next();
        }
        System.out.println(solve(n, st));
    }

    private static String solve(int n, String[][] st) {
        Set<String> seen = new HashSet<>();
        Map<String, Integer> inDeg = new HashMap<>();
        Map<String, List<String>> adj = new HashMap<>();
        for (String[] edge : st) {
            String x = edge[0], y = edge[1];
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
            // 入度
            inDeg.put(y, inDeg.getOrDefault(y, 0) + 1);
            // 出现过的节点
            seen.add(x);
            seen.add(y);
        }

        Queue<String> queue = new ArrayDeque<>();
        for (String s : seen) {
            if (!inDeg.containsKey(s)) {
                queue.add(s);
            }
        }
        List<String> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String x = queue.remove();
                topo.add(x);

                for (String y : adj.getOrDefault(x, new ArrayList<>())) {
                    inDeg.put(y, inDeg.get(y) - 1);
                    if (inDeg.get(y) == 0) {
                        queue.add(y);
                    }
                }
            }
        }

        return topo.size() == seen.size() ? "Yes" : "No";
    }
}
/*
D - Change Usernames
https://atcoder.jp/contests/abc285/tasks/abc285_d

题目大意：
你运行一个有 N 个用户的 web 服务。
当前句柄 si 的第 i 个用户希望将其更改为 ti。
这里，s1,...,sn 是两两不同的，t1,...,tn 也是。
确定是否有一个适当的顺序来改变他们的句柄，以满足他们的所有要求，但须符合以下条件:
- 一次只能更改一个用户的句柄;
- 您只需更改每个用户的句柄一次;
- 当更改句柄时，此时其他用户不应使用新句柄。

拓扑排序
======

Input 1
2
b m
m d
Output 1
Yes

Input 2
3
a b
b c
c a
Output 2
No

Input 3
5
aaa bbb
yyy zzz
ccc ddd
xxx yyy
bbb ccc
Output 3
Yes
 */