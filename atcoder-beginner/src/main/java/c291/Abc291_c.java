package c291;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc291_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();

        int x = 0, y = 0;
        Set<Long> set = new HashSet<>();
        set.add(0L);
        for (char ch : s.toCharArray()) {
            if (ch == 'R') {
                x++;
            } else if (ch == 'L') {
                x--;
            } else if (ch == 'U') {
                y++;
            } else {
                y--;
            }
            long val = x * 200005L + y;
            if (set.contains(val)) {
                System.out.println("Yes");
                return;
            } else {
                set.add(val);
            }
        }
        System.out.println("No");
    }
}
/*
C - LRUD Instructions 2
https://atcoder.jp/contests/abc291/tasks/abc291_c
 */