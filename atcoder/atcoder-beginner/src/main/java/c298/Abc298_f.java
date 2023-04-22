package c298;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc298_f {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();

        Map<Integer, Map<Integer, Integer>> rcxMap = new HashMap<>();
        Map<Integer, Long> rSumMap = new HashMap<>();
        Map<Integer, Long> cSumMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int x = scanner.nextInt();

            Map<Integer, Integer> cxMap = rcxMap.getOrDefault(r, new HashMap<>());
            cxMap.put(c, x);
            rcxMap.put(r, cxMap);

            rSumMap.put(r, rSumMap.getOrDefault(r, 0L) + x);
            cSumMap.put(c, cSumMap.getOrDefault(c, 0L) + x);
        }

        List<Node> cNodeList = new ArrayList<>();
        for (Map.Entry<Integer, Long> entry : cSumMap.entrySet()) {
            cNodeList.add(new Node(entry.getKey(), entry.getValue()));
        }
        cNodeList.sort((o1, o2) -> Long.compare(o2.sum, o1.sum));

        long max = 0L;
        for (int r : rSumMap.keySet()) {
            for (Node node : cNodeList) {
                int c = node.id;
                if (rcxMap.get(r).containsKey(c)) {
                    max = Math.max(max, rSumMap.get(r) + cSumMap.get(c) - rcxMap.get(r).get(c));
                } else {
                    max = Math.max(max, rSumMap.get(r) + cSumMap.get(c));
                    break;
                }
            }
        }
        System.out.println(max);
    }

    private static class Node {
        int id;
        long sum;

        public Node(int id, long sum) {
            this.id = id;
            this.sum = sum;
        }
    }
}
/*
F - Rook Score
https://atcoder.jp/contests/abc298/tasks/abc298_f

题目大意：
我们有一个 1e9 行 1e9 列的网格。设(i,j)表示从上到下第 i 行和从左到第 j 列的正方形。
对于 i=1,2,...,N，一个正整数 xi 写在(ri, ci)上。在另外 10 个 18−N 个方格上，写 0。
你选择一个正方形(R,C)，并计算写在 2×10 9−1 个正方形上的整数的和 S，这些正方形与(R,C)共享一行或一列。
求 S 的最大可能值。

离散化
选择不对应于给定 N 平方的任何 y 坐标的 R 并不能改善答案，同样适用于 C 和 x;所以我们可以做坐标压缩，在 N × N(或更小)的网格上考虑问题。
对于给定的(R,C)， S 等于“(写在第 R 行上的整数之和)+(写在第 C 列上的整数之和)-(写在(R,C)上的整数)”。我们记住这个，我们穷尽地寻找 R。
我们基本上可以选择 C 使第 C 列的整数和最大化。特别是，如果(R,C)不在输入中，选择一个不使和最大化的列并不能改善 s。
如果(R,C)在输入中，情况并不总是这样，所以我们应该检查第二个。如果 C 的(R,C)仍然包含在输入中，我们应该看到第三个，…，等等。
然而，无论何时(R,C)不在输入中，选择一个和小于它的列并不会改善 S，所以你可以停在这里。直到停止的迭代在 R=1,2，…，N 上总共最多重复 O(N)次，因此上述算法找到答案的速度足够快。
======

Input
4
1 1 2
1 2 9
2 1 8
3 2 3
Output
20

Input
1
1 1000000000 1
Output
1

Input
15
158260522 877914575 602436426
24979445 861648772 623690081
433933447 476190629 262703497
211047202 971407775 628894325
731963982 822804784 450968417
430302156 982631932 161735902
880895728 923078537 707723857
189330739 910286918 802329211
404539679 303238506 317063340
492686568 773361868 125660016
650287940 839296263 462224593
492601449 384836991 191890310
576823355 782177068 404011431
818008580 954291757 160449218
155374934 840594328 164163676
Output
1510053068
 */