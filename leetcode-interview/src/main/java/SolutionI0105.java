public class SolutionI0105 {
    public boolean oneEditAway(String first, String second) {
        int firstLen = first.length();
        int secondLen = second.length();
        int disLen = Math.abs(firstLen - secondLen);
        // 长度相差超过 1 无解
        if (disLen > 1) {
            return false;
        }
        // 长度相差 1 插入或删除
        else if (disLen == 1) {
            int p1 = 0;
            int p2 = 0;
            int choice = 1;
            while (p1 < firstLen && p2 < secondLen) {
                if (first.charAt(p1) != second.charAt(p2)) {
                    choice--;
                    if (firstLen < secondLen) {
                        p2++;
                    } else {
                        p1++;
                    }
                } else {
                    p1++;
                    p2++;
                }
                if (choice < 0) {
                    return false;
                }
            }
        }
        // 长度相等 替换
        else {
            // 空串相等
            if (firstLen == 0) {
                return true;
            }
            int choice = 1;
            for (int i = 0; i < firstLen; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    choice--;
                }
                if (choice < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
面试题 01.05. 一次编辑
https://leetcode-cn.com/problems/one-away-lcci/

双指针。分三种情况。
case1: 长度相差 > 1。无解
case2: 长度相差 = 1。双指针 + 一次机会
case3: 长度相等。逐位比较 + 一次机会
 */