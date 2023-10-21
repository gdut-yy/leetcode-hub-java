package nc65507;

import java.util.Arrays;
import java.util.Scanner;

public class NC65507E {
    static int n;
    static int[] t, a, count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        t = new int[n];
        a = new int[n];
        count = new int[3];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            a[i] = scanner.nextInt();
            t[i] = (s.equals("ice") ? 0 : s.equals("fire") ? 1 : 2);
        }
        System.out.println(solve());
    }

    // https://ac.nowcoder.com/acm/contest/view-submission?submissionId=64004467
    private static String solve() {
        long ans = 0;
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            count[t[i]]++;
            ans += a[i];
            maxCnt = Math.max(maxCnt, count[t[i]]);
        }

        int k = Math.min(n / 2, n - maxCnt);
        Arrays.sort(a);
        for (int i = 0; i < k; i++) {
            ans += a[n - 1 - i];
        }
        return String.valueOf(ans);
    }
}
/*
小红打boss
https://ac.nowcoder.com/acm/contest/65507/E

题目描述
小红在一个 rpg 游戏准备去击杀 boss。已知小红一共有 n 种技能，每种技能拥有一种属性（冰、火、雷中的一种），并且有一个伤害。每种技能只能释放一次。
已知一个技能对 boss 释放时，会有以下三种情况：
1. 如果 boss 目前没有任何属性，则为 boss 附上该技能的属性。技能的伤害不变。
2. 如果 boss 目前被附上的属性和技能的属性相同，那么被附上的层数加 1。技能的伤害不变。
3. 如果 boss 目前被附上的属性和技能的属性不同，那么消耗一层 boss 被附上的属性，并且该技能伤害翻倍。
已知 boss 初始没有被附上任何属性。小红可以自由安排技能的释放顺序，她希望最终对 boss 的伤害最大化。请你帮小红设计一个技能释放次序。
输入描述:
第一行输入一个正整数 n ，代表小红拥有的技能数量。
接下来的 n 行，每行输入一个字符串 str 和一个正整数 ai，代表每个技能的属性和伤害。
1≤n≤10^5
1≤ai≤10^9
str 保证是 "ice" 、 "fire" 、 "thunder"中的一种。
输出描述:
输出一个正整数，代表小红对 boss 能造成的最大伤害。

贪心，统计最大频次
======

示例1
输入
5
fire 3
thunder 2
ice 5
fire 4
thunder 3
输出
26
说明
按照 2 3 5 4 1 的攻击顺序，总伤害为 2+5*2+3+4*2+3=26
 */