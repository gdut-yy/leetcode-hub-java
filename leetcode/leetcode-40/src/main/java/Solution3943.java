import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution3943 {
    public int[] numberOfPairs(int[] nums1, int[] nums2, int[][] queries) {
        int n2 = nums2.length;
        int B = (int) Math.sqrt(n2) + 1;
        // int B = 1024;
        int bn = (n2 + B - 1) / B;

        long[] arr = new long[n2];
        long[] lazy = new long[bn];
        HashMap<Long, Integer>[] maps = new HashMap[bn];
        for (int i = 0; i < bn; i++) {
            maps[i] = new HashMap<>();
        }
        for (int i = 0; i < n2; i++) {
            arr[i] = nums2[i];
            int b = i / B;
            maps[b].put(arr[i], maps[b].getOrDefault(arr[i], 0) + 1);
        }

        int[] freq1 = new int[100001];
        for (int v : nums1) freq1[v]++;

        List<Integer> distinctV = new ArrayList<>();
        for (int v = 1; v <= 100000; v++) {
            if (freq1[v] > 0) distinctV.add(v);
        }
        int dLen = distinctV.size();
        int[] vals = new int[dLen];
        int[] cnts = new int[dLen];
        for (int i = 0; i < dLen; i++) {
            vals[i] = distinctV.get(i);
            cnts[i] = freq1[vals[i]];
        }
        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                int x = q[1], y = q[2];
                long val = q[3];
                int lb = x / B, rb = y / B;

                if (lb == rb) {
                    HashMap<Long, Integer> map = maps[lb];
                    for (int i = x; i <= y; i++) {
                        long oldVal = arr[i];
                        int cnt = map.get(oldVal);
                        if (cnt == 1) map.remove(oldVal);
                        else map.put(oldVal, cnt - 1);
                        arr[i] += val;
                        long newVal = arr[i];
                        map.put(newVal, map.getOrDefault(newVal, 0) + 1);
                    }
                } else {
                    HashMap<Long, Integer> mapL = maps[lb];
                    int leftEnd = (lb + 1) * B - 1;
                    for (int i = x; i <= leftEnd; i++) {
                        long oldVal = arr[i];
                        int cnt = mapL.get(oldVal);
                        if (cnt == 1) mapL.remove(oldVal);
                        else mapL.put(oldVal, cnt - 1);
                        arr[i] += val;
                        long newVal = arr[i];
                        mapL.put(newVal, mapL.getOrDefault(newVal, 0) + 1);
                    }
                    for (int i = lb + 1; i < rb; i++) {
                        lazy[i] += val;
                    }
                    HashMap<Long, Integer> mapR = maps[rb];
                    int rightStart = rb * B;
                    for (int i = rightStart; i <= y; i++) {
                        long oldVal = arr[i];
                        int cnt = mapR.get(oldVal);
                        if (cnt == 1) mapR.remove(oldVal);
                        else mapR.put(oldVal, cnt - 1);
                        arr[i] += val;
                        long newVal = arr[i];
                        mapR.put(newVal, mapR.getOrDefault(newVal, 0) + 1);
                    }
                }
            } else {
                long tot = q[1];
                long total = 0;
                for (int idx = 0; idx < dLen; idx++) {
                    int v = vals[idx];
                    int cnt = cnts[idx];
                    long target = tot - v;
                    long sum = 0;
                    for (int b = 0; b < bn; b++) {
                        long key = target - lazy[b];
                        sum += maps[b].getOrDefault(key, 0);
                    }
                    total += sum * cnt;
                }
                ans.add((int) total);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
/*
3943. 递增后的数对数量
https://leetcode.cn/problems/number-of-pairs-after-increment/description/

第 503 场周赛 T4。

给你两个整数数组 nums1 和 nums2，以及一个二维整数数组 queries。
每个 queries[i] 都属于以下两种类型之一：
[1, x, y, val]：将 nums2[x..y] 中的每个元素都 增加 val。
[2, tot]：计算 满足 nums1[j] + nums2[k] == tot 的数对 (j, k) 的数量。
返回一个整数数组 answer，其中 answer[j] 表示第 jth 个类型 2 查询的数对数量。
提示：
1 <= nums1.length <= 5
1 <= nums2.length <= 5 * 10^4
1 <= nums1[i], nums2[i] <= 10^5
1 <= queries.length <= 5 * 10^4
queries[i].length == 2 or 4
queries[i] == [1, x, y, val]，或
queries[i] == [2, tot]
0 <= x <= y < nums2.length
1 <= val <= 10^5
1 <= tot <= 10^9

分块。
时间复杂度 O(n + q * sqrt(mn))。
 */