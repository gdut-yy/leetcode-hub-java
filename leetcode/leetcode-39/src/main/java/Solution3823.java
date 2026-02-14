import java.util.ArrayList;
import java.util.List;

public class Solution3823 {
    public String reverseByType(String s) {
        List<Integer> letters = new ArrayList<>();
        List<Integer> special = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) letters.add(i);
            else special.add(i);
        }
        char[] ans = new char[n];
        int p1 = letters.size() - 1;
        int p2 = special.size() - 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                ans[i] = s.charAt(letters.get(p1--));
            } else {
                ans[i] = s.charAt(special.get(p2--));
            }
        }
        return new String(ans);
    }
}
/*
3823. 反转一个字符串里的字母后反转特殊字符
https://leetcode.cn/problems/reverse-letters-then-special-characters-in-a-string/description/

第 175 场双周赛 T1。

给你一个由小写英文字母和特殊字符组成的字符串 s。
你的任务是 按顺序 执行以下操作：
- 反转小写字母，并将它们放回原来字母所占据的位置。
- 反转特殊字符，并将它们放回原来特殊字符所占据的位置。
返回执行反转操作后的结果字符串。
提示：
1 <= s.length <= 100
s 仅由小写英文字母和 "!@#$%^&*()" 中的特殊字符组成。

双指针。
时间复杂度 O(n)。
 */