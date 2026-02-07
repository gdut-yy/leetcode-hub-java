public class SolutionP3744 {
    static final char UNKNOWN = '*';

    public char kthCharacter(String s, long k) {
        char target = UNKNOWN;
        long idx = 0;
        int cnt = 1;
        int n = s.length();
        for (int i = 0; i < n && target == UNKNOWN; i++) {
            long nextIndex = idx;
            char c = s.charAt(i);
            if (c != ' ') {
                nextIndex += cnt;
                cnt++;
            } else {
                nextIndex++;
                cnt = 1;
            }
            if (nextIndex > k) {
                target = c;
            } else {
                idx = nextIndex;
            }
        }
        return target;
    }
}
/*
$3744. 在展开字符串中查找第 K 个字符
https://leetcode.cn/problems/find-kth-character-in-expanded-string/description/

给定一个字符串 s，该字符串由一个或多个单词组成，单词之间用单个空格分隔。s 中的每个单词均由小写的英文字母组成。
我们按如下步骤从 s 得到 展开 字符串 t：
- 对于 s 中的每个 单词，重复一次它的第一个字符，然后重复两次它的第二个字符，以此类推。
例如，如果 s = "hello world"，那么 t = "heelllllllooooo woorrrllllddddd"。
同时给定一个整数 k，表示字符串 t 的一个 合法 下标。
返回字符串 t 的第 k 个字符。
提示：
1 <= s.length <= 10^5
s 只包含小写英文字母和空格 ' '。
s 不包含 任何前导和后缀空格。
s 中的所有单词都由 一个空格 分隔。
0 <= k < t.length。即 k 是 t 的一个 合法 下标。

https://leetcode.cn/problems/find-kth-character-in-expanded-string/solutions/3832850/3744-zai-zhan-kai-zi-fu-chuan-zhong-cha-6hg7x/
时间复杂度 O(n)。
 */