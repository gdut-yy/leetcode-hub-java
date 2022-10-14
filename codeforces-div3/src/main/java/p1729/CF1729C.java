package p1729;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class CF1729C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();

            List<String> res = solve(s);
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static List<String> solve(String s) {
        int len = s.length();
        char begin = s.charAt(0);
        char end = s.charAt(len - 1);

        TreeMap<Character, List<Integer>> idxListTreeMap = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            idxListTreeMap.computeIfAbsent(ch, key -> new ArrayList<>()).add(i + 1);
        }

        List<String> orderList = new ArrayList<>();
        int cost;
        if (begin == end) {
            cost = 0;
            List<Integer> idxList = idxListTreeMap.get(begin);
            for (int id : idxList) {
                orderList.add(String.valueOf(id));
            }
        } else if (begin < end) {
            cost = end - begin;
            // 小到大
            char ch = begin;
            while (ch <= end) {
                List<Integer> idxList = idxListTreeMap.get(ch);
                for (int id : idxList) {
                    orderList.add(String.valueOf(id));
                }

                Character higherKey = idxListTreeMap.higherKey(ch);
                if (higherKey == null) {
                    break;
                }
                ch = higherKey;
            }
        } else {
            cost = begin - end;
            // 大到小
            char ch = begin;
            while (ch >= end) {
                List<Integer> idxList = idxListTreeMap.get(ch);
                for (int id : idxList) {
                    orderList.add(String.valueOf(id));
                }

                Character lowerKey = idxListTreeMap.lowerKey(ch);
                if (lowerKey == null) {
                    break;
                }
                ch = lowerKey;
            }
        }

        List<String> resList = new ArrayList<>();
        resList.add(cost + " " + orderList.size());
        resList.add(String.join(" ", orderList));
        return resList;
    }
}
/*
C. Jumping on Tiles
https://codeforces.com/contest/1729/problem/C

题目大意：
给定字符串 s。Polycarp 在一行的第一个瓦片上，想通过跳到瓦片上到达最后一个瓦片。跳跃代价为 |index(si)−index(sj)|，求最小成本的最大跳跃次数。

贪心。最小成本即为第一个瓦片直接跳最后一个瓦片，
如果 index(1) < index(n)，结果为 [index(1), index(n)] 的非递减路径；
如果 index(1) > index(n)，结果为 [index(1), index(n)] 的非递增路径；
如果 index(1) = index(n)，结果为 index(1) 的字符个数；
======

input
6
logic
codeforces
bca
aaaaaaaaaaa
adbaadabad
to

output
9 4
1 4 3 5
16 10
1 8 3 4 9 5 2 6 7 10
1 2
1 3
0 11
1 8 10 4 3 5 7 2 9 6 11
3 10
1 9 5 4 7 3 8 6 2 10
5 2
1 2
 */