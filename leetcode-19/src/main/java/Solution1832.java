public class Solution1832 {
    public boolean checkIfPangram(String sentence) {
        int[] cntChars = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            // 对应的字母 0 ~ 25
            int letter = sentence.charAt(i) - 'a';
            if (letter >= 0 && letter < 26) {
                cntChars[letter]++;
            }
        }
        for (int cntChar : cntChars) {
            // 字母没有出现
            if (cntChar == 0) {
                return false;
            }
        }
        return true;
    }
}
/*
1832. 判断句子是否为全字母句
https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram/

第 237 场周赛 T1。
用一个长度为 26 的一维数组统计出现次数即可。
 */