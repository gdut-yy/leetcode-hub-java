package p1593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class MainA {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        int[][] cases = new int[t][3];
        for (int i = 0; i < t; i++) {
            String[] lines = reader.readLine().split(" ");
            cases[i][0] = Integer.parseInt(lines[0]);
            cases[i][1] = Integer.parseInt(lines[1]);
            cases[i][2] = Integer.parseInt(lines[2]);
        }
        int[][] res = solution(cases);
        for (int i = 0; i < t; i++) {
            writer.write(res[i][0] + " " + res[i][1] + " " + res[i][2]);
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static int[][] solution(int[][] cases) {
        int[][] res = new int[cases.length][3];
        for (int i = 0; i < cases.length; i++) {
            int[] nums = cases[i];
            int max = Arrays.stream(nums).max().getAsInt();
            int a = nums[0];
            int b = nums[1];
            int c = nums[2];
            if (a == b && b == c) {
                res[i] = new int[]{1, 1, 1};
            } else if (a == b && a == max) {
                res[i] = new int[]{1, 1, max - c + 1};
            } else if (b == c && b == max) {
                res[i] = new int[]{max - a + 1, 1, 1};
            } else if (a == c && a == max) {
                res[i] = new int[]{1, max - b + 1, 1};
            } else if (a == max) {
                res[i] = new int[]{0, max - b + 1, max - c + 1};
            } else if (b == max) {
                res[i] = new int[]{max - a + 1, 0, max - c + 1};
            } else if (c == max) {
                res[i] = new int[]{max - a + 1, max - b + 1, 0};
            }
        }
        return res;
    }
}
/*
5
0 0 0
10 75 15
13 13 17
1000 0 0
0 1000000000 0


1 1 1
66 0 61
5 5 0
0 1001 1001
1000000001 0 1000000001

5
2 2 2
2 2 3
2 2 1
1 2 2
3 2 2


a==b==c
a==b c
a b==c
a==c b
a b c

 */