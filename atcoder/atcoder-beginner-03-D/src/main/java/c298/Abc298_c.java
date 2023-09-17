package c298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Abc298_c {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        Map<Integer, TreeMap<Integer, Integer>> boxCardMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> cardBoxMap = new HashMap<>();
        while (q-- > 0) {
            int op = scanner.nextInt();
            if (op == 1) {
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                TreeMap<Integer, Integer> treeMap = boxCardMap.getOrDefault(j, new TreeMap<>());
                treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
                boxCardMap.put(j, treeMap);

                cardBoxMap.computeIfAbsent(i, key -> new TreeSet<>()).add(j);
            } else if (op == 2) {
                int i = scanner.nextInt();
                TreeMap<Integer, Integer> treeMap = boxCardMap.get(i);
                StringBuilder stringBuilder = new StringBuilder();
                for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                    int k = entry.getKey(), v = entry.getValue();
                    for (int j = 0; j < v; j++) {
                        stringBuilder.append(k).append(" ");
                    }
                }
                System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
            } else {
                int i = scanner.nextInt();
                System.out.println(cardBoxMap.get(i).stream().map(String::valueOf).collect(Collectors.joining(" ")));
            }
        }
    }

    private static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
C - Cards Query Problem
https://atcoder.jp/contests/abc298/tasks/abc298_c

题目大意：
我们有 N 个编号为 1 到 N 的盒子，它们最初是空的，还有无限数量的空白卡片。
按顺序处理 Q 个查询。有如下三种查询。
- 1 i j:把数字 i 写在一张空白卡片上，然后把它放进盒子 j 里。
- 2 i:请按升序报告第 i 栏卡片上写的所有数字。
- 3 i:按升序报告包含编号为 i 的卡片的所有盒号。
在这里，请注意以下几点。
- 在第 2 类查询中，如果盒子 i 包含多个具有相同数字的卡片，则该数字应被打印的次数等于这些卡片的数量。
- 在第 3 种查询中，即使一个盒子包含多个编号为 i 的卡片，该盒子的盒子号也应该只打印一次。

需要统计频次的用 TreeMap，否则用 TreeSet
======

Input
5
8
1 1 1
1 2 4
1 1 4
2 4
1 1 4
2 4
3 1
3 2
Output
1 2
1 1 2
1 4
4

Input
1
5
1 1 1
1 2 1
1 200000 1
2 1
3 200000
Output
1 2 200000
1
 */