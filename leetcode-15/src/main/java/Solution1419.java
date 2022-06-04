public class Solution1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        // croak
        int[] croak = new int[5];

        int cnt = 0;
        int res = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            if (ch == 'c') {
                croak[0]++;
                cnt++;
            } else if (ch == 'r') {
                croak[1]++;
            } else if (ch == 'o') {
                croak[2]++;
            } else if (ch == 'a') {
                croak[3]++;
            } else {
                croak[4]++;
                cnt--;
            }
            res = Math.max(res, cnt);
            if (!(croak[0] >= croak[1] && croak[1] >= croak[2] && croak[2] >= croak[3] && croak[3] >= croak[4])) {
                return -1;
            }
        }
        if (!(croak[0] == croak[1] && croak[1] == croak[2] && croak[2] == croak[3] && croak[3] == croak[4])) {
            return -1;
        }
        return res;
    }
}
/*
1419. 数青蛙
https://leetcode.cn/problems/minimum-number-of-frogs-croaking/

给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
提示：
1 <= croakOfFrogs.length <= 10^5
字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'

数大雁 原题。
时间复杂度 O(n)
 */