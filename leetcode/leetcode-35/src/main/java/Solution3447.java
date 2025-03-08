import java.util.Arrays;

public class Solution3447 {
    public int[] assignElements(int[] groups, int[] elements) {
        int n = groups.length;
        int m = elements.length;

        int mx = (int) (1e5);
        int[] mp = new int[mx + 1];
        Arrays.fill(mp, -1);
        for (int j = 0; j < m; j++) {
            int v = elements[j];
            if (mp[v] != -1) continue;
            for (int e = v; e <= mx; e += v) {
                if (mp[e] == -1) {
                    mp[e] = j;
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = mp[groups[i]];
        }
        return ans;
    }
}
/*
3447. 将元素分配给有约束条件的组
https://leetcode.cn/problems/assign-elements-to-groups-with-constraints/description/

第 436 场周赛 T2。

给你一个整数数组 groups，其中 groups[i] 表示第 i 组的大小。另给你一个整数数组 elements。
请你根据以下规则为每个组分配 一个 元素：
- 如果 groups[i] 能被 elements[j] 整除，则下标为 j 的元素可以分配给组 i。
- 如果有多个元素满足条件，则分配 最小的下标 j 的元素。
- 如果没有元素满足条件，则分配 -1 。
返回一个整数数组 assigned，其中 assigned[i] 是分配给组 i 的元素的索引，若无合适的元素，则为 -1。
注意：一个元素可以分配给多个组。
提示：
1 <= groups.length <= 10^5
1 <= elements.length <= 10^5
1 <= groups[i] <= 10^5
1 <= elements[i] <= 10^5

调和级数枚举。
时间复杂度 O(Ulogn + m)。
 */