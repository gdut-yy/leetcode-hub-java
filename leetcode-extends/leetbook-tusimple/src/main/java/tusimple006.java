import java.io.PrintWriter;
import java.util.Scanner;

public class tusimple006 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        String s = scanner.nextLine();
        int ans = 0;
        boolean inNumber = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                if (!inNumber) {
                    ans++;
                    inNumber = true;
                }
            } else {
                inNumber = false;
            }
        }

        out.println(ans);
    }
}
/*
tusimple-006. 信息过滤
https://leetcode.cn/problems/1axZPc/description/

作为一个即将成为自动驾驶工程师的人，TuTu 正在自己学习信息过滤的一些方法。
TuTu 现在接到了一个提取信息的任务。他将得到一个由小写字母和数字组成的字符串，现在他需要得到在这个字符串中有多少数出现。
具体来说，就是将字符串中的所有字母都看作是空白字符，统计出现的数的个数（即使在不同的位置出现了两个完全一样的数，也会被认为是一次新的出现），当然连结在一起的数字会被看作是同一个数。
输入描述:
输入一行，包含一个字符串 S （S.length <= 100）且仅由小写字母和数字组成。
输出描述:
输出一行一个整数，表示出现的数的个数。
样例1
输入 abc123abc1a3a1 输出 4
备注:
对于其中 40% 的数据，保证出现的所有数都是单个的数字。
 */