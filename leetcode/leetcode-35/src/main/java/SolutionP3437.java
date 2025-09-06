import java.util.ArrayList;
import java.util.List;

public class SolutionP3437 {
    private int n;
    private boolean[] vis;
    private List<Integer> snap;
    private List<int[]> ans;

    public int[][] permute(int n) {
        this.n = n;
        vis = new boolean[n + 1];
        snap = new ArrayList<>();
        ans = new ArrayList<>();
        dfs(0);
        return ans.toArray(int[][]::new);
    }

    public void dfs(int idx) {
        if (idx == n) {
            ans.add(snap.stream().mapToInt(Integer::intValue).toArray());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (vis[i] || (idx - 1 >= 0 && i % 2 == snap.get(idx - 1) % 2)) {
                continue;
            }
            snap.add(i);
            vis[i] = true;
            dfs(idx + 1);
            snap.remove(idx);
            vis[i] = false;
        }
    }
}
/*
$3437. 全排列 III
https://leetcode.cn/problems/permutations-iii/description/

给定一个整数 n，一个 交替排列 是没有 两个 相邻元素 同时 为奇数或偶数的前 n 个正整数的排列。
返回所有这样的 交替排列 以字典序排序。
提示：
1 <= n <= 10

回溯。
https://leetcode.cn/problems/permutations-iii/solutions/3068895/3437-quan-pai-lie-iii-by-stormsunshine-jrom/
时间复杂度 O(n×n!)
 */