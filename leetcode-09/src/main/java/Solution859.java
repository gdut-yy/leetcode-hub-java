import java.util.Arrays;

public class Solution859 {
    public boolean buddyStrings(String s, String goal) {
        int len = s.length();
        // 长度不等或者长度小于 2 的不看
        if (len != goal.length() || len < 2) {
            return false;
        }
        // A 和 B 仅由小写字母构成。用长为 26 的一维数组统计字符频次
        int[] sCntArr = new int[26];
        int[] goalCntArr = new int[26];
        for (int i = 0; i < len; i++) {
            sCntArr[s.charAt(i) - 'a']++;
            goalCntArr[goal.charAt(i) - 'a']++;
        }
        // 频次不等的不可能相等
        if (!Arrays.equals(sCntArr, goalCntArr)) {
            return false;
        }
        // 如果字符串本身相等，必须存在重复字符
        if (s.equals(goal)) {
            for (int sCnt : sCntArr) {
                if (sCnt > 1) {
                    return true;
                }
            }
        }
        // 如果字符串不相等，不等的字符数必须等于 2
        else {
            int unEquals = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    unEquals++;
                }
            }
            return unEquals == 2;
        }
        return false;
    }
}
/*
859. 亲密字符串
https://leetcode-cn.com/problems/buddy-strings/
 */