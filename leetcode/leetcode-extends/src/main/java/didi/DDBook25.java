package didi;

import java.io.PrintWriter;
import java.util.Scanner;

public class DDBook25 {
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
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        char[] str = s.toCharArray();

        // 计算 Z 数组，大小 n+1，Z[n] = 0
        int[] Z = new int[n + 1];
        Z[0] = n;
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                Z[i] = Math.min(r - i + 1, Z[i - l]);
            }
            while (i + Z[i] < n && str[Z[i]] == str[i + Z[i]]) {
                Z[i]++;
            }
            if (i + Z[i] - 1 > r) {
                l = i;
                r = i + Z[i] - 1;
            }
        }
        Z[n] = 0;

        // 差分数组，用于标记满足条件的前缀长度
        int[] diff = new int[n + 2];

        for (int p = 1; p <= n; p++) {
            long low = (long) k * p;
            if (low > n) break;  // 后续 p 更大，low 只会更大
            long high = (long) (k + 1) * p;
            high = Math.min(high, (long) p + Z[p]);
            high = Math.min(high, n);
            if (low <= high) {
                diff[(int) low] += 1;
                diff[(int) high + 1] -= 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += diff[i];
            if (sum > 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        out.println(sb);
    }
}
/*
切割字符串
https://leetcode.cn/leetbook/read/didiglobal2/e78fwr/

我们称一个乱序排列的字符串为乱码，既然有乱码，与之相对应的也有优美的字符串。X 组织定义了一种优美的字符串符合以下条件:
字符串可以做如下拆分:S=A+B+A+B+A+...+A，共有 k+1 个 A 和 k 个 B，k 将给出，A，B 均为一个字符串，两者均可以为空。即，S=A+A+ ...+A(k+1个A)，或 S=B+B+...+B(k个B)也是优美的。
格式：
输入：
- 输入第一行是两个正整数 n，k，分别表示给出的字符串的长度，和题目的参数。
- 输入第二行是 1 个长度为 n 的仅由小写字母组成的字符串。
输出：
- 输出为一个长度为 n 的仅由 0 和 1 构成字符串，字符串的第 i 位为 1 表示字符串前 i 个字符构成的子串是优美的，反之第 i 位输出 0。
示例：
输入：
     8 3
     sysysytm
输出：00000100
提示：
1 <= n, k <= 100000
 */
