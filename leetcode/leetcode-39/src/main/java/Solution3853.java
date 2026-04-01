import java.util.Arrays;

public class Solution3853 {
    private final static int INF = (int) 1e9;

    public String mergeCharacters(String s, int k) {
        int[] last = new int[26];
        Arrays.fill(last, -INF);

        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            // ch 在 ans 中的下标是 ans.length()
            if (ans.length() - last[ch - 'a'] > k) {
                last[ch - 'a'] = ans.length();
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
/*
3853. 合并靠近字符
https://leetcode.cn/problems/merge-close-characters/description/

第 177 场双周赛 T2。

给你一个由小写英文字母组成的字符串 s 和一个整数 k。
在 当前 字符串 s 中，如果两个 相同 字符之间的下标距离 至多 为 k，则认为它们是 靠近 的。
当两个字符 靠近 时，右侧的字符会合并到左侧。合并操作 逐个 发生，每次合并后，字符串都会更新，直到无法再进行合并为止。
返回执行所有可能合并后的最终字符串。
注意：如果可以进行多次合并，请始终选择 左侧下标最小 的那一对进行合并。如果多对字符共享最小的左侧下标，请选择 右侧下标最小 的那一对。
提示：
1 <= s.length <= 100
1 <= k <= s.length
s 由小写英文字母组成。

栈思想。
时间复杂度 O(n)。
 */