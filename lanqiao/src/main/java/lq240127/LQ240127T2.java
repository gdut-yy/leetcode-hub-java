package lq240127;

import java.util.Scanner;

public class LQ240127T2 {
    static int n;
    static String[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        for (String v : a) {
            ans += getCost(v);
        }
        return String.valueOf(ans);
    }

    static int getCost(String type) {
        if (type.equals("yuanxing")) return 1;
        else if (type.equals("zhengfangxing")) return 2;
        else if (type.equals("changfangxing")) return 3;
        else if (type.equals("sanjiaoxing")) return 4;
        else if (type.equals("tuoyuanxing")) return 5;
        else if (type.equals("liubianxing")) return 6;
        return 0;
    }
}
/*
自助餐【算法赛】

模拟。
 */