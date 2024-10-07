public class SolutionLCR182 {
    public String dynamicPassword(String password, int target) {
        String doubleS = password + password;
        return doubleS.substring(target, target + password.length());
    }

    public String dynamicPassword2(String password, int target) {
        char[] s = password.toCharArray();
        int n = s.length;
        int k = n - target;
        reverseArrays(s, 0, n - 1);
        reverseArrays(s, 0, k - 1);
        reverseArrays(s, k, n - 1);
        return new String(s);
    }

    private void reverseArrays(char[] a, int left, int right) {
        while (left < right) {
            char tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            left++;
            right--;
        }
    }
}
/*
LCR 182. 动态口令
https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/

某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤：
- 设定一个正整数目标值 target
- 将 password 前 target 个字符按原顺序移动至字符串末尾
请返回更新后的密码字符串。
提示：
1 <= target < password.length <= 10000

相似题目: 189. 旋转数组
https://leetcode.cn/problems/rotate-array/
 */