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
        System.out.println(resList.size());
        System.out.println(resList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
/*
B - Call the ID Number
https://atcoder.jp/contests/abc293/tasks/abc293_b
 */