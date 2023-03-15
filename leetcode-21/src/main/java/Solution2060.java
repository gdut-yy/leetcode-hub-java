import java.util.Arrays;

public class Solution2060 {
    private String s1;
    private String s2;
    private int m;
    private int n;
    private int[][][][] memo;

    public boolean possiblyEquals(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        m = s1.length();
        n = s2.length();
        memo = new int[41][41][2][1000];
        for (int i = 0; i < 41; i++) {
            for (int j = 0; j < 41; j++) {
                for (int k = 0; k < 2; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }

        return dfs(0, 0, 0, 0) != 0;
    }

    int dfs(int i, int j, int which, int rest) {
        // 记忆化
        if (memo[i][j][which][rest] != -1) {
            return memo[i][j][which][rest];
        }

        if (which == 0) {
            if (j == n) {
                return memo[i][j][which][rest] = (i == m && rest == 0) ? 1 : 0;
            } else if (Character.isLowerCase(s2.charAt(j))) {
                if (rest == 0 && i != m && Character.isLowerCase(s1.charAt(i))) {
                    return memo[i][j][which][rest] = (s1.charAt(i) == s2.charAt(j) ? dfs(i + 1, j + 1, 0, 0) : 0);
                } else {
                    return memo[i][j][which][rest] = (rest >= 1 ? dfs(i, j + 1, 0, rest - 1) : dfs(i, j + 1, 1, 1));
                }
            } else {
                int x = 0, k = j;
                while (k < n && Character.isDigit(s2.charAt(k))) {
                    x = x * 10 + (s2.charAt(k) - '0');
                    if ((rest >= x && dfs(i, k + 1, 0, rest - x) != 0) || (rest < x && dfs(i, k + 1, 1, x - rest) != 0)) {
                        return memo[i][j][which][rest] = 1;
                    }
                    ++k;
                }
                return memo[i][j][which][rest] = 0;
            }
        } else {
            if (i == m) {
                return memo[i][j][which][rest] = (j == n && rest == 0) ? 1 : 0;
            } else if (Character.isLowerCase(s1.charAt(i))) {
                if (rest == 0 && j != n && Character.isLowerCase(s2.charAt(j))) {
                    return memo[i][j][which][rest] = (s1.charAt(i) == s2.charAt(j) ? dfs(i + 1, j + 1, 0, 0) : 0);
                } else {
                    return memo[i][j][which][rest] = (rest >= 1 ? dfs(i + 1, j, 1, rest - 1) : dfs(i + 1, j, 0, 1));
                }
            } else {
                int x = 0;
                int k = i;
                while (k < m && Character.isDigit(s1.charAt(k))) {
                    x = x * 10 + (s1.charAt(k) - '0');
                    if ((rest >= x && dfs(k + 1, j, 1, rest - x) != 0) || (rest < x && dfs(k + 1, j, 0, x - rest) != 0)) {
                        return memo[i][j][which][rest] = 1;
                    }
                    k++;
                }
                return memo[i][j][which][rest] = 0;
            }
        }
    }
}
/*
2060. 同源字符串检测
https://leetcode.cn/problems/check-if-an-original-string-exists-given-two-encoded-strings/

原字符串由小写字母组成，可以按下述步骤编码：
- 任意将其 分割 为由若干 非空 子字符串组成的一个 序列 。
- 任意选择序列中的一些元素（也可能不选择），然后将这些元素替换为元素各自的长度（作为一个数字型的字符串）。
- 重新 顺次连接 序列，得到编码后的字符串。
例如，编码 "abcdefghijklmnop" 的一种方法可以描述为：
- 将原字符串分割得到一个序列：["ab", "cdefghijklmn", "o", "p"] 。
- 选出其中第二个和第三个元素并分别替换为它们自身的长度。序列变为 ["ab", "12", "1", "p"] 。
- 重新顺次连接序列中的元素，得到编码后的字符串："ab121p" 。
给你两个编码后的字符串 s1 和 s2 ，由小写英文字母和数字 1-9 组成。如果存在能够同时编码得到 s1 和 s2 原字符串，返回 true ；否则，返回 false。
注意：生成的测试用例满足 s1 和 s2 中连续数字数不超过 3 。
提示：
1 <= s1.length, s2.length <= 40
s1 和 s2 仅由数字 1-9 和小写英文字母组成
s1 和 s2 中连续数字数不超过 3
 */