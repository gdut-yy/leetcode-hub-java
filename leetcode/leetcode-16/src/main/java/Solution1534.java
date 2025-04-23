import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1534 {
    // O(n^3)
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((Math.abs(arr[i] - arr[j]) > a)) continue;
                for (int k = j + 1; k < n; k++) {
                    if ((Math.abs(arr[j] - arr[k]) <= b) && (Math.abs(arr[i] - arr[k]) <= c)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    // O(n^2)
    public int countGoodTriplets2(int[] arr, int a, int b, int c) {
        int n = arr.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> arr[o]));

        int ans = 0;
        for (int j : ids) {
            int y = arr[j];
            List<Integer> left = new ArrayList<>();
            for (int i : ids) {
                if (i < j && Math.abs(arr[i] - y) <= a) {
                    left.add(arr[i]);
                }
            }

            List<Integer> right = new ArrayList<>();
            for (int k : ids) {
                if (k > j && Math.abs(arr[k] - y) <= b) {
                    right.add(arr[k]);
                }
            }

            int k1 = 0;
            int k2 = 0;
            for (int x : left) {
                while (k2 < right.size() && right.get(k2) <= x + c) {
                    k2++;
                }
                while (k1 < right.size() && right.get(k1) < x - c) {
                    k1++;
                }
                ans += k2 - k1;
            }
        }
        return ans;
    }
}
/*
1534. 统计好三元组
https://leetcode.cn/problems/count-good-triplets/

第 200 场周赛 T1。

给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
- 0 <= i < j < k < arr.length
- |arr[i] - arr[j]| <= a
- |arr[j] - arr[k]| <= b
- |arr[i] - arr[k]| <= c
其中 |x| 表示 x 的绝对值。
返回 好三元组的数量 。
提示：
3 <= arr.length <= 100
0 <= arr[i] <= 1000
0 <= a, b, c <= 1000

暴力枚举 / 前缀和 / 排序+三指针
https://leetcode.cn/problems/count-good-triplets/solutions/3622921/liang-chong-fang-fa-bao-li-mei-ju-qian-z-apcv/
 */