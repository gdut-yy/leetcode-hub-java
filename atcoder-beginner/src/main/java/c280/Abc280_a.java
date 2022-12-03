package c280;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Abc280_a {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String[] line1s = reader.readLine().split(" ");
        int H = Integer.parseInt(line1s[0]);
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            String s = reader.readLine();
            for (char ch : s.toCharArray()) {
                if (ch == '#') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
/*
A - Pawn on a Grid
https://atcoder.jp/contests/abc280/tasks/abc280_a

计数
 */