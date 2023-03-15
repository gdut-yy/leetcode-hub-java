import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1998 {
    public boolean gcdSort(int[] nums) {
        int max = Arrays.stream(nums).max().orElseThrow();

        DSU dsu = new DSU(max + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    dsu.union(num, i);
                    dsu.union(num, num / i);
                }
            }
        }

        int len = nums.length;
        Map<Integer, List<Integer>> groupIdsMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int fa = dsu.find(nums[i]);
            groupIdsMap.computeIfAbsent(fa, key -> new ArrayList<>()).add(i);
        }

        // 分组排序
        for (List<Integer> ids : groupIdsMap.values()) {
            List<Integer> valList = new ArrayList<>();
            for (int id : ids) {
                valList.add(nums[id]);
            }
            Collections.sort(valList);
            int i = 0;
            for (int id : ids) {
                nums[id] = valList.get(i++);
            }
        }

        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            int N = n + 1;
            fa = new int[N];
            for (int i = 0; i < N; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // 合并到较小的节点
            if (rootP < rootQ) {
                fa[rootQ] = rootP;
            } else {
                fa[rootP] = rootQ;
            }
        }
    }
}
/*
1998. 数组的最大公因数排序
https://leetcode.cn/problems/gcd-sort-of-an-array/

第 257 场周赛 T4。

给你一个整数数组 nums ，你可以在 nums 上执行下述操作 任意次 ：
- 如果 gcd(nums[i], nums[j]) > 1 ，交换 nums[i] 和 nums[j] 的位置。其中 gcd(nums[i], nums[j]) 是 nums[i] 和 nums[j] 的最大公因数。
如果能使用上述交换方式将 nums 按 非递减顺序 排列，返回 true ；否则，返回 false 。
提示：
1 <= nums.length <= 3 * 10^4
2 <= nums[i] <= 10^5

并查集连公因数，同一连通块分组排序，再判断
相似题目: 952. 按公因数计算最大组件大小
https://leetcode.cn/problems/largest-component-size-by-common-factor/
 */