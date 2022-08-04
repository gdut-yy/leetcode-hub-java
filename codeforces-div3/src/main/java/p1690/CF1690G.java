package p1690;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CF1690G {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line = reader.readLine();
            String line1 = reader.readLine();
            String[] line1s = line1.split(" ");
            int n = Integer.parseInt(line1s[0]);
            int m = Integer.parseInt(line1s[1]);
            String line2 = reader.readLine();
            String[] lineM = new String[m];
            for (int j = 0; j < m; j++) {
                lineM[j] = reader.readLine();
            }
            writer.write(solution(n, m, line2, lineM).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, int m, String line2, String[] lineM) {
        String[] line2s = line2.split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line2s[i]);
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (treeSet.isEmpty() || a[i] < a[treeSet.last()]) {
                treeSet.add(i);
            }
        }

        List<String> resList = new ArrayList<>();
        for (String line : lineM) {
            String[] lines = line.split(" ");
            int k = Integer.parseInt(lines[0]);
            int d = Integer.parseInt(lines[1]);
            k -= 1;
            a[k] -= d;

            Integer pre = treeSet.lower(k);
            if (pre == null || a[k] < a[pre]) {
                treeSet.add(k);
                for (Integer suf = treeSet.higher(k); suf != null && a[suf] >= a[k]; suf = treeSet.higher(k)) {
                    treeSet.remove(suf);
                }
            }
            resList.add(String.valueOf(treeSet.size()));
        }
        return String.join(" ", resList);
    }
}
/*
G. Count the Trains
https://codeforces.com/contest/1690/problem/G

题目大意：
给定整数 n,m 和 n 个整数 a, ai 表示带有数字 i 的车厢速度为 ai，车厢的速度不能超过前面的车厢。m 行，每行两个整数 k 和 d，代表 ak 下降 d 速度。
求每次降速后，火车的列数。

单调集合，二分替换。
======

input
3

4 2
6 2 3 7
3 2
4 7

5 4
10 13 5 2 6
2 4
5 2
1 5
3 2

13 4
769 514 336 173 181 373 519 338 985 709 729 702 168
12 581
6 222
7 233
5 117

output
3 4
4 4 2 3
5 6 6 5
 */