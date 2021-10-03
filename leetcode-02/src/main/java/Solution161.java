public class Solution161 {
    public boolean isOneEditDistance(String s, String t) {
        int firstLen = s.length();
        int secondLen = t.length();
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
                if (s.charAt(p1) != t.charAt(p2)) {
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
            // 编辑距离为 0 不满足
            if (s.equals(t)) {
                return false;
            }
            int choice = 1;
            for (int i = 0; i < firstLen; i++) {
                if (s.charAt(i) != t.charAt(i)) {
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
$161. 相隔为 1 的编辑距离
https://leetcode-cn.com/problems/one-edit-distance/

给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。
注意：
满足编辑距离等于 1 有三种可能的情形：
- 往 s 中插入一个字符得到 t
- 从 s 中删除一个字符得到 t
- 在 s 中替换一个字符得到 t
 */