import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Meituan001 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int T = Integer.parseInt(reader.readLine());
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            inputs.add(reader.readLine());
        }
        for (String input : inputs) {
            // 如果用户名合法，请输出 "Accept"，反之输出 "Wrong"。
            writer.write(solution(input) ? "Accept" : "Wrong");
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

    private static boolean solution(String str) {
        return PATTERN.matcher(str).matches();
    }
}
/*
meituan-001. 小美的用户名
https://leetcode-cn.com/problems/BaR9fy/

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
 */