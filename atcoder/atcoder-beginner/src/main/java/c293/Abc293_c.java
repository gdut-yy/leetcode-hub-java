package c293;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc293_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        int res = 0;
        // 往右 w-1 步，往下 h-1 步，一共走 k 步
        int k = (w - 1) + (h - 1);
        for (int mask = 0; mask < 1 << k; mask++) {
            if (Integer.bitCount(mask) != w - 1) {
                continue;
            }
            int cx = 0, cy = 0;
            Set<Integer> visited = new HashSet<>();
            visited.add(a[cx][cy]);
            boolean flag = true;
            for (int i = 0; i < k; i++) {
                // 1 向右，0 向下
                if ((mask >> i & 1) == 1) {
                    cy++;
                    if (!visited.contains(a[cx][cy])) {
                        visited.add(a[cx][cy]);
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    cx++;
                    if (!visited.contains(a[cx][cy])) {
                        visited.add(a[cx][cy]);
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                res++;
            }
        }
        System.out.println(res);
    }
}
/*
C - Make Takahashi Happy
https://atcoder.jp/contests/abc293/tasks/abc293_c

状态压缩枚举
 */