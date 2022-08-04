package p1714;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CF1714C {
    private static final int[] TABLES = {
            0,
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            19,
            29,
            39,
            49,
            59,
            69,
            79,
            89,
            189,
            289,
            389,
            489,
            589,
            689,
            789,
            1789,
            2789,
            3789,
            4789,
            5789,
            6789,
            16789,
            26789,
            36789,
            46789,
            56789,
            156789,
            256789,
            356789,
            456789,
            1456789,
            2456789,
            3456789,
            13456789,
            23456789,
            123456789
    };

    public static void main(String[] args) {
//        printTables();
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int s = scanner.nextInt();
            System.out.println(TABLES[s]);
        }
    }

    private static void printTables() {
        int n = 9;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int state = 1; state < (1 << n); state++) {
            int sum = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 0; k < n; k++) {
                // 第 k 位被选中
                if (((state >> k) & 1) == 1) {
                    sum += k + 1;
                    stringBuilder.append(k + 1);
                }
            }
            int val = treeMap.getOrDefault(sum, 999999999);
            int newVal = Integer.parseInt(stringBuilder.toString());
            if (newVal < val) {
                treeMap.put(sum, newVal);
            }
        }
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getValue() + ",");
        }
    }
}
/*
C. Minimum Varied Number
https://codeforces.com/contest/1714/problem/C

题目大意：
给定整数 s，求给定数字和的最小数，使其所有数字都是不同的（即所有数字都是唯一的）

容易观察出和最大为 45，即 123456789，状态压缩打表即可。
======

input
4
20
8
45
10

output
389
8
123456789
19
 */