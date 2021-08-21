public class Solution67 {
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
67. 二进制求和
https://leetcode-cn.com/problems/add-binary/

当二进制字符串比较长时，它表示的整数可能会超出 int 型整数和 long 型整数的范围。
因此转换成十进制整数再相加不可行。
 */