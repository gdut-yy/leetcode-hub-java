package c294;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Abc294_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        long L = scanner.nextLong();
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        long[][] v1 = new long[n1][2];
        for (int i = 0; i < n1; i++) {
            v1[i][0] = scanner.nextLong();
            v1[i][1] = scanner.nextLong();
        }
        long[][] v2 = new long[n2][2];
        for (int i = 0; i < n2; i++) {
            v2[i][0] = scanner.nextLong();
            v2[i][1] = scanner.nextLong();
        }
        System.out.println(solve(L, n1, n2, v1, v2));
    }

    private static String solve(long L, int n1, int n2, long[][] vl1, long[][] vl2) {
        Set<Long> split = new HashSet<>();

        long idx = -1L;
        TreeMap<Long, Long> v1TreeMap = new TreeMap<>();
        for (long[] vl : vl1) {
            idx += vl[1];
            split.add(idx);
            v1TreeMap.put(idx, vl[0]);
        }

        idx = -1L;
        TreeMap<Long, Long> v2TreeMap = new TreeMap<>();
        for (long[] vl : vl2) {
            idx += vl[1];
            split.add(idx);
            v2TreeMap.put(idx, vl[0]);
        }
        List<Long> list = new ArrayList<>(split);
        Collections.sort(list);

        long preId = -1L;
        long ans = 0L;
        for (long id : list) {
            long v1 = v1TreeMap.ceilingEntry(id).getValue();
            long v2 = v2TreeMap.ceilingEntry(id).getValue();
            if (v1 == v2) {
                ans += id - preId;
            }
            preId = id;
        }
        return String.valueOf(ans);
    }
}
/*
E - 2xN Grid
https://atcoder.jp/contests/abc294/tasks/abc294_e

题目大意：
我们有一个 2 行 L 列的网格。设(i,j)表示自上起第 i 行(i∈{1,2})和自左起第 j 列(1≤j≤L)处的正方形。(i,j)上面写着整数 xi,j。
求满足 x1j = x2j 的整数个数。
在这里，对 xij 的描述是将(x11,x12,...,x1L)和(x21,x22,...,x2L)的运行长度压缩为长度为 n1 和 n2 的序列，分别为:((v11,L11),..,(v1N1,l1N1))和((v21,l21),...,(v2N2,l2N2))。
这里，序列 A 的运行长度压缩是 A 的元素 vi 和正整数 li 的对(vi, li)序列，如下所示。
在每对相邻的元素之间分割 A。
对于分割后的每个序列 B1, B2,...,Bk，设 vi 为 Bi 的元素，li 为 Bi 的长度。

预处理出所有分割点。再对判断每个区间的元素是否相等，相等则对区间长度进行累加。
======

Input
8 4 3
1 2
3 2
2 3
3 1
1 4
2 1
3 3
Output
4

Input
10000000000 1 1
1 10000000000
1 10000000000
Output
10000000000

Input
1000 4 7
19 79
33 463
19 178
33 280
19 255
33 92
34 25
19 96
12 11
19 490
33 31
Output
380
 */