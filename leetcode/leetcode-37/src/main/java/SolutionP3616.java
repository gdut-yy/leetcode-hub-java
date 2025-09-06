public class SolutionP3616 {
    public int totalReplacements(int[] ranks) {
        int n = ranks.length;
        int bestIdx = 0;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (ranks[i] < ranks[bestIdx]) {
                bestIdx = i;
                ans++;
            }
        }
        return ans;
    }
}
/*
$3616. 学生替换人数
https://leetcode.cn/problems/number-of-student-replacements/description/

给定一个整数数组 ranks，其中 ranks[i] 表示第 i 个 按顺序 到达的学生排名。数字越低表示排名 越好。
最初，默认 选中 第一个学生。
当一名排名 严格 更好的学生到来时，会发生 替换，并 取代 当前的选择。
返回替换的总数。
提示：
1 <= ranks.length <= 10^5
1 <= ranks[i] <= 10^5

遍历。
时间复杂度 O(n)。
 */