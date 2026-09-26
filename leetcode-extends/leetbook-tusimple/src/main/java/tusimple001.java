import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class tusimple001 {
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
        int m = scanner.nextInt();

        int cmax = 1 << m;
        int[] horizontal = new int[cmax];
        int[] vertical = new int[cmax];

        List<List<Integer>> subset = new ArrayList<>(cmax);
        for (int i = 0; i < cmax; i++) subset.add(new ArrayList<>());
        subset.get(0).add(0);

        for (int i = 1; i < cmax; i++) {
            int lowbit = i & -i;
            horizontal[i] = horizontal[i - lowbit] + ((((lowbit << 1) & i) == 0) ? 1 : 0);
            vertical[i] = vertical[i - lowbit] + 1;
            for (int j : subset.get(i - lowbit)) {
                subset.get(i).add(j | lowbit);
                subset.get(i).add(j);
            }
            subset.get(i).sort(Comparator.comparingInt(a -> vertical[a]));
        }

        int[] dp = new int[cmax];
        int ps = 0;

        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            int cs = 0;
            for (int k = 0; k < m; k++) {
                cs = (cs << 1) | (line.charAt(k) == '#' ? 1 : 0);
            }

            for (int ci : subset.get(cs & ps)) {
                int cans = dp[ci];
                int cj = ci;
                while (cj != 0) {
                    int lowbit = cj & -cj;
                    cj ^= lowbit;
                    int tmp = dp[ci ^ lowbit] + 1;
                    if (tmp < cans) cans = tmp;
                }
                dp[ci] = cans;
            }

            int ci = cs;
            int len = 1 << vertical[cs];
            for (int j = len - 1; j >= 0; j--) {
                ci = subset.get(cs).get(j);
                int pre = ci & ps;
                int cans = dp[pre] + vertical[pre ^ ci] + horizontal[ci ^ cs];
                int cj = ci ^ cs;
                while (cj != 0) {
                    int lowbit = cj & -cj;
                    cj ^= lowbit;
                    int tmp = dp[ci | lowbit];
                    if (tmp < cans) cans = tmp;
                }
                dp[ci] = cans;
            }
            ps = cs;
        }

        out.println(dp[0]);
    }
}
/*
tusimple-001. 抵御台风
https://leetcode.cn/problems/4whzea/description/

台风"烟花"预计将会严重影响上海，Tusimple 上海办公室决定全员居家办公一天，在离开前，需要关闭办公室内的窗户。
Tusimple 上海办公室大玻璃窗可以表示为具有 n 行和 m 列的矩形，其中每个位置都是一个正方形的小窗户。
很不巧的是，当时为了通风卸下了一些窗户，现在已经不知道被堆积到哪里了。所以 TuTu 被委派去用胶带封住所有开着的窗户。
TuTu 拿到的胶带宽度正好是一个窗户的大小（可以理解为，胶带正好可以封闭窗户），长度是无限的。当然为了解决使用资源，TuTu 会尽可能少的使用胶带，也就是对于每一个开着的窗户，TuTu 只会用一层胶带，而对于没有打开的窗户，一定不会使用任何胶带。
同时，为了封闭窗户的速度尽可能的快，TuTu 希望他尽可能少的切割胶带。所以 TuTu 每次可以切割下一条胶带并用它封住一些连续的（相邻）水平窗户、或者连续的（相邻）垂直窗户，使其不备台风侵袭。
现在 TuTu 想知道他最少需要切割下多少条胶带。
输入描述:
第一行包含两个整数 n 和 m (1<= n <= 1000, 1<= m <= 10)，代表大玻璃窗的大小。 接下来的 n 行中的每行均包含长度为 m 的字符串。字符串由字符 '.' 和 '#' 构成，其中 '.' 表示关闭的窗户，'#' 表示打开的窗户。
输出描述:
输出最少需要切割下多少条胶带可以让所有窗户封闭。
样例1:
输入:
3 5
#.#.#
#####
#.#.#
输出: 5
说明: A.C.E ABCDE A.C.E
A,B,C,D,E 分别表示五个胶带。
 */
