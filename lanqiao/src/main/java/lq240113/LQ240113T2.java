package lq240113;

import java.util.Scanner;

public class LQ240113T2 {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        // 0 全在左侧
        long ans1 = getAns('0');
        // 1 全在左侧
        long ans2 = getAns('1');
        long ans = Math.min(ans1, ans2);
        return String.valueOf(ans);
    }

    static long getAns(char ch) {
        long ans = 0, cnt1 = 0;
        for (char c : s) {
            if (c == ch) cnt1++;
            else ans += cnt1;
        }
        return ans;
    }
}
/*
聪明的交换策略【算法赛】

相似题目: 2938. 区分黑球与白球
https://leetcode.cn/problems/separate-black-and-white-balls/description/
 */