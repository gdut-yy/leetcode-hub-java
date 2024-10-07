import java.util.Arrays;

public class SolutionI0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
/*
面试题 01.02. 判定是否互为字符重排
https://leetcode.cn/problems/check-permutation-lcci/

给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
说明：
0 <= len(s1) <= 100
0 <= len(s2) <= 100

模拟。
 */