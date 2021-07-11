public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        // 横向扫描
        for (int i = 1; i < strs.length; i++) {
            // 若已经为空串，返回结果
            if ("".equals(res)) {
                return "";
            } else {
                res = strs[i].length() == 0 ? "" : getLongestCommonPrefix(res, strs[i]);
            }
        }
        return res;
    }

    private String getLongestCommonPrefix(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        int curLen = 0;
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            curLen++;
        }
        return str1.substring(0, curLen);
    }
}
/*
14. 最长公共前缀
https://leetcode-cn.com/problems/longest-common-prefix/

查找字符串数组中的最长公共前缀。三种方法：
横向扫描 时间复杂度O(mn) 空间复杂度O(1)
纵向扫描 时间复杂度O(mn) 空间复杂度O(1)
排序后首位元素的公共前缀 复杂度相当于排序的复杂度 O(nlogn)（容易理解但效率不高）
 */