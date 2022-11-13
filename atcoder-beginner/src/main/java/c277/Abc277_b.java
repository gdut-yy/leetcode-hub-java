package c277;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc277_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = scanner.next();
        }

        System.out.println(solve(N, strings));
    }

    private static String solve(int N, String[] strings) {
        Set<String> hashSet = new HashSet<>();
        for (String string : strings) {
            char ch0 = string.charAt(0);
            if (ch0 != 'H' && ch0 != 'D' && ch0 != 'C' && ch0 != 'S') {
                return "No";
            }
            char ch1 = string.charAt(1);
            if (ch1 != 'A' && ch1 != '2' && ch1 != '3' && ch1 != '4' && ch1 != '5'
                    && ch1 != '6' && ch1 != '7' && ch1 != '8' && ch1 != '9'
                    && ch1 != 'T' && ch1 != 'J' && ch1 != 'Q' && ch1 != 'K') {
                return "No";
            }
            hashSet.add(string);
        }
        if (hashSet.size() != N) {
            return "No";
        }
        return "Yes";
    }
}
/*
B - Playing Cards Validation
https://atcoder.jp/contests/abc277/tasks/abc277_b
 */