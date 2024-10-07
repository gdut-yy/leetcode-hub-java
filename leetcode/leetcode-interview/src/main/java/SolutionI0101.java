public class SolutionI0101 {
    public boolean isUnique(String astr) {
        int mask = 0;
        for (char c : astr.toCharArray()) {
            int j = c - 'a';
            if ((mask >> j & 1) == 0) {
                mask |= 1 << j;
            } else {
                return false;
            }
        }
        return true;
    }
}
/*
面试题 01.01. 判定字符是否唯一
https://leetcode.cn/problems/is-unique-lcci/

实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
限制：
0 <= len(s) <= 100
s[i]仅包含小写字母
如果你不使用额外的数据结构，会很加分。

位运算。& 性质
 */