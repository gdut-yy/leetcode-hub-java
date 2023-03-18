package c290;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Abc290_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int x : a) {
            treeSet.add(x);
        }
        Set<Integer> set = new HashSet<>();
        if (treeSet.size() > k) {
            for (int i = 0; i < k; i++) {
                set.add(treeSet.pollFirst());
            }
        } else {
            set.addAll(treeSet);
        }

        int sz = set.size();
        for (int i = 0; i <= sz; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
                return;
            }
        }
    }
}
/*
C - Max MEX
https://atcoder.jp/contests/abc290/tasks/abc290_c

这里，对于序列 X，我们定义 MEX(X)为唯一的非负整数 m，满足以下条件:
X 中包含 0≤i<m 的每一个整数 i。
m 不包含在 X 中。
相似题目: 2003. 每棵子树内缺失的最小基因值
https://leetcode.cn/problems/smallest-missing-genetic-value-in-each-subtree/
 */