package p1619;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1619C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line = reader.readLine();
            writer.write(solution(line).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line) {
        String[] lines = line.split(" ");
        String aStr = lines[0];
        String sStr = lines[1];
        // 双指针
        int p1 = aStr.length() - 1;
        int p2 = sStr.length() - 1;
        // b
        StringBuilder stringBuilder = new StringBuilder();
        while (p2 >= 0) {
            int a = (p1 >= 0) ? aStr.charAt(p1) - '0' : 0;
            int s = sStr.charAt(p2) - '0';
            // a 中 1 个字符对应 s 中 1-2 个字符
            if (s >= a) {
                stringBuilder.append(s - a);
                p1--;
                p2--;
            } else {
                // 第 2 个字符必须为 1
                if (p2 - 1 >= 0 && sStr.charAt(p2 - 1) == '1') {
                    int sum = s + 10;
                    stringBuilder.append(sum - a);
                    p2 -= 2;
                    p1--;
                } else {
                    return "-1";
                }
            }
        }
        if (p1 >= 0) {
            return "-1";
        }
        String bStr = stringBuilder.reverse().toString();
        return String.valueOf(Long.parseLong(bStr));
    }
}
/*
C. Wrong Addition
https://codeforces.com/contest/1619/problem/C

6
17236 1106911
1 5
108 112
12345 1023412
1 11
1 20

3465
4
-1
90007
10
-1

 */