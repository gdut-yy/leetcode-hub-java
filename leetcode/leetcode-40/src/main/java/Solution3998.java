import java.util.ArrayList;
import java.util.List;

public class Solution3998 {
    public boolean[] transformStr(String s, String[] strs) {
        int n = s.length();
        List<Integer> sZeroPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                sZeroPos.add(i);
            }
        }
        int totZeros = sZeroPos.size();
        int m = strs.length;
        boolean[] ans = new boolean[m];
        for (int q = 0; q < m; q++) {
            String t = strs[q];
            int fixedZeros = 0;
            int questionMarks = 0;
            for (int i = 0; i < n; i++) {
                char c = t.charAt(i);
                if (c == '0') fixedZeros++;
                else if (c == '?') questionMarks++;
            }
            int needZeros = totZeros - fixedZeros;
            if (needZeros < 0 || needZeros > questionMarks) {
                ans[q] = false;
                continue;
            }
            int[] tZeroPos = new int[totZeros];
            int idx = 0;
            int qMarkAssigned = 0;
            for (int i = 0; i < n; i++) {
                char c = t.charAt(i);
                if (c == '0') {
                    tZeroPos[idx++] = i;
                } else if (c == '?') {
                    if (qMarkAssigned < needZeros) {
                        tZeroPos[idx++] = i;
                    }
                    qMarkAssigned++;
                }
            }
            boolean ok = true;
            for (int k = 0; k < totZeros; k++) {
                if (tZeroPos[k] > sZeroPos.get(k)) {
                    ok = false;
                    break;
                }
            }
            ans[q] = ok;
        }
        return ans;
    }
}
/*
3998. 使用子序列排序转换二进制字符串
https://leetcode.cn/problems/transform-binary-string-using-subsequence-sort/description/

第 511 场周赛 T3。

给你一个二进制字符串 s。
另给定一个字符串数组 strs，其中每个 strs[i] 的长度都与 s 相同，并且仅由字符 '0'、'1' 和 '?' 组成。每个 '?' 都可以替换为 '0' 或 '1'。
你可以执行以下操作任意次（也可以不执行）：
- 选择 s 的任意一个 子序列 sub。
- 将 sub 按 非递减 顺序排序。
- 用排序后的 sub 替换 s 中被选中的 子序列，其余字符保持不变。
返回一个布尔数组 ans。如果可以将 strs[i] 中的所有 '?' 替换为 '0' 或 '1'，并使用上述操作将 s 转换为替换后的字符串，则 ans[i] 为 true；否则为 false。
子序列 是指通过删除一个序列中的某些元素或不删除任何元素，并且不改变剩余元素相对顺序后得到的序列。
提示：
1 <= n == s.length <= 2000
s[i] 为 '0' 或 '1'。
1 <= strs.length <= 2000
strs[i].length == n
strs[i] 仅由 '0'、'1' 和 '?' 组成。

贪心 + 双指针。
时间复杂度 O(nm)。
 */