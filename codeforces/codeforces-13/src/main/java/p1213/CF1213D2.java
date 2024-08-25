package p1213;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1213D2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, k, a));
    }

    private static final int MX = (int) 2e5;

    private static String solve(int n, int k, int[] a) {
        // 列表的第 j 项记录有多少个数可以通过操作 j 次变为 x。
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int x : a) {
            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<>(List.of(1)));
            } else {
                int cnt = map.get(x).get(0);
                map.get(x).set(0, cnt + 1);
            }
        }

        // 后往前枚举
        int ans = Integer.MAX_VALUE;
        for (int x = MX; x > 0; x--) {
            if (!map.containsKey(x)) {
                continue;
            }
            // 每个 x 都有一个列表，列表的第 j 项记录有多少个数可以通过操作 j 次变为 x
            List<Integer> b = map.get(x);
            int s = 0, left = k;
            for (int j = 0; j < b.size(); j++) {
                if (left <= b.get(j)) {
                    ans = Math.min(ans, s + left * j);
                    break;
                }
                s += b.get(j) * j;
                left -= b.get(j);
            }

            int halfX = x / 2;
            if (!map.containsKey(halfX)) {
                // 如果无法得到 k 个 x，那么把这个列表左边插入个 0，然后合并到 x/2 的列表中
                map.put(halfX, new ArrayList<>());
                map.get(halfX).add(0);
                map.get(halfX).addAll(new ArrayList<>(b));
            } else {
                for (int j = 0; j < b.size(); j++) {
                    if (j + 1 == map.get(halfX).size()) {
                        map.get(halfX).addAll(new ArrayList<>(b.subList(j, b.size())));
                        break;
                    }
                    int cnt = map.get(halfX).get(j + 1);
                    map.get(halfX).set(j + 1, cnt + b.get(j));
                }
            }
        }

        return String.valueOf(ans);
    }
}
/*
D2. Equalizing by Division (hard version)
https://codeforces.com/contest/1213/problem/D2

灵茶の试炼 2023-02-15
题目大意：
输入 n k (1≤k≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤2e5)。
每次操作你可以让一个 a[i] 变为 floor(a[i]/2)。
要想得到至少 k 个相同的数，最少需要多少次操作？

rating 1600
https://codeforces.com/contest/1213/submission/193430181
设 U=max(a)。
O(Ulog^2U) 或者 O(UlogU) 的做法是把每个 a[i] 变成 a[i]/2^j 的次数 j 存到 x=a[i]/2^j 里面。每个 x 都有一个列表去存储次数 j。
然后对每个 1~U 的数 x，累加列表中最小的 k 个次数，最小的和就是答案。
O(U) 的做法是从 U~1 倒着考虑数 x，每个 x 都有一个列表，列表的第 j 项记录有多少个数可以通过操作 j 次变为 x。
如果无法得到到 k 个 x，那么就把这个列表左边插入个 0，然后合并到 x/2 的列表中。
时间复杂度看上去是 O(UlogU)，但是 x 越大，列表的长度越短，仔细计算可以得到所有列表长度之和其实是 O(U) 的。
======

input
5 3
1 2 2 4 5
output
1

input
5 3
1 2 3 4 5
output
2

input
5 3
1 2 3 3 3
output
0
 */
