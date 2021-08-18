public class Offer2Solution2 {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        // 进位
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int numA;
            if (i >= 0) {
                numA = a.charAt(i) - '0';
                i--;
            } else {
                numA = 0;
            }
            int numB;
            if (j >= 0) {
                numB = b.charAt(j) - '0';
                j--;
            } else {
                numB = 0;
            }
            int sum = numA + numB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            stringBuilder.append(sum);
        }
        if (carry == 1) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }
}
/*
剑指 Offer II 002. 二进制加法
https://leetcode-cn.com/problems/JFETK5/
 */