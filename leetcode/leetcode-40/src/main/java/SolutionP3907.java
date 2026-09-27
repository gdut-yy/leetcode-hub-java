import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionP3907 {
    public int[] countSmallerOppositeParity(int[] nums) {
        // 收集去重排序后的值域，ss = [0] + sorted(set(nums))
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        List<Integer> ss = new ArrayList<>();
        ss.add(0);
        ss.addAll(set);
        Collections.sort(ss);
        int mx = ss.size();
        // dc: 值 -> 在 ss 中的下标
        Map<Integer, Integer> dc = new HashMap<>();
        for (int i = 0; i < mx; i++) {
            dc.put(ss.get(i), i);
        }
        int n = nums.length;
        int[] haso = new int[mx]; // 奇数值的树状数组
        int[] hase = new int[mx]; // 偶数值的树状数组
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            int res = 0;
            int v = dc.get(x);
            int[] lisa, lisc;
            if (x % 2 != 0) { // x 为奇数
                lisa = haso;
                lisc = hase;
            } else { // x 为偶数
                lisa = hase;
                lisc = haso;
            }
            // 更新同奇偶树状数组：在 0 基下标 v 处加 1（1 基起始 nv = v + 1）
            int nv = v + 1;
            while (nv < mx) {
                lisa[nv] += 1;
                nv += nv & (-nv);
            }
            // 查询反奇偶树状数组：前缀和到 0 基下标 v-1（1 基终止 mv = v）
            int mv = v;
            while (mv != 0) {
                res += lisc[mv];
                mv = mv & (mv - 1);
            }
            ans[i] = res;
        }
        return ans;
    }
}
/*
$3907. 统计具有相反奇偶性的较小元素
https://leetcode.cn/problems/count-smaller-elements-with-opposite-parity/description/

给定一个长度为 n 的整数数组 nums。
下标 i 的得分定义为满足以下条件的索引 j 的数量：
- i < j < n
- nums[j] < nums[i]
- nums[i] 和 nums[j] 有不同的奇偶性（一个是偶数，另一个是奇数）。
返回一个长度为 n 的整数数组 answer，其中 answer[i] 是下标 i 的得分。
示例 1：
输入：nums = [5,2,4,1,3]
输出：[2,1,2,0,0]
示例 2：
输入：nums = [4,4,1]
输出：[1,1,0]
示例 3：
输入：nums = [7]
输出：[0]
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
 */