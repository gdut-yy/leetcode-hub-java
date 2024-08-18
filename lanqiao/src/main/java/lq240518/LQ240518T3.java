package lq240518;

import java.util.Scanner;

public class LQ240518T3 {
    static int x, y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        long ans = x + y + 1;
        return String.valueOf(ans);
    }
}
/*
小蓝方程【算法赛】

对于式子 a = n * a。比较显然的符合方式有两种：
- 第一种是当 n 等于 1 时，此时 a 取任何值均符合条件，此时答案个数为 X + 1。
- 第二种是当 a 等于 0 时，此时 a 取任何值均符合条件，此时答案个数为 Y + 1。
注意当 a 等于 0 且 n 等于 1 时，在以上两种情况中均被计算进答案，所以需要再减去 1。
即最终答案为 X + Y + 1。
 */