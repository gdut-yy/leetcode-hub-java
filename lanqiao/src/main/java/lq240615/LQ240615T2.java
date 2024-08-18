package lq240615;

import java.util.Scanner;

public class LQ240615T2 {
    static long n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long sqrtN = (long) Math.sqrt(n);
        return sqrtN * sqrtN == n ? "L" : "Q";
    }
}
/*
宣读数字【算法赛】

假设 n 的因子个数为 x，当 x 为偶数显然先手必胜，奇数时先手必败。
我们只需要知道 n 的因子个数即可，由于因子都是成对出现的，所以只有完全平方数是奇数个因子。
判断 n 是否为完全平方数即可。
 */