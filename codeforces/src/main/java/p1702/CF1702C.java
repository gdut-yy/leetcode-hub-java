package p1702;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CF1702C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            reader.readLine();
            String[] lines = reader.readLine().split(" ");
            int n = Integer.parseInt(lines[0]);
            int k = Integer.parseInt(lines[1]);
            String lineU = reader.readLine();
            String[] lineKs = new String[k];
            for (int j = 0; j < k; j++) {
                lineKs[j] = reader.readLine();
            }
            String[] res = solution(n, k, lineU, lineKs);
            for (String re : res) {
                writer.write(re.concat(System.lineSeparator()));
            }
        }
        writer.close();
        reader.close();
    }

    private static String[] solution(int n, int k, String lineU, String[] lineKs) {
        String[] lineUs = lineU.split(" ");
        Map<Integer, LinkedList<Integer>> idxListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int u = Integer.parseInt(lineUs[i]);
            idxListMap.computeIfAbsent(u, key -> new LinkedList<>()).add(i);
        }

        String[] res = new String[k];
        for (int i = 0; i < k; i++) {
            String[] lineK = lineKs[i].split(" ");
            int a = Integer.parseInt(lineK[0]);
            int b = Integer.parseInt(lineK[1]);
            if (!idxListMap.containsKey(a) || !idxListMap.containsKey(b)) {
                res[i] = "NO";
            } else {
                int firstA = idxListMap.get(a).getFirst();
                int lastB = idxListMap.get(b).getLast();
                res[i] = (firstA < lastB) ? "YES" : "NO";
            }
        }
        return res;
    }
}
/*
C. Train and Queries
https://codeforces.com/contest/1702/problem/C

题目大意：
给定整数 n、k 和长为 n 的数组 ui，k 行 ai bi，ui 表示火车路线，求每组 ai bi 是否成立

预处理下标数组，比较 ai 第一个下标 i，bi 最后一个下标 j，是否满足 i < j 即可。
======

input
3

6 3
3 7 1 5 1 4
3 5
1 7
3 10

3 3
1 2 1
2 1
1 2
4 5

7 5
2 1 1 1 2 4 4
1 3
1 4
2 1
4 1
1 2

output
YES
NO
NO
YES
YES
NO
NO
YES
YES
NO
YES
 */