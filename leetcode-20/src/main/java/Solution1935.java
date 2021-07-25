import java.util.HashSet;
import java.util.Set;

public class Solution1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenLettersSet = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) {
            brokenLettersSet.add(ch);
        }
        String[] strs = text.split(" ");
        int res = 0;
        for (String str : strs) {
            if (isStrContainBrokenLetters(str, brokenLettersSet)) {
                res++;
            }
        }
        return res;
    }

    private boolean isStrContainBrokenLetters(String str, Set<Character> brokenLettersSet) {
        for (char ch : str.toCharArray()) {
            if (brokenLettersSet.contains(ch)) {
                return false;
            }
        }
        return true;
    }
}
/*
1935. 可以输入的最大单词数
https://leetcode-cn.com/problems/maximum-number-of-words-you-can-type/

第 250 场周赛 T1。
根据题意进行模拟即可
 */