package c293;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc293_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int k = scanner.nextInt();
        int[] x = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            x[i] = scanner.nextInt();
        }
        System.out.println(solve(k, x));
    }

    private static String solve(int k, int[] x) {
        boolean[] used = new boolean[k + 1];
        for (int i = 1; i <= k; i++) {
            if (!used[i]) {
                used[x[i]] = true;
            }
        }

        List<Integer> resList = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            if (!used[i]) {
                resList.add(i);
            }
        }
        return resList.size() + System.lineSeparator()
                + resList.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B - Call the ID Number
https://atcoder.jp/contests/abc293/tasks/abc293_b

题目大意：
有 N 个人，他们的 id 分别是 1, 2,...,N。
人员 1, 人员 2, ..., 人员 N 中的每个人按此顺序执行以下操作一次:
- 如果用户 i 的 ID 还没有被呼出，则呼出用户 Ai 的 ID。
以升序顺序枚举直到最后才调用 id 的所有人员的 id。

遍历，标记。
======

Input 1
5
3 1 4 5 4
Output 1
2
2 4

Input 2
20
9 7 19 7 10 4 13 9 4 8 10 15 16 3 18 19 12 13 2 12
Output 2
10
1 2 5 6 8 11 14 17 18 20
 */