package p1669;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1669A {
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
        int rating = Integer.parseInt(line);
        if (rating <= 1399) {
            return "Division 4";
        } else if (rating <= 1599) {
            return "Division 3";
        } else if (rating <= 1899) {
            return "Division 2";
        } else {
            return "Division 1";
        }
    }
}
/*
Codeforces Round #784 (Div. 4)
A. Division?
https://codeforces.com/contest/1669/problem/A

题目大意：
给定 rating，求对应 Division
For Division 1: 1900≤rating
For Division 2: 1600≤rating≤1899
For Division 3: 1400≤rating≤1599
For Division 4: rating≤1399
======

input
7
-789
1299
1300
1399
1400
1679
2300

output
Division 4
Division 4
Division 4
Division 4
Division 3
Division 2
Division 1
 */