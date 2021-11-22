import java.util.ArrayList;
import java.util.List;

public class Solution1065 {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> resList = new ArrayList<>();
        for (String word : words) {
            List<Integer> fromIdxList = new ArrayList<>();
            // dfs 结合 indexOf 找出当前 word 所有的开始下标
            helper(text, word, fromIdxList, 0);
            for (int fromIdx : fromIdxList) {
                resList.add(new int[]{fromIdx, fromIdx + word.length() - 1});
            }
        }
        // 排序答案后返回
        resList.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        return resList.toArray(new int[resList.size()][]);
    }

    private void helper(String text, String word, List<Integer> list, int fromIndex) {
        int idx = text.indexOf(word, fromIndex);
        if (idx != -1) {
            list.add(idx);
            helper(text, word, list, idx + 1);
        }
    }
}
/*
1065. 字符串的索引对
https://leetcode-cn.com/problems/index-pairs-of-a-string/

第 1 场双周赛 T2。

给出 字符串 text 和 字符串列表 words, 返回所有的索引对 [i, j]
使得在索引对范围内的子字符串 text[i]...text[j]（包括 i 和 j）属于字符串列表 words。

dfs 结合 indexOf 找出当前 word 所有的开始下标
 */