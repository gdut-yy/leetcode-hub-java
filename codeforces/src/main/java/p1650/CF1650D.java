package p1650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class CF1650D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            writer.write(solution(line1, line2).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line1, String line2) {
        int n = Integer.parseInt(line1);
        String[] line2s = line2.split(" ");

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(Integer.parseInt(line2s[i]));
        }

        // 模拟
        int[] res = new int[n];
        for (int i = n - 1; i > 0; i--) {
            while (linkedList.get(i) != i + 1) {
                int first = linkedList.removeFirst();
                linkedList.addLast(first);
                res[i]++;
            }
            linkedList.removeLast();
        }

        // LinkedList<Integer> => String
        StringBuilder stringBuilder = new StringBuilder();
        for (int re : res) {
            stringBuilder.append(re).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
/*
D. Twist the Permutation
https://codeforces.com/contest/1650/problem/D

题目大意：
首行给定整数 n 和 n 个数的数组 a，第 i 次操作可以选择前 i 个元素循环右移，可以进行若干次。问从 1 到 n 变成目标数组 a 需要的最少操作次数。

贪心，从结果进行反推模拟。
开始1 2 3 4 5 6
1: 1 2 3 4 5 6
2: 2 1 3 4 5 6
3: 3 2 1 4 5 6
4: 4 3 2 1 5 6
4: 1 4 3 2 5 6
6: 6 1 4 3 2 5
6: 5 6 1 4 3 2
6: 2 5 6 1 4 3
6: 3 2 5 6 1 4
=======

input
3
6
3 2 5 6 1 4
3
3 1 2
8
5 8 1 3 2 6 4 7

output
0 1 1 2 0 4
0 0 1
0 1 2 0 2 5 6 2
 */