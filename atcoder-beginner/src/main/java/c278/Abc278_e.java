package c278;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc278_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int N = scanner.nextInt();
        int h = scanner.nextInt();
        int w = scanner.nextInt();

        int k = 0;
        int[][] A = new int[H][W];
        int[] cnt = new int[N + 1];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int Ai = scanner.nextInt();
                A[i][j] = Ai;
                cnt[Ai]++;
                if (cnt[Ai] == 1) {
                    k++;
                }
            }
        }

        int[] cntAll = cnt.clone();
        int kAll = k;

        int resH = H - h + 1;
        int resW = W - w + 1;
        int[][] res = new int[resH][resW];

        for (int offset = 0; offset < resW; offset++) {
            cnt = cntAll.clone();
            k = kAll;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    int del = A[i][j + offset];
                    cnt[del]--;
                    if (cnt[del] == 0) {
                        k--;
                    }
                }
            }
            res[0][offset] = k;

            for (int i = 1; i < resH; i++) {
                for (int j = 0; j < w; j++) {
                    int add = A[i - 1][j + offset];
                    cnt[add]++;
                    if (cnt[add] == 1) {
                        k++;
                    }

                    int del = A[i + h - 1][j + offset];
                    cnt[del]--;
                    if (cnt[del] == 0) {
                        k--;
                    }
                }
                res[i][offset] = k;
            }
        }

        for (int i = 0; i < resH; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < resW; j++) {
                stringBuilder.append(res[i][j]).append(" ");
            }
            System.out.println(stringBuilder.toString().trim());
        }
    }
}
/*
E - Grid Filling
https://atcoder.jp/contests/abc278/tasks/abc278_e
 */