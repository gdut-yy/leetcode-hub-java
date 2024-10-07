public class SolutionLCR169 {
    public char dismantlingAction(String arr) {
        int[] cnt = new int[26];
        for (char c : arr.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : arr.toCharArray()) {
            if (cnt[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
/*
LCR 169. 招式拆解 II
https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/description/

某套连招动作记作仅由小写字母组成的序列 arr，其中 arr[i] 第 i 个招式的名字。请返回第一个只出现一次的招式名称，如不存在请返回空格。
限制：
0 <= arr.length <= 50000

两次遍历。第一次遍历统计频次，第二次遍历获取第一个频次为 1 的字符。
 */