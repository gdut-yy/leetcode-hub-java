public class Solution1910 {
    public String removeOccurrences(String s, String part) {
        if (s.contains(part)) {
            return removeOccurrences(s.replace(part, ""), part);
        } else {
            return s;
        }
    }
}
/*
1910. 删除一个字符串中所有出现的给定子字符串
https://leetcode-cn.com/problems/remove-all-occurrences-of-a-substring/

第 55 场双周赛 T2。
删除完的字符串作为新的入参，递归迭代到不在出现为止。注意 String#replace、String#replaceAll、String#replaceFirst 的区别。
 */