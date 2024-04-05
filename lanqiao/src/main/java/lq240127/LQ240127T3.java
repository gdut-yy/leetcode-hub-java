package lq240127;

import java.util.Scanner;

public class LQ240127T3 {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        return n % 2 == 1 ? "A" : "B";
    }
}
/*
玩游戏【算法赛】

偶数分 n 堆，B 赢

结论是 n 为偶数小 B 必胜，否则必败。
证明：若 n 为偶数，则将器分为 n 堆，每堆一个石子。因此博弈过程就是从小 A 开始轮流取，显然最后一个石子是小 B 取走的，因此小 B 必胜。
若 n 为奇数，假设将石子分为了 m 堆：a_1,a_2,...,a_m，其中  {\textstyle \sum_{i=1}^{m}} a_i = n，则根据 Nim 游戏结论，小 B 获胜（后手获胜）的条件是 a_1 \oplus a_2 \oplus ... \oplus a_m = 0。其中 表示异或运算。
考虑异或运算加法运算对结果二进制为最后一位的影响，会发现相同的数加法和异或的结果的二进制最后一位相同，因此奇偶性相同。因此既然 a_1 + a_2 + ... + a_m 是一个奇数，那么一定构造不出 = 0。因此小 A 必胜。
 */