package c279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Abc279_b {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String S = reader.readLine();
        String T = reader.readLine();
        System.out.println(S.contains(T) ? "Yes" : "No");
    }
}
/*
B - LOOKUP
https://atcoder.jp/contests/abc279/tasks/abc279_b
 */