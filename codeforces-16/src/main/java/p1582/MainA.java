package p1582;

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
        for (int i = 0; i < t; i++) {
            String[] lineT = reader.readLine().split(" ");
            int res = solution(Integer.parseInt(lineT[0]), Integer.parseInt(lineT[1]), Integer.parseInt(lineT[2]));
            writer.write(String.valueOf(res));
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static int solution(int a, int b, int c) {
        int remainA = a % 2;
        int remainB = b % 2;
        int remainC = c % 2;
        // 0-0-0
        // 1-1-1
        int[] input = {remainA, remainB, remainC};
        //
        int[] a000 = {0, 0, 0}; // = 0
        int[] a001 = {0, 0, 1}; // 1-1-2 = 3+1 != 2+1 = 1
        int[] a010 = {0, 1, 0}; // 1-2-1 = 3+1 = 2+2 = 0
        int[] a011 = {0, 1, 1}; // = 1
        int[] a100 = {1, 0, 0}; // = 1
        int[] a101 = {1, 0, 1}; // 2-1-2 = 3+2 = 3+1+1 = 0
        int[] a110 = {1, 1, 0}; // = 1
        int[] a111 = {1, 1, 1}; // = 0
        if (Arrays.equals(input, a000) || Arrays.equals(input, a111)
                || Arrays.equals(input, a101) || Arrays.equals(input, a010)) {
            return 0;
        } else {
            return 1;
        }
    }
}
/*
4
1 1 1
2 1 3
5 5 5
1 1 2

0
1
0
1

 */