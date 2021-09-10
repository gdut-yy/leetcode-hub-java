import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * meituan-013. 偏爱字母
 * https://leetcode-cn.com/problems/pedXtA/
 */
public class Meituan013 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String line0 = reader.readLine();
        String line1 = reader.readLine();
        System.out.println(solution(line1));
    }

    private static int solution(String line) {
        int cnt = 0;
        int max = 0;
        for (char ch : line.toCharArray()) {
            if (ch == 'E') {
                cnt++;
            } else {
                cnt--;
                cnt = Math.max(0, cnt);
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
/*
小美喜欢字母 E ，讨厌字母 F 。在小美生日时，小团送了小美一个仅包含字母 E 和 F 的字符串，小美想从中选出
一个包含字母 E 数量与字母 F 数量之差最大的子串。

*子串：从字符串前面连续删去若干个字符，从后面连续删去若干个字符剩下的字符串（也可以一个都不删），例
如 abcab 是 fabcab 的子串，而不是 abcad 的子串。我们将空串看作所有字符串的子串。

格式：
输入：
- 第一行一个正整数 n 表示字符串的长度。
- 第二行长度为 n ，且仅包含大写字母 'E', 'F' 的字符串（不含引号）
输出：
- 输出一个整数，表示最大的差值。

示例：
输入：
5
EFEEF
输出：2
解释：
选择子串 EE ，此时有 2 个 E ，0 个 F ，有最大差值 2-0=2
另外，选择子串 EFEE 也可以达到最大差值。

提示：
对于 30% 的数据，n <= 300
对于 60% 的数据，n <= 3000
对于 100% 的数据，n <= 300000
 */