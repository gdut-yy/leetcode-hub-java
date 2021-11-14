package p1593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MainB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        String[] testcases = new String[t];
        for (int i = 0; i < t; i++) {
            testcases[i] = reader.readLine();
            writer.write(String.valueOf(solution(testcases[i])));
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static int solution(String testcase) {
        if (testcase.endsWith("00") || testcase.endsWith("25") || testcase.endsWith("50") || testcase.endsWith("75")) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        String reverse = new StringBuilder(testcase).reverse().toString();
        int indexOf0 = reverse.indexOf("0");
        if (indexOf0 > -1) {
            int indexOf00 = reverse.substring(indexOf0 + 1).indexOf("0");
            int indexOf05 = reverse.substring(indexOf0 + 1).indexOf("5");
            if (indexOf00 > -1) {
                res = Math.min(res, indexOf0 + indexOf00);
            }
            if (indexOf05 > -1) {
                res = Math.min(res, indexOf0 + indexOf05);
            }
        }
        int indexOf5 = reverse.indexOf("5");
        if (indexOf5 > -1) {
            int indexOf52 = reverse.substring(indexOf5 + 1).indexOf("2");
            int indexOf57 = reverse.substring(indexOf5 + 1).indexOf("7");
            if (indexOf52 > -1) {
                res = Math.min(res, indexOf5 + indexOf52);
            }
            if (indexOf57 > -1) {
                res = Math.min(res, indexOf5 + indexOf57);
            }
        }
        return res;
    }
}
/*
5
100
71345
3259
50555
2050047

1
2050047


0
3
1
3
2

 */