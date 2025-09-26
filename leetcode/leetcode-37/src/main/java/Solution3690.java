import java.util.*;
import java.util.stream.Collectors;

public class Solution3690 {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        List<Integer> nums2List = toList(nums2);
        Set<List<Integer>> vis = new HashSet<>();
        vis.add(toList(nums1));
        List<List<Integer>> q = List.of(toList(nums1));
        for (int ans = 0; ; ans++) {
            List<List<Integer>> tmp = q;
            q = new ArrayList<>();
            for (List<Integer> a : tmp) {
                if (a.equals(nums2List)) {
                    return ans;
                }
                for (int l = 0; l < n; l++) {
                    for (int r = l + 1; r <= n; r++) {
                        List<Integer> sub = a.subList(l, r);
                        List<Integer> b = new ArrayList<>(a);
                        b.subList(l, r).clear(); // 从 b 中移除 sub
                        for (int i = 0; i <= b.size(); i++) {
                            List<Integer> c = new ArrayList<>(b);
                            c.addAll(i, sub);
                            if (vis.add(c)) { // c 不在 vis 中
                                q.add(c);
                            }
                        }
                    }
                }
            }
        }
    }

    private List<Integer> toList(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }
}
/*
3690. 拆分合并数组
https://leetcode.cn/problems/split-and-merge-array-transformation/description/

第 468 场周赛 T3。

给你两个长度为 n 的整数数组 nums1 和 nums2。你可以对 nums1 执行任意次下述的 拆分合并操作：
1.选择一个子数组 nums1[L..R]。
2.移除该子数组，留下前缀 nums1[0..L-1]（如果 L = 0 则为空）和后缀 nums1[R+1..n-1]（如果 R = n - 1 则为空）。
3.将移除的子数组（按原顺序）重新插入到剩余数组的 任意 位置（即，在任意两个元素之间、最开始或最后面）。
返回将 nums1 转换为 nums2 所需的 最少拆分合并操作 次数。
提示:
2 <= n == nums1.length == nums2.length <= 6
-10^5 <= nums1[i], nums2[i] <= 10^5
nums2 是 nums1 的一个 排列。

根据数据范围，至多有 6!=720 个不同的排列，这很小，考虑暴力。
https://leetcode.cn/problems/split-and-merge-array-transformation/solutions/3787914/bfspythonjavacgo-by-endlesscheng-86ya/
时间复杂度 O(n! * n^4)。
 */