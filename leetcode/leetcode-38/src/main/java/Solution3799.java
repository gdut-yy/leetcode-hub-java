import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Solution3799 {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();

        // comb(15, 4) * 4!
        int n = words.length;
        for (int i = 0; i < 1 << n; i++) {
            if (Integer.bitCount(i) == 4) {
                List<String> snapshot = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if ((i >> j & 1) == 1) {
                        snapshot.add(words[j]);
                    }
                }
                dfs(ans, snapshot, 0);
            }
        }
        ans.sort((o1, o2) -> {
            int minLen = Math.min(o1.size(), o2.size());
            for (int i = 0; i < minLen; i++) {
                if (!Objects.equals(o1.get(i), o2.get(i))) {
                    return o1.get(i).compareTo(o2.get(i));
                }
            }
            return o1.size() - o2.size();
        });
        return ans;
    }

    private void dfs(List<List<String>> ans, List<String> snapshot, int curI) {
        if (curI == snapshot.size()) {
            char[] top = snapshot.get(0).toCharArray();
            char[] left = snapshot.get(1).toCharArray();
            char[] right = snapshot.get(2).toCharArray();
            char[] bottom = snapshot.get(3).toCharArray();
            if (top[0] == left[0] && top[3] == right[0] && bottom[0] == left[3] && bottom[3] == right[3]) {
                ans.add(new ArrayList<>(snapshot));
            }
        }
        for (int i = curI; i < snapshot.size(); i++) {
            Collections.swap(snapshot, curI, i);
            dfs(ans, snapshot, curI + 1);
            Collections.swap(snapshot, curI, i);
        }
    }
}
/*
3799. 单词方块 II
https://leetcode.cn/problems/word-squares-ii/description/

第 483 场周赛 T2。

给你一个字符串数组 words，包含一组 互不相同 且由小写英文字母组成的四字母字符串。
单词方块 由 4 个 互不相同 的单词组成：top, left, right 和 bottom，它们按如下方式排列：
- top 形成 顶部行 。
- bottom 形成 底部行 。
- left 形成 左侧列（从上到下）。
- right 形成 右侧列（从上到下）。
它必须满足以下条件：
- top[0] == left[0], top[3] == right[0]
- bottom[0] == left[3], bottom[3] == right[3]
返回所有满足题目要求的 不同 单词方块，按 4 元组 (top, left, right, bottom) 的 字典序升序 排序。
提示：
4 <= words.length <= 15
words[i].length == 4
words[i] 仅由小写英文字母组成。
所有 words[i] 都 互不相同 。

排列型回溯
时间复杂度 $O(C_{15}^{4} \times n!)$
相似题目：46. 全排列
https://leetcode.cn/problems/permutations/
 */