public class Solution953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArr = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            orderArr[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!isSorted(words[i - 1], words[i], orderArr)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String words1, String words2, int[] orderArr) {
        int idx = 0;
        while (idx < words1.length() && idx < words2.length()) {
            int ch1 = words1.charAt(idx) - 'a';
            int ch2 = words2.charAt(idx) - 'a';
            if (orderArr[ch1] < orderArr[ch2]) {
                return true;
            } else if (orderArr[ch1] > orderArr[ch2]) {
                return false;
            } else {
                idx++;
            }
        }
        // 短的单词排前面
        return idx == words1.length();
    }
}
/*
953. 验证外星语词典
https://leetcode-cn.com/problems/verifying-an-alien-dictionary/

输入 n 个单词，每个单词平均长度为 k
时间复杂度 O(nk)
空间复杂度 O(1)
 */