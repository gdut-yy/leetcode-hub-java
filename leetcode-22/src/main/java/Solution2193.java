import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution2193 {
    public int minMovesToMakePalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();

        Queue<char[]> queue = new LinkedList<>();
        Set<String> visitedSet = new HashSet<>();
        queue.add(chars);
        visitedSet.add(s);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int sz = 0; sz < size; sz++) {
                char[] curChars = queue.remove();
                if (isPalindrome(curChars)) {
                    return step;
                }

                for (int i = 0; i + 1 < len; i++) {
                    if (curChars[i] != curChars[i + 1]) {
                        char[] chars1 = curChars.clone();
                        chars1[i] = curChars[i + 1];
                        chars1[i + 1] = curChars[i];
                        String str = new String(chars1);
                        if (!visitedSet.contains(str)) {
                            visitedSet.add(str);
                            queue.add(chars1);
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }

    private boolean isPalindrome(char[] chars) {
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
/*
2193. 得到回文串的最少操作次数
https://leetcode-cn.com/problems/minimum-number-of-moves-to-make-palindrome/

第 73 场双周赛 T4。

给你一个只包含小写英文字母的字符串 s 。
每一次 操作 ，你可以选择 s 中两个 相邻 的字符，并将它们交换。
请你返回将 s 变成回文串的 最少操作次数 。
注意 ，输入数据会确保 s 一定能变成一个回文串。
提示：
1 <= s.length <= 2000
s 只包含小写英文字母。
s 可以通过有限次操作得到一个回文串。

原题？https://www.codechef.com/problems/ENCD12 时间复杂度 O(n^2)
如果数据范围拓展为 s.length <= 100000 应该如何解决？ https://www.luogu.com.cn/problem/P5041 时间复杂度 O(nlogn)
 */