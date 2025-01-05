import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> zipList = new ArrayList<>(); // v, i
        for (int i = 0; i < nums.size(); i++) {
            for (Integer v : nums.get(i)) {
                zipList.add(new int[]{v, i});
            }
        }
        zipList.sort(Comparator.comparingInt(o -> o[0]));

        int ansL = zipList.getFirst()[0], ansR = zipList.getLast()[0];
        int k = nums.size();
        int[] cnt = new int[k];
        int l = 0, r = 0;
        int repeated = 0;
        while (r < zipList.size()) {
            int i = zipList.get(r)[1];
            if (++cnt[i] == 1) repeated++;
            while (repeated == k) {
                if (zipList.get(r)[0] - zipList.get(l)[0] < ansR - ansL) {
                    ansL = zipList.get(l)[0];
                    ansR = zipList.get(r)[0];
                }
                i = zipList.get(l)[1];
                if (--cnt[i] == 0) repeated--;
                l++;
            }
            r++;
        }
        return new int[]{ansL, ansR};
    }
}
/*
632. 最小区间
https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/

你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
提示：
nums.length == k
1 <= k <= 3500
1 <= nums[i].length <= 50
-10^5 <= nums[i][j] <= 10^5
nums[i] 按非递减顺序排列

排序 + 滑动窗口。
时间复杂度 O(LlogL)。其中 L 是所有 nums[i] 的长度之和。瓶颈在排序上。
空间复杂度 O(L)
相似题目: 76. 最小覆盖子串
https://leetcode.cn/problems/minimum-window-substring/
 */