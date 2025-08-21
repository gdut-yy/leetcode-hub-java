import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution3636 {
    public int[] subarrayMajority(int[] nums, int[][] queries) {
        int n = nums.length;
        int numQueries = queries.length;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            numToIdx.put(list.get(i), i);
        }

        int m = list.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = numToIdx.get(nums[i]);
        }

        int blockSize = (int) Math.sqrt(n);
        Query[] qs = new Query[numQueries];
        for (int i = 0; i < numQueries; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int threshold = queries[i][2];
            qs[i] = new Query(l, r, threshold, i);
        }

        Arrays.sort(qs, (a, b) -> {
            int blockA = a.l / blockSize;
            int blockB = b.l / blockSize;
            if (blockA != blockB) {
                return blockA - blockB;
            }
            if (blockA % 2 == 0) {
                return a.r - b.r;
            } else {
                return b.r - a.r;
            }
        });

        int[] cnt = new int[m];
        TreeMap<Integer, TreeSet<Integer>> freqToNums = new TreeMap<>();
        int left = 0, right = -1;
        int[] ans = new int[numQueries];

        for (Query query : qs) {
            int l = query.l, r = query.r, threshold = query.threshold, idx = query.idx;
            while (right < r) {
                add(arr[++right], cnt, freqToNums);
            }
            while (right > r) {
                remove(arr[right--], cnt, freqToNums);
            }
            while (left < l) {
                remove(arr[left++], cnt, freqToNums);
            }
            while (left > l) {
                add(arr[--left], cnt, freqToNums);
            }

            int maxFreq = freqToNums.isEmpty() ? 0 : freqToNums.lastKey();
            if (maxFreq < threshold) {
                ans[idx] = -1;
            } else {
                int numIdx = freqToNums.get(maxFreq).first();
                ans[idx] = list.get(numIdx);
            }
        }

        return ans;
    }

    private void add(int x, int[] cnt, TreeMap<Integer, TreeSet<Integer>> freqToNums) {
        int oldFreq = cnt[x];
        int newFreq = oldFreq + 1;
        cnt[x] = newFreq;

        if (oldFreq > 0) {
            TreeSet<Integer> setOld = freqToNums.get(oldFreq);
            setOld.remove(x);
            if (setOld.isEmpty()) {
                freqToNums.remove(oldFreq);
            }
        }

        TreeSet<Integer> setNew = freqToNums.computeIfAbsent(newFreq, k -> new TreeSet<>());
        setNew.add(x);
    }

    private void remove(int x, int[] cnt, TreeMap<Integer, TreeSet<Integer>> freqToNums) {
        int oldFreq = cnt[x];
        int newFreq = oldFreq - 1;
        cnt[x] = newFreq;

        TreeSet<Integer> setOld = freqToNums.getOrDefault(oldFreq, new TreeSet<>());
        setOld.remove(x);
        if (setOld.isEmpty()) {
            freqToNums.remove(oldFreq);
        }

        if (newFreq > 0) {
            TreeSet<Integer> setNew = freqToNums.computeIfAbsent(newFreq, k -> new TreeSet<>());
            setNew.add(x);
        }
    }

    static class Query {
        int l, r, threshold, idx;

        Query(int l, int r, int threshold, int idx) {
            this.l = l;
            this.r = r;
            this.threshold = threshold;
            this.idx = idx;
        }
    }
}
/*
3636. 查询超过阈值频率最高元素
https://leetcode.cn/problems/threshold-majority-queries/description/

第 162 场双周赛 T4。

给你一个长度为 n 的整数数组 nums 和一个查询数组 queries，其中 queries[i] = [li, ri, thresholdi]。
返回一个整数数组 ans，其中 ans[i] 等于子数组 nums[li...ri] 中出现 至少 thresholdi 次的元素，选择频率 最高 的元素（如果频率相同则选择 最小 的元素），如果不存在这样的元素则返回 -1。
提示：
1 <= nums.length == n <= 10^4
1 <= nums[i] <= 10^9
1 <= queries.length <= 5 * 10^4
queries[i] = [li, ri, thresholdi]
0 <= li <= ri < n
1 <= thresholdi <= ri - li + 1

离散化 + 莫队算法。
莫队是轮椅算法（轮椅是指在稍有挑战性的游戏中，玩家可以使用的，攻略易复制的，上手难度低，强度超标的武器装备，或者某种套路，这些装备和套路可以大幅度地提高技术水平较低的玩家的游玩体验）。
时间复杂度 O((n + q) sqrt(n) logm)。其中n为数组长度，q为查询数量，m为不同数字个数。
莫队算法（回滚莫队）https://leetcode.cn/problems/threshold-majority-queries/solutions/3740919/mo-dui-suan-fa-hui-gun-mo-dui-pythonjava-x7yw/
https://chat.deepseek.com/a/chat/s/83972666-2ebb-4b37-bb65-646f15179fec
rating 2325 (clist.by)
 */