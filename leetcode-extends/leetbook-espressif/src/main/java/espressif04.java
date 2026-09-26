import java.io.PrintWriter;
import java.util.Scanner;

public class espressif04 {
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
        String[] s = new String[4];
        for (int j = 0; j < 4; j++) {
            s[j] = scanner.next();
        }
        int len = s[0].length();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int[] cnt = new int[256];
            for (int j = 0; j < 4; j++) {
                cnt[s[j].charAt(i)]++;
            }

            // 同一个字符多次出错不会错成同一个字符，
            // 因此某一位上出现次数不少于 2 的字符只可能是正确字符。
            int maxCount = 0;
            int maxChar = -1;
            int ties = 0;
            for (int c = 0; c < 256; c++) {
                if (cnt[c] == 0) {
                    continue;
                }
                if (cnt[c] > maxCount) {
                    maxCount = cnt[c];
                    maxChar = c;
                    ties = 1;
                } else if (cnt[c] == maxCount) {
                    ties++;
                }
            }
            if (maxCount >= 2 && ties == 1) {
                res.append((char) maxChar);
            } else {
                out.println("Input Error");
                return;
            }
        }
        out.println(res);
    }
}
/*
猴子打字
https://leetcode.cn/leetbook/read/espressif/5wtfrd/

有一只猴子学会了打字，但它不知道删除键，如果打错了，就不能修改。但猴子想到了好方法，打错一个字符就继续打下一个字符，但每个字符串都会打印 4 遍。幸运的是，同一个字符即使多次出错，也不会错成一样。请还原猴子输入的字符串。
输入描述:
每组输入包括 4 行。
每行一个字符串，字符串长度小于 1000 ，且不包含空白符号（空格符、回车符、制表符等），且每行字符串长度相同。
输出描述:
输出1行，为还原后的字符串，若存在某个字符4次输入不同，则无法还原，输出 Input Error。
示例1
输入
aBcdef
abCdef
abcDef
abcEef
输出
abcdef
 */
