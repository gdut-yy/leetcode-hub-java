package c292;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc292_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[][] events = new int[q][2];
        for (int i = 0; i < q; i++) {
            events[i][0] = scanner.nextInt();
            events[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, q, events));
    }

    private static String solve(int n, int q, int[][] events) {
        List<String> resList = new ArrayList<>();
        boolean[][] peoples = new boolean[n][3];
        for (int[] event : events) {
            int c = event[0];
            int x = event[1] - 1;
            if (c == 1) {
                if (!peoples[x][0]) {
                    peoples[x][0] = true;
                } else {
                    peoples[x][1] = true;
                }
            } else if (c == 2) {
                peoples[x][1] = true;
            } else if (c == 3) {
                resList.add(peoples[x][1] ? "Yes" : "No");
            }
        }
        return String.join(System.lineSeparator(), resList);
    }
}
/*
B - Yellow and Red Card
https://atcoder.jp/contests/abc292/tasks/abc292_b
 */