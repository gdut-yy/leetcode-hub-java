public class Solution1234 {
    public int balancedString(String s) {
        int n = s.length();
        int[] cntArr = new int[4];
        for (char ch : s.toCharArray()) {
            cntArr[id(ch)]++;
        }
        int part = n / 4;
        if (check(cntArr, part)) {
            return 0;
        }

        int min = n;
        int l = 0, r = 0;
        while (r < n) {
            cntArr[id(s.charAt(r))]--;
            while (check(cntArr, part)) {
                min = Math.min(min, r - l + 1);
                cntArr[id(s.charAt(l))]++;
                l++;
            }
            r++;
        }
        return min;
    }

    private int id(char ch) {
        if (ch == 'Q') return 0;
        else if (ch == 'W') return 1;
        else if (ch == 'E') return 2;
        else return 3;
    }

    private boolean check(int[] cntArr, int part) {
        return cntArr[0] <= part && cntArr[1] <= part && cntArr[2] <= part && cntArr[3] <= part;
    }
}
/*
1234. 替换子串得到平衡字符串
https://leetcode.cn/problems/replace-the-substring-for-balanced-string/

有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
请返回待替换子串的最小可能长度。
如果原字符串自身就是一个平衡字符串，则返回 0。
提示：
1 <= s.length <= 10^5
s.length 是 4 的倍数
s 中只含有 'Q', 'W', 'E', 'R' 四种字符

双指针 滑动窗口
 */