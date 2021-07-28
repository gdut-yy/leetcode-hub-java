public class Solution1946 {
    public String maximumNumber(String num, int[] change) {
        // 双指针
        int left = 0;
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            if (change[cur] > cur) {
                left = i;
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(num.substring(0, left));
        int right = left;
        while (right < num.length() && change[num.charAt(right) - '0'] >= num.charAt(right) - '0') {
            stringBuilder.append(change[num.charAt(right) - '0']);
            right++;
        }
        stringBuilder.append(num.substring(right));
        return stringBuilder.toString();
    }
}
/*
1946. 子字符串突变后可能得到的最大整数
https://leetcode-cn.com/problems/largest-number-after-mutating-substring/

第 251 场周赛 T2。
双指针。其实单指针亦可。
先找到 change 数组中开始大于 num[i] 的下标，然后取一个区间进行替换即是可能得到的最大整数
 */