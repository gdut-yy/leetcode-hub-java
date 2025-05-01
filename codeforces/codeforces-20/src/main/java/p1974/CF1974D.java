package p1974;

import java.util.Scanner;

public class CF1974D {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] w = new int['X'];
        w['W'] = 1;
        w['E'] = 1;
        for (int i = 0; i < n; i++) {
            char b = s[i];
            s[i] = "RH".charAt(w[b]);
            w[b] ^= 1;
        }
        int cnt_R = 0;
        for (char c : s) {
            if (c == 'R') cnt_R++;
        }
        if (cnt_R == 0 || cnt_R == n || w['N'] != w['S'] || w['W'] != w['E']) {
            return "NO";
        }
        return new String(s);
    }
}
/*
D. Ingenuity-2
https://codeforces.com/contest/1974/problem/D

灵茶の试炼 2025-02-18
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的字符串 s，只包含 NSEW 四种字母，表示北南东西四个方向。
有两个机器人，一开始都在坐标原点。
选择 s 中的某些字母分配给第一个机器人，其余字母分配给第二个机器人。
机器人按照字母方向移动，一个字母移动一个单位长度。
如何分配字母，可以让两个机器人最终在同一个位置？
注意：两个机器人都至少要走一步。
输出一个长为 n 的字符串 t，其中 t[i]='R' 表示 s[i] 分给了第一个机器人，t[i]='H' 表示 s[i] 分给了第二个机器人。
多解输出任意解。
如果无法做到，输出 NO。

rating 1400
写法有很多，这里说说怎么写比较简单。
设一共有 a 个 W（左）和 b 个 E（右）。
如果 a 和 b 的奇偶性不同，那么直接输出 NO。
如果 a=2,b=4，那么可以平均分配，每个机器人都往左走 a/2 步，往右走 b/2 步。
如果 a=3,b=5 呢？多出来的 1 步都给同一个机器人，这样两个人的横坐标仍然是相同的。
纵坐标同理。
实现的时候，可以用一个 who 数组记录当前轮到谁走，who[s[i]] = 0 表示 s[i] 给第一个机器人，who[s[i]] = 1 表示 s[i] 给第二个机器人。
走完之后把 who[s[i]] 取反，从而做到均匀分配。
为了保证两个机器人都至少走一步，可以初始化南北方向 who['N'] = who['S'] = 0，东西方向 who['E'] = who['W'] = 1。
最后再检查一遍：统计 'R' 的个数，判断两个机器人是否都至少走一步。
小技巧：通过判断最终 who['N'] = who['S'] 和 who['E'] = who['W'] 是否成立，来判断奇偶性（是否需要输出 NO）。
代码 https://codeforces.com/contest/1974/submission/304336576
代码备份（洛谷）
======

Input
10
6
NENSNE
3
WWW
6
NESSWS
2
SN
2
WE
4
SSNN
4
WESN
2
SS
4
EWNN
4
WEWE
Output
RRHRRH
NO
HRRHRH
NO
NO
RHRH
RRHH
RH
RRRH
RRHH
 */
