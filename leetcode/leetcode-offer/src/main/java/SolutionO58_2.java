public class SolutionO58_2 {
    public String reverseLeftWords(String s, int n) {
        String doubleS = s + s;
        return doubleS.substring(n, n + s.length());
    }
}
/*
剑指 Offer 58 - II. 左旋转字符串
https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */