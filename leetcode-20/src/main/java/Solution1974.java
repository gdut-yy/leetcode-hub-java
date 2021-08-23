public class Solution1974 {
    public int minTimeToType(String word) {
        int cnt = 0;
        char curChar = 'a';
        for (char ch : word.toCharArray()) {
            // 将指针 顺时针 或者 逆时针 移动一个字符
            cnt += distance(curChar, ch);
            // 键入指针 当前 指向的字符
            cnt += 1;
            curChar = ch;
        }
        return cnt;
    }

    private static final int[] DISTANCES = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    /**
     * 计算距离
     *
     * @param curChar 当前指向字符
     * @param target  目标字符
     * @return 距离
     */
    private int distance(char curChar, char target) {
        int offset = curChar - 'a';
        int idx = target - 'a';
        int newIdx = ((idx - offset) % 26 + 26) % 26;
        return DISTANCES[newIdx];
    }
}
/*
1974. 使用特殊打字机键入单词的最少时间
https://leetcode-cn.com/problems/minimum-time-to-type-word-using-special-typewriter/

第 59 场双周赛 T1。
类似密码学的凯撒密码，写出一组 offset 为 0 的解，其余情况按需计算偏移量即可。
 */