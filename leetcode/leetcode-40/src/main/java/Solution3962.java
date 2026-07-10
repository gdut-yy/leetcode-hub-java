import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution3962 {
    public long maxSum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new TreeSet<>();
        for (int v : nums) set.add(v);
        int M = set.size();
        int[] vals = new int[M + 1];
        Map<Integer, Integer> valToIdx = new HashMap<>();
        int idx = 1;
        for (int v : set) {
            vals[idx] = v;
            valToIdx.put(v, idx);
            idx++;
        }
        int[] globalFreq = new int[M + 1];
        long totalSum = 0;
        for (int v : nums) {
            int id = valToIdx.get(v);
            globalFreq[id]++;
            totalSum += v;
        }
        int highestBit = Integer.highestOneBit(M);
        Fenwick ext = new Fenwick(M, highestBit, vals);
        long ans = Long.MIN_VALUE;
        for (int L = 0; L < n; L++) {
            ext.build(globalFreq);
            Fenwick inner = new Fenwick(M, highestBit, vals);
            long internalSum = 0;
            long externalSum = totalSum;
            int intCount = 0, extCount = n;
            int tOpt = 0;
            for (int R = L; R < n; R++) {
                int val = nums[R];
                int id = valToIdx.get(val);
                ext.add(id, -1);
                inner.add(id, 1);
                externalSum -= val;
                internalSum += val;
                extCount--;
                intCount++;
                int Tmax = Math.min(k, Math.min(intCount, extCount));
                if (tOpt > Tmax) tOpt = Tmax;
                while (tOpt < Tmax) {
                    int extVal = ext.getKthMax(tOpt + 1, extCount);
                    int intVal = inner.getKthMin(tOpt + 1);
                    if (extVal > intVal) tOpt++;
                    else break;
                }
                while (tOpt > 0) {
                    int extVal = ext.getKthMax(tOpt, extCount);
                    int intVal = inner.getKthMin(tOpt);
                    if (extVal <= intVal) tOpt--;
                    else break;
                }
                long gain = 0;
                if (tOpt > 0) {
                    long sumExtTop = ext.sumTopK(tOpt, extCount, externalSum);
                    long sumIntBot = inner.sumBottomK(tOpt);
                    gain = sumExtTop - sumIntBot;
                }
                long cand = internalSum + gain;
                if (cand > ans) ans = cand;
            }
        }
        return ans;
    }

    static class Fenwick {
        int n;
        int[] cnt;
        long[] sum;
        int highestBit;
        int[] vals;  // 1-based 原值

        Fenwick(int n, int highestBit, int[] vals) {
            this.n = n;
            this.cnt = new int[n + 2];
            this.sum = new long[n + 2];
            this.highestBit = highestBit;
            this.vals = vals;
        }

        void build(int[] freq) {
            for (int i = 1; i <= n; i++) {
                cnt[i] = freq[i];
                sum[i] = (long) freq[i] * vals[i];
            }
            for (int i = 1; i <= n; i++) {
                int j = i + (i & -i);
                if (j <= n) {
                    cnt[j] += cnt[i];
                    sum[j] += sum[i];
                }
            }
        }

        void add(int idx, int dcnt) {
            long dsum = (long) dcnt * vals[idx];
            while (idx <= n) {
                cnt[idx] += dcnt;
                sum[idx] += dsum;
                idx += idx & -idx;
            }
        }

        int getKthMin(int k) {
            int idx = 0;
            for (int bit = highestBit; bit > 0; bit >>= 1) {
                int nxt = idx + bit;
                if (nxt <= n && cnt[nxt] < k) {
                    k -= cnt[nxt];
                    idx = nxt;
                }
            }
            return vals[idx + 1];
        }

        int getKthMax(int k, int total) {
            return getKthMin(total - k + 1);
        }

        long sumBottomK(int k) {
            if (k == 0) return 0;
            int idx = 0;
            int kk = k;
            for (int bit = highestBit; bit > 0; bit >>= 1) {
                int nxt = idx + bit;
                if (nxt <= n && cnt[nxt] < kk) {
                    kk -= cnt[nxt];
                    idx = nxt;
                }
            }
            long res = 0;
            int i = idx;
            while (i > 0) {
                res += sum[i];
                i -= i & -i;
            }
            int pos = idx + 1;
            res += (long) kk * vals[pos];
            return res;
        }

        long sumTopK(int k, int total, long totalSum) {
            if (k == total) return totalSum;
            return totalSum - sumBottomK(total - k);
        }
    }
}
/*
3962. 至多 K 次交换后最大子数组和
https://leetcode.cn/problems/maximum-subarray-sum-after-at-most-k-swaps/description/

第 506 场周赛 T4。

给你一个整数数组 nums 和一个整数 k。
你可以对数组执行 至多 k 次交换操作。
在一次交换操作中，你可以选择任意两个下标 i 和 j 并交换 nums[i] 和 nums[j]。
返回一个整数，表示在执行交换后 可能的最大 子数组 和。
提示：
1 <= nums.length <= 1500
-10^5 <= nums[i] <= 10^5
0 <= k <= nums.length

值域树状数组 + 优化。
 */