package meituan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * meituan-001. 小美的用户名
 * https://leetcode.cn/problems/BaR9fy/
 */
public class Meituan001 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        // input
        int T = Integer.parseInt(reader.readLine());
        String[] ss = new String[T];
        for (int i = 0; i < T; i++) {
            ss[i] = reader.readLine();
        }

        // solution
        String[] res = solution(ss);

        // output
        for (String re : res) {
            writer.write(re);
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    /**
     * 1.用户名的首字符必须是大写或者小写字母。
     * 2.用户名只能包含大小写字母，数字。
     * 3.用户名需要包含至少一个字母和一个数字。
     */
    private final static Pattern PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z]*[0-9]{1}[a-zA-Z0-9]*");

    private static String[] solution(String[] ss) {
        String[] res = new String[ss.length];
        for (int i = 0; i < ss.length; i++) {
            res[i] = PATTERN.matcher(ss[i]).matches() ? "Accept" : "Wrong";
        }
        return res;
    }
}
/*
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