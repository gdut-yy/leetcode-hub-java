import java.io.PrintWriter;
import java.util.Scanner;

public class Youdao001 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        long[] a = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
            total += a[i];
        }
        // Two equal contiguous parts => total must be even and there must be
        // a contiguous arc (shorter than the whole ring) whose sum is half.
        if ((total & 1L) != 0) {
            out.println("NO");
            return;
        }
        long target = total / 2;
        long sum = 0;
        int left = 0;
        for (int right = 0; right < 2 * n; right++) {
            sum += a[right % n];
            while (sum > target && left <= right) {
                sum -= a[left % n];
                left++;
            }
            // All values are positive, so a proper arc has length <= n - 1.
            if (sum == target && right - left + 1 <= n - 1) {
                out.println("YES");
                return;
            }
        }
        out.println("NO");
    }
}
/*
分割环
https://leetcode.cn/leetbook/read/ai-ydzy/9x55t7/

小易有 n 个数字排成一个环，你能否将它们分成连续的两个部分(即在环上必须连续)，使得两部分的和相等？
输入描述：
第一行数据组数 T ，对于每组数据
第一行数字 n ，表示数字个数
接下来一行 n 个数，按顺序给出环上的数字。
2 <= n <= 100000, 1 <= Ai <= 10 ^ 9
输出描述：
对于每组数据，一行输出YES/NO
示例1:
输入
1
6
1 2 3 4 5 6
输出
NO
示例2:
输入
1
4
4 4 5 3
输出
YES
 */