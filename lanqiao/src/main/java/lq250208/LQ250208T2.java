package lq250208;

import java.util.Arrays;
import java.util.Scanner;

public class LQ250208T2 {
    static int n;
    static char[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = scanner.next().toCharArray();
        b = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);
        reverseSort(b);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a[i] ^ b[i];
        }
        return String.valueOf(ans);
    }

    static void reverseSort(char[] arr) {
        Arrays.sort(arr);
        for (int l = 0, r = arr.length - 1; l < r; l++, r--) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
    }
}
/*
对联【算法赛】
 */