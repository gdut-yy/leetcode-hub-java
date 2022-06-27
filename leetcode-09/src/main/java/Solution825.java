import java.util.Arrays;

public class Solution825 {
    public int numFriendRequests(int[] ages) {
        // 按年龄升序排序
        Arrays.sort(ages);
        int len = ages.length;
        // 双指针
        int left = 0;
        int right = 0;
        int res = 0;
        // 2 包含 3，条件为真。不会发送好友请求，即
        // age[x] < age[y] <= 0.5 * age[x] + 7

        // 要使 1，2 同时不满足，即
        // age[x] >= age[y] > 0.5 * age[x] + 7
        // 2*age[x] >= 2*age[y] > age[x] + 14
        // age[x] 需要 >= 15
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                left++;
            }
            while (right + 1 < len && ages[right + 1] <= age) {
                right++;
            }
            res += right - left;
        }
        return res;
    }
}
/*
825. 适龄的朋友
https://leetcode.cn/problems/friends-of-appropriate-ages/

在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
- ages[y] <= 0.5 * ages[x] + 7
- ages[y] > ages[x]
- ages[y] > 100 && ages[x] < 100
否则，x 将会向 y 发送一条好友请求。
注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
返回在该社交媒体网站上产生的好友请求总数。

排序 + 双指针
时间复杂度 O(nlogn)
 */
