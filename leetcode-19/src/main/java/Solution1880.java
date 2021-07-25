public class Solution1880 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int firstNum = caseStringToInteger(firstWord);
        int secondNum = caseStringToInteger(secondWord);
        int targetNum = caseStringToInteger(targetWord);
        return firstNum + secondNum == targetNum;
    }

    private int caseStringToInteger(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            stringBuilder.append(ch - 'a');
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
/*
1880. 检查某单词是否等于两单词之和
https://leetcode-cn.com/problems/check-if-word-equals-summation-of-two-words/

第 243 场周赛 T1。
按要求将字符串转对应数字运算即可。
 */