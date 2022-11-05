package p1744;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                res = i;
            }
        }
        if (res == -1) {
            System.out.println(res);
        } else {
            System.out.println(res + 1);
        }
    }
}
