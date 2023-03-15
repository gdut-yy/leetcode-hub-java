import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionO38 {
    public String[] permutation(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        List<String> resList = new ArrayList<>();
        dfs(resList, chars, len, 0);
        return resList.toArray(String[]::new);
    }

    private void dfs(List<String> resList, char[] chars, int len, int curI) {
        if (curI == len) {
            resList.add(new String(chars));
        } else {
            Set<Character> hashSet = new HashSet<>();
            for (int i = curI; i < len; i++) {
                if (!hashSet.contains(chars[i])) {
                    hashSet.add(chars[i]);
                    swap(chars, curI, i);
                    dfs(resList, chars, len, curI + 1);
                    swap(chars, curI, i);
                }
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }
}
/*
剑指 Offer 38. 字符串的排列
https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/

输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

相似题目: 面试题 08.08. 有重复字符串的排列组合
https://leetcode.cn/problems/permutation-ii-lcci/
 */