import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionI0808 {
    public String[] permutation(String S) {
        List<String> resList = new ArrayList<>();
        char[] chars = S.toCharArray();
        int len = chars.length;
        dfs(resList, chars, len, 0);
        return resList.toArray(new String[0]);
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
面试题 08.08. 有重复字符串的排列组合
https://leetcode-cn.com/problems/permutation-ii-lcci/

有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
输入：S = "qqe"
输出：["eqq","qeq","qqe"]

相似题目: 47. 全排列 II
https://leetcode-cn.com/problems/permutations-ii/
注意 int[] 数组和 char[] 的区别
 */