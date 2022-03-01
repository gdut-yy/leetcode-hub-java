import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Solution2179 {
    // O(n)
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // 左到右
        Map<Integer, BitSet> bitSetMap1 = new HashMap<>();
        Map<Integer, BitSet> bitSetMap2 = new HashMap<>();
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        BitSet leftBitSet1 = new BitSet(n);
        BitSet leftBitSet2 = new BitSet(n);
        for (int i = 0; i < n; i++) {
            leftBitSet1.set(nums1[i]);
            bitSetMap1.put(nums1[i], (BitSet) leftBitSet1.clone());
            if (bitSetMap2.containsKey(nums1[i])) {
                BitSet bitSet1 = bitSetMap1.get(nums1[i]);
                BitSet bitSet2 = bitSetMap2.get(nums1[i]);
                bitSet1.and(bitSet2);
                leftMap.put(nums1[i], bitSet1.cardinality() - 1);

                bitSetMap1.remove(nums1[i]);
                bitSetMap2.remove(nums1[i]);
            }

            leftBitSet2.set(nums2[i]);
            bitSetMap2.put(nums2[i], (BitSet) leftBitSet2.clone());
            if (bitSetMap1.containsKey(nums2[i])) {
                BitSet bitSet1 = bitSetMap1.get(nums2[i]);
                BitSet bitSet2 = bitSetMap2.get(nums2[i]);
                bitSet1.and(bitSet2);
                leftMap.put(nums2[i], bitSet1.cardinality() - 1);

                bitSetMap1.remove(nums2[i]);
                bitSetMap2.remove(nums2[i]);
            }
        }
//        for (int i = 1; i <= n - 2; i++) {
//            BitSet bitSet1 = bitSetMap1.get(nums1[i]);
//            BitSet bitSet2 = bitSetMap2.get(nums1[i]);
//            bitSet1.and(bitSet2);
//            leftMap.put(nums1[i], bitSet1.cardinality() - 1);
//        }
        bitSetMap1.clear();
        bitSetMap2.clear();

        // 右到左
        BitSet rightBitSet1 = new BitSet(n);
        BitSet rightBitSet2 = new BitSet(n);
        for (int i = n - 1; i >= 0; i--) {
            rightBitSet1.set(nums1[i], true);
            bitSetMap1.put(nums1[i], (BitSet) rightBitSet1.clone());
            if (bitSetMap2.containsKey(nums1[i])) {
                BitSet bitSet1 = bitSetMap1.get(nums1[i]);
                BitSet bitSet2 = bitSetMap2.get(nums1[i]);
                bitSet1.and(bitSet2);
                rightMap.put(nums1[i], bitSet1.cardinality() - 1);

                bitSetMap1.remove(nums1[i]);
                bitSetMap2.remove(nums1[i]);
            }

            rightBitSet2.set(nums2[i], true);
            bitSetMap2.put(nums2[i], (BitSet) rightBitSet2.clone());
            if (bitSetMap1.containsKey(nums2[i])) {
                BitSet bitSet1 = bitSetMap1.get(nums2[i]);
                BitSet bitSet2 = bitSetMap2.get(nums2[i]);
                bitSet1.and(bitSet2);
                rightMap.put(nums2[i], bitSet1.cardinality() - 1);

                bitSetMap1.remove(nums2[i]);
                bitSetMap2.remove(nums2[i]);
            }
        }
//        for (int i = 1; i <= n - 2; i++) {
//            BitSet bitSet1 = bitSetMap1.get(nums1[i]);
//            BitSet bitSet2 = bitSetMap2.get(nums1[i]);
//            bitSet1.and(bitSet2);
//            rightMap.put(nums1[i], bitSet1.cardinality() - 1);
//        }

        // sum
        long sum = 0L;
        for (int i = 1; i <= n - 2; i++) {
            int num = nums1[i];
            sum += (long) leftMap.get(num) * rightMap.get(num);
        }
        return sum;
    }

    // O(n^3)
    public long goodTriplets2(int[] nums1, int[] nums2) {
        int len = nums2.length;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            idxMap.put(nums2[i], i);
        }
        long cnt = 0L;
        for (int i = 0; i < len; i++) {
            int num1 = nums1[i];
            for (int j = i + 1; j < len; j++) {
                int num2 = nums1[j];
                if (idxMap.get(num2) > idxMap.get(num1)) {
                    for (int k = j + 1; k < len; k++) {
                        int num3 = nums1[k];
                        if (idxMap.get(num3) > idxMap.get(num2)) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
/*
2179. 统计数组中好三元组数目
https://leetcode-cn.com/problems/count-good-triplets-in-an-array/

第 72 场双周赛 T4。

给你两个下标从 0 开始且长度为 n 的整数数组 nums1 和 nums2 ，两者都是 [0, 1, ..., n - 1] 的 排列 。
好三元组 指的是 3 个 互不相同 的值，且它们在数组 nums1 和 nums2 中出现顺序保持一致。
换句话说，如果我们将 pos1v 记为值 v 在 nums1 中出现的位置，pos2v 为值 v 在 nums2 中的位置，
那么一个好三元组定义为 0 <= x, y, z <= n - 1 ，且 pos1x < pos1y < pos1z 和 pos2x < pos2y < pos2z 都成立的 (x, y, z) 。
请你返回好三元组的 总数目 。
提示：
n == nums1.length == nums2.length
3 <= n <= 10^5
0 <= nums1[i], nums2[i] <= n - 1
nums1 和 nums2 是 [0, 1, ..., n - 1] 的排列。

本题数据量到 10^5，O(n^3) 的暴力解法妥妥 TLE。
容易想到枚举中心点，比赛时写出 MLE 的解法。
 */