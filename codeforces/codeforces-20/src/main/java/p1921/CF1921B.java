package p1921;

import java.util.Scanner;

public class CF1921B {
    static int n;
    static char[] s, f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            f = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int cnt10 = 0, cnt01 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == f[i]) continue;
            if (s[i] == '1' && f[i] == '0') {
                cnt10++;
            } else {
                cnt01++;
            }
        }
        int ans = Math.max(cnt10, cnt01);
        return String.valueOf(ans);
    }
}
/*
B. Arranging Cats
https://codeforces.com/contest/1921/problem/B

题目大意：
为了验证关于猫的假设，科学家们必须将猫以特定的方式排列在盒子里。当然，他们想要验证这个假设，并尽快发表一篇耸人听闻的文章，因为他们太专注于下一个关于手机电池电量的假设。
科学家们有 n 个盒子，猫可能会坐在里面，也可能不会。设盒子的当前状态用序列 b1，…，bn 表示:如果第 i 号盒子里有一只猫，则 bi=1，否则 bi=0。
幸运的是，猫的无限量生产已经建立，所以在一天内，科学家们可以进行以下操作之一:
- 取一只新猫，把它放在一个盒子里(对于某些 i, bi=0，赋值 bi=1)。
- 从盒子里取出一只猫，让它退休(对于某些 i, bi=1，赋值 bi=0)。
- 将一只猫从一个盒子移到另一个盒子(对于某些 i,j，使得 bi=1,bj=0，赋值 bi=0,bj=1)。
人们还发现，一些盒子里立即装满了猫。因此，科学家们知道猫在盒子 s1，…，sn 中的初始位置和理想位置 f1，…，fn。
由于大量的文书工作，科学家们没有时间来解决这个问题。为了科学的缘故，帮助他们，并指出检验假设所需的最少天数。

贪心。
======

input
6
5
10010
00001
1
1
1
3
000
111
4
0101
1010
3
100
101
8
10011001
11111110
output
2
0
3
2
1
4
 */
