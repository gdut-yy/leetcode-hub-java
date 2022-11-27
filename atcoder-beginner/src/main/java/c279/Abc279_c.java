package c279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Abc279_c {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String[] line1s = reader.readLine().split(" ");
        int H = Integer.parseInt(line1s[0]);
        int W = Integer.parseInt(line1s[1]);
        String[] S = new String[H];
        for (int i = 0; i < H; i++) {
            S[i] = reader.readLine();
        }
        String[] T = new String[H];
        for (int i = 0; i < H; i++) {
            T[i] = reader.readLine();
        }
        System.out.println(solve(H, W, S, T));
    }

    private static String solve(int H, int W, String[] S, String[] T) {
        char[][] charsS = new char[H][W];
        char[][] charsT = new char[H][W];
        for (int i = 0; i < H; i++) {
            charsS[i] = S[i].toCharArray();
            charsT[i] = T[i].toCharArray();
        }
        Map<String, Integer> cntMap1 = new HashMap<>();
        Map<String, Integer> cntMap2 = new HashMap<>();
        for (int j = 0; j < W; j++) {
            StringBuilder stringBuilder1 = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (int i = 0; i < H; i++) {
                stringBuilder1.append(charsS[i][j]);
                stringBuilder2.append(charsT[i][j]);
            }
            String key1 = stringBuilder1.toString();
            String key2 = stringBuilder2.toString();
            cntMap1.put(key1, cntMap1.getOrDefault(key1, 0) + 1);
            cntMap2.put(key2, cntMap2.getOrDefault(key2, 0) + 1);
        }
        return cntMap1.equals(cntMap2) ? "Yes" : "No";
    }
}
/*
C - RANDOM
https://atcoder.jp/contests/abc279/tasks/abc279_c
 */