import java.util.HashSet;
import java.util.Set;

public class SolutionI0101 {
    public boolean isUnique(String astr) {
        Set<Character> hashSet = new HashSet<>();
        for (char ch : astr.toCharArray()) {
            if (!hashSet.contains(ch)) {
                hashSet.add(ch);
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

HashSet 判重。
 */