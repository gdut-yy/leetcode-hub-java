package p1701;

import java.util.Arrays;
import java.util.Scanner;

public class CF1701E {
    static int n, m;
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            s = scanner.next().toCharArray();
            t = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static final int INF = (int) 1e9;

    private static String solve() {
        long[][] f = new long[n + 1][3];
        long[][] nf = new long[n + 1][3];
        f[0][0] = 1;
        for (int i = 0; i < s.length; i++) {
            char x = s[i];
            if (i < m) {
                Arrays.fill(f[i + 1], INF);
            }
            nf[0][0] = f[0][0] + 2;
            nf[0][1] = nf[0][0];
            nf[0][2] = f[0][2] + 1;
            for (int j = 0; j < Math.min(i + 1, m); j++) {
                char y = t[j];
                nf[j + 1][0] = f[j + 1][0] + 2;
                nf[j + 1][1] = nf[j + 1][0];
                nf[j + 1][2] = Math.min(f[j + 1][2] + 1, nf[j + 1][0]);
                if (x == y) {
                    nf[j + 1][0] = Math.min(nf[j + 1][0], f[j][0] + 1);
                    nf[j + 1][1] = Math.min(nf[j + 1][1], f[j][1]);
                    nf[j + 1][2] = Math.min(nf[j + 1][2], Math.min(f[j][2] + 1, f[j][1]));
                }
            }
//            f, nf = nf, f
            long[][] temp = f.clone();
            f = nf.clone();
            nf = temp;
        }
        long ans = f[m][2];
        if (ans > n) {
            ans = -1;
        }
        return String.valueOf(ans);
    }
}
/*
E. Text Editor
https://codeforces.com/contest/1701/problem/E

灵茶の试炼 2025-05-16
题目大意：
输入 T(≤5000) 表示 T 组数据。所有数据的 n 之和 ≤5000。
每组数据输入 n m(1≤m≤n≤5000)，长为 n 的字符串 s 和长为 m 的字符串 t，只包含小写英文字母。
文本编辑器中有一个字符串 s，现在光标在 s 末尾字母的右侧。
有五个按键，功能与电脑键盘一致：
1. ←：光标向左移动一位。
2. →：光标向右移动一位。
3. Home：光标移到 s 首字母的左侧。
4. End：光标移到 s 末尾字母的右侧。
5. Backspace：删除光标左侧相邻字母。
输出把 s 变成 t 的最少按键次数（操作次数）。
如果无法做到，输出 -1。（注意我们只能删除字母，不能添加字母）

rating 2500
首先，「光标移到文本」开头至多做一次。首尾反复横跳纯属浪费。
这样可以用状态机 DP。
把 s 分成左中右三段：
0. 左：「光标移到文本开头」之后的操作。
1. 中：不做任何操作。这一段必须与 t（的某一段）完全一样。
2. 右：「光标移到文本开头」之前的操作。
定义 f[i+1][j+1][k=0/1/2] 表示 s[0]~s[i] 变成 t[0]~t[j] 的最少操作次数。k 的含义如上文所述。
首先，无论 s[i] 和 t[j] 是否相等，都可以删除 s[i]。
为什么相等也可能要删？比如 s=abb, t=ab，删只要一次操作；如果不删，删前面的 b，需要两次操作。
我们有：
f[i+1][j+1][0] = f[i][j+1][0] + 2。删除一个字母需要先右移光标，再删除。
f[i+1][j+1][1] = f[i+1][j+1][0]。由于有删除操作，直接去 k=0 的状态删除。（这里说“去”是从递归的角度思考的）
f[i+1][j+1][2] = min(f[i][j+1][2]+1, f[i+1][j+1][0])。要么直接删，要么去 k=0 的状态删除。
如果 s[i] = t[j]，我们有：
f[i+1][j+1][0] = f[i][j][0] + 1。右移光标。
f[i+1][j+1][1] = f[i][j][1]。不做任何操作。
f[i+1][j+1][2] = min(f[i][j][2]+1, f[i][j][1])。左移光标，或者去 k=1 的状态。（注：对应到实际操作，这相当于光标移到文本开头。）
删和不删两种情况取 min。
初始值：
f[0][0][0] = 1，f[0][0][1] = f[0][0][2] = 0。光标移到文本开头需要一次操作。
f[i][i+1][k] = inf。s 比 t 短，无法把 s 变成 t。
以下三个对应 j=-1 的情况，同删除。
f[i+1][0][0] = f[i][0][0] + 2
f[i+1][0][1] = f[i+1][0][0]
f[i+1][0][2] = f[i][0][2] + 1
答案：f[n][m][2]。一开始光标在 s 末尾。
如果答案 = inf，输出 -1。
代码实现时，可以用两个数组滚动，优化空间。
代码 https://codeforces.com/contest/1701/submission/316756247
代码备份（洛谷）
======

Input
6
9 4
aaaaaaaaa
aaaa
7 3
abacaba
aaa
5 4
aabcd
abcd
4 2
abba
bb
6 4
baraka
baka
8 7
question
problem
Output
5
6
3
4
4
-1
 */
