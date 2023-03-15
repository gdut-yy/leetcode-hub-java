import java.util.Arrays;

public class SolutionLCP33 {
    // https://leetcode.cn/problems/o8SXZn/solution/lcp-33-xu-shui-by-zerotrac2-fyj5/
    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length;
        int max = Arrays.stream(vat).max().orElseThrow();
        if (max == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= max; k++) {
            int cur = k;
            for (int i = 0; i < n; i++) {
                int least = vat[i] / k + ((vat[i] % k != 0) ? 1 : 0);
                cur += Math.max(least - bucket[i], 0);
            }
            min = Math.min(min, cur);
        }
        return min;
    }
}
/*
LCP 33. 蓄水
https://leetcode.cn/problems/o8SXZn/

给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
- 升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
- 蓄水：将全部水桶接满水，倒入各自对应的水缸
每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
提示：
1 <= bucket.length == vat.length <= 100
0 <= bucket[i], vat[i] <= 10^4
 */