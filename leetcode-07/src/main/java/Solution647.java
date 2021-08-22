public class Solution647 {
    /**
     * 中心拓展法
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     *
     * @param s 给定字符串
     * @return 这个字符串中有多少个回文子串
     */
    public int countSubstrings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += cntPalindrome(s, i, i);
            cnt += cntPalindrome(s, i, i + 1);
        }
        return cnt;
    }

    private int cntPalindrome(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }

    /**
     * Manacher 算法
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param s 给定字符串
     * @return 这个字符串中有多少个回文子串
     */
    public int countSubstrings(String s) {
        char[] A = new char[2 * s.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c : s.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v : Z) ans += (v + 1) / 2;
        return ans;
    }
}
/*
647. 回文子串
https://leetcode-cn.com/problems/palindromic-substrings/

给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */