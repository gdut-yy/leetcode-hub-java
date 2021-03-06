package p1676;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CF1676F {
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
        String[] line1s = line1.split(" ");
        int n = Integer.parseInt(line1s[0]);
        int k = Integer.parseInt(line1s[1]);

        Map<Integer, Integer> cntMap = new HashMap<>();
        String[] line2s = line2.split(" ");
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(line2s[i]);
            cntMap.put(a, cntMap.getOrDefault(a, 0) + 1);
        }

        Set<Integer> numSet = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() >= k) {
                numSet.add(entry.getKey());
            }
        }

        int longestStreak = 0;
        String ans = "-1";
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                    ans = (currentNum - currentStreak + 1) + " " + currentNum;
                }
            }
        }
        return ans;
    }
}
/*
F. Longest Strike
https://codeforces.com/contest/1676/problem/F

???????????????
??????????????? n ????????? a ??????????????? k????????????????????? [l,r]?????? [l,r] ?????????????????????????????? k ????????? r-l ????????????????????????????????? -1???

HashMap ???????????????????????????????????? k ??? ????????????
???????????? 128. ??????????????????
https://leetcode.cn/problems/longest-consecutive-sequence/
O(n) ????????????????????????????????????????????? O(n)???
======

input
4
7 2
11 11 12 13 13 14 14
5 1
6 3 5 2 1
6 4
4 3 4 3 3 4
14 2
1 1 2 2 2 3 3 3 3 4 4 4 4 4

output
13 14
1 3
-1
1 4
 */