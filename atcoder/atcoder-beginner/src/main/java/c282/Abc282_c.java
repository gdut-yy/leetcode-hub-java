package c282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Abc282_c {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        int N = Integer.parseInt(reader.readLine());
        String S = reader.readLine();

        boolean inBlock = false;
        char[] chars = S.toCharArray();
        for (int i = 0; i < N; i++) {
            if (chars[i] == '"') {
                inBlock = !inBlock;
            }
            if (chars[i] == ',' && !inBlock) {
                chars[i] = '.';
            }
        }
        System.out.println(new String(chars));
    }
}
/*
C - String Delimiter
https://atcoder.jp/contests/abc282/tasks/abc282_c
 */