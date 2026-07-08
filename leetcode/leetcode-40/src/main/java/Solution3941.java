import java.util.HashSet;
import java.util.Set;

public class Solution3941 {
    public int passwordStrength(String password) {
        Set<Character> seen = new HashSet<>();
        int ans = 0;
        for (char c : password.toCharArray()) {
            if (seen.contains(c)) continue;
            seen.add(c);
            ans += getScore(c);
        }
        return ans;
    }

    private int getScore(char c) {
        if (Character.isLowerCase(c)) return 1;
        else if (Character.isUpperCase(c)) return 2;
        else if (Character.isDigit(c)) return 3;
        else if ("!@#$".indexOf(c) >= 0) return 5;
        return 0;
    }
}
/*
3941. 密码强度
https://leetcode.cn/problems/password-strength/description/

第 503 场周赛 T2。

给你一个字符串 password。
密码的 强度 按照以下规则计算：
- 每个不同的小写字母（'a' 到 'z'）计 1 分。
- 每个不同的大写字母（'A' 到 'Z'）计 2 分。
- 每个不同的数字（'0' 到 '9'）计 3 分。
- 每个来自集合 "!@#$" 的不同特殊字符计 5 分。
每个字符最多只贡献一次分数，即使它出现多次也是如此。
返回一个整数，表示该密码的强度。
提示：
1 <= password.length <= 10^5
password 由大小写英文字母、数字以及来自 "!@#$" 的特殊字符组成。

模拟。
时间复杂度 O(n)。
 */