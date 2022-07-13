package p1702;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class CF1702F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            writer.write(solution(n, line1, line2).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, String line1, String line2) {
        Map<Integer, LinkedList<Integer>> aMap = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        String[] line1s = line1.split(" ");
        String[] line2s = line2.split(" ");
        for (int i = 0; i < n; i++) {
            int ai = Integer.parseInt(line1s[i]);
            int bi = Integer.parseInt(line2s[i]);
            while (ai % 2 == 0) {
                ai /= 2;
            }
            aMap.computeIfAbsent(ai, key -> new LinkedList<>()).add(i);
            priorityQueue.add(bi);
        }

        while (!priorityQueue.isEmpty()) {
            int bMax = priorityQueue.remove();
            if (aMap.containsKey(bMax)) {
                int size = aMap.get(bMax).size();
                if (size == 1) {
                    aMap.remove(bMax);
                } else {
                    aMap.get(bMax).removeLast();
                }
            } else {
                if (bMax == 1) {
                    return "NO";
                } else {
                    priorityQueue.add(bMax / 2);
                }
            }
        }
        return "YES";
    }
}

/*
F. Equate Multisets
https://codeforces.com/contest/1702/problem/F

题目大意：
给定整数 n 和长为 n 的数组 a 和 b，一次操作可将数组 b 某个元素 /2 或者 *2，问进行若干次操作能否将 b 变为与 a 相等

将 b *2 在 /2 结果不变，因此只需考虑 /2，同时对 a 中元素，偶数都可以由 b *2 得到，因此先将所有偶数 /2 预处理为奇数。
观察 b 最大的数，如果在 a 中存在，则从数组 a、b 中移除，如果大于 1 且 a 中不存在则尝试 /2，如果等于 1，无解。
======

input
5
4
2 4 5 24
1 4 6 11
3
1 4 17
4 5 31
5
4 7 10 13 14
2 14 14 26 42
5
2 2 4 4 4
28 46 62 71 98
6
1 2 10 16 64 80
20 43 60 74 85 99

output
YES
NO
YES
YES
YES
 */