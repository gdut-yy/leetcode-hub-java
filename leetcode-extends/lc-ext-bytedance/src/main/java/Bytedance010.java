import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Bytedance010 {
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
        String line = scanner.next();
        line = line.substring(1, line.length() - 1);
        String[] lines = line.split(",");
        Arrays.sort(lines, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        out.println(String.join("", lines));
    }
}
/*
bytedance-010. 数组组成最大数
https://leetcode.cn/problems/9nsGSS/

给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
示例 1：
输入：[10,1,2]
输出：2110
示例 2：
输入：[3,30,34,5,9]
输出：9534330
 */