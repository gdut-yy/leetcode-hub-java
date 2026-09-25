import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Meituan001 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        String s = scanner.next();
        String res = PATTERN.matcher(s).matches() ? "Accept" : "Wrong";
        out.println(res);
    }

    /**
     * 1.用户名的首字符必须是大写或者小写字母。
     * 2.用户名只能包含大小写字母，数字。
     * 3.用户名需要包含至少一个字母和一个数字。
     */
    private final static Pattern PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z]*[0-9]{1}[a-zA-Z0-9]*");
}
/*
meituan-001. 小美的用户名
https://leetcode.cn/problems/BaR9fy/

小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，一个合法的用户名必须满足以下几个要求：
1.用户名的首字符必须是大写或者小写字母。
2.用户名只能包含大小写字母，数字。
3.用户名需要包含至少一个字母和一个数字。
如果用户名合法，请输出 "Accept"，反之输出 "Wrong"。
格式：
输入：
- 输入第一行包含一个正整数 T，表示需要检验的用户名数量。
- 接下来有 T 行，每行一个字符串 s，表示输入的用户名。
输出：
- 对于每一个输入的用户名 s，请输出一行，即按题目要求输出一个字符串。
示例：
输入：
5
Ooook
Hhhh666
ABCD
Meituan
6666
输出：
Wrong
Accept
Wrong
Wrong
Wrong
提示：
1 <= T <= 100
s 的长度不超过 20
 */