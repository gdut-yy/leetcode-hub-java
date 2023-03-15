import java.util.HashMap;
import java.util.Map;

public class Ubiquant220821T1 {
    public int numberOfPairs(int[] nums) {
        Map<Long, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            long diff = num - getMirrorNum(num);
            cntMap.put(diff, cntMap.getOrDefault(diff, 0) + 1);
        }

        long res = 0;
        for (Map.Entry<Long, Integer> entry : cntMap.entrySet()) {
            long k = entry.getValue();
            res += k * (k - 1) / 2;
            res %= 1000000007;
        }
        return (int) res;
    }

    private long getMirrorNum(int num) {
        return Long.parseLong(new StringBuilder("" + num).reverse().toString());
    }
}
/*
九坤投资专场竞赛
九坤-01. 可以读通讯稿的组数
https://leetcode.cn/contest/ubiquant2022/problems/xdxykd/

校运动会上，所有参赛同学身上都贴有他的参赛号码。某班参赛同学的号码记于数组 nums 中。假定反转后的号码称为原数字的「镜像号码」。
如果 两位同学 满足条件：镜像号码 A + 原号码 B = 镜像号码 B + 原号码 A，则这两位同学可以到广播站兑换一次读通讯稿的机会，为同班同学加油助威。
请返回所有参赛同学可以组成的可以读通讯稿的组数，并将结果对10^9+7取余。
注意：
镜像号码中如存在前置零，则忽略前置零。
同一位同学可有多次兑换机会。
示例 1：
输入：nums = [17,28,39,71]
输出：3
解释：
共有三对同学，分别为 [17,28]、[17,39]、[28,39]。其中：
第一对同学：17 + 82 = 71 + 28；
第二对同学：17 + 93 = 71 + 39；
第三对同学：28 + 93 = 82 + 39。
示例 2：
输入：nums = [71, 60]
输出：1
解释：
共有一对同学，为 [71, 60]。
因为 71 + 6 = 17 + 60，此处 60 的镜像号码为 6，前导零被忽略。
提示：
0 <= nums.length <= 10^6
0 <= nums[i] <= 10^9
 */