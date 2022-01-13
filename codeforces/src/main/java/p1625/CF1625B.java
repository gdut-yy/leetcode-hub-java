package p1625;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CF1625B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String line = reader.readLine();
            writer.write(solution(n, line).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, String line) {
        String[] lines = line.split(" ");
        Map<String, List<Integer>> idxListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> idxList = idxListMap.getOrDefault(lines[i], new ArrayList<>());
            idxList.add(i);
            idxListMap.put(lines[i], idxList);
        }

        int max = -1;
        for (List<Integer> idxList : idxListMap.values()) {
            int size = idxList.size();
            if (size > 1) {
                for (int i = 1; i < size; i++) {
                    int pre = idxList.get(i - 1);
                    int cur = idxList.get(i);
                    int len = getLen(n, pre, cur);
                    max = Math.max(max, len);
                }
            }
        }
        return String.valueOf(max);
    }

    private static int getLen(int n, int idx1, int idx2) {
        int right1 = n - 1 - idx1;
        int right2 = n - 1 - idx2;
        return Math.min(idx1, idx2) + Math.min(right1, right2) + 1;
    }
}
/*
B. Elementary Particles
https://codeforces.com/contest/1625/problem/B

题目大意：
给出整数 n和长度为 n 的数组 ai，选取两段不同的 [l1,r1]，使得 [l2,r2] 中的某个 i 相等（a[l1+i] == a[l2+i]）
r1-l1 == r2-l2 == k，求最长的 k。

枚举每个合法的 i，长度 k 可以看成 （左 + 1 + 右），那么 左 = min(l1,l2)，右 = min(r1,r2)
时间复杂度 O(n)
===

input
4
7
3 1 5 2 1 3 4
6
1 1 1 1 1 1
6
1 4 2 8 5 7
2
15 15

output
4
5
-1
1
 */