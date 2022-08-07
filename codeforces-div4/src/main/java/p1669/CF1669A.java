package p1669;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1669A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int rating = scanner.nextInt();
            System.out.println(solve(rating));
        }
    }

    private static String solve(int rating) {
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