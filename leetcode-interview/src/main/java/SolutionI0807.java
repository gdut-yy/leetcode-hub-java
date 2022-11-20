import java.util.ArrayList;
import java.util.List;

public class SolutionI0807 {
    public String[] permutation(String S) {
        List<String> resList = new ArrayList<>();
        char[] chars = S.toCharArray();
        int len = chars.length;
        dfs(resList, chars, len, 0);
        return resList.toArray(String[]::new);
    }

    private void dfs(List<String> resList, char[] chars, int len, int curI) {
        if (curI == len) {
            resList.add(new String(chars));
        }
        for (int i = curI; i < len; i++) {
            swap(chars, curI, i);
            dfs(resList, chars, len, curI + 1);
            swap(chars, curI, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }
}
/*
面试题 08.07. 无重复字符串的排列组合
https://leetcode.cn/problems/permutation-i-lcci/

无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
输入：S = "qwe"
输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]

相似题目: 46. 全排列
https://leetcode.cn/problems/permutations/
注意 int[] 数组和 char[] 的区别
 */