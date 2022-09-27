package didi;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class DD2020002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        String[] ops = new String[n];
        ops[0] = "+";
        for (int i = 0; i < n - 1; i++) {
            nums[i] = scanner.nextInt();
            ops[i + 1] = scanner.next();
        }
        nums[n - 1] = scanner.nextInt();
        System.out.println(solve(n, nums, ops));
    }

    private static String solve(int n, int[] nums, String[] ops) {
        int left = 0;
        int right = 0;
        while (right < n) {
            while (right < n && ops[right].equals(ops[left])) {
                right++;
            }
            right--;

            if (ops[left].equals("+") || ops[left].equals("-")) {
                if (right < n - 1 && (ops[right + 1].equals("*") || ops[right + 1].equals("/"))) {
                    Arrays.sort(nums, left, right);
                } else {
                    Arrays.sort(nums, left, right + 1);
                }
            } else if (ops[left].equals("*")) {
                if (left - 1 >= 0 && (ops[left - 1].equals("+") || ops[left - 1].equals("-"))) {
                    Arrays.sort(nums, left - 1, right + 1);
                } else {
                    Arrays.sort(nums, left, right + 1);
                }
            } else {
                Arrays.sort(nums, left, right + 1);
            }
            right++;
            left = right;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nums[0]);
        for (int i = 1; i < n; i++) {
            stringBuilder.append(" ").append(ops[i]).append(" ").append(nums[i]);
        }
        return stringBuilder.toString();
    }
}
/*
DD-2020002. 算式转移
https://leetcode.cn/problems/0eIsBh/

给出一个仅包含加减乘除四种运算符的算式(不含括号)，如 1+2*3/4，在保持运算符顺序不变的情况下，现在你可以进行若干次如下操作:
如果交换相邻的两个数，表达式值不变，那么你就可以交换这两个数。
现在你可以进行任意次操作，使得算式的数字序列字典序最小，然后输出结果，数字之间的字典序定义为若 a<b 则 a 的字典序小于 b。
格式：
输入：
- 第一行包含一个整数 n，表示算式的长度，即包含 n 个数字和 n-1 个运算符。
- 第二行包含一个含有 n 个非 0 整数和 n-1 个运算符的算式，整数与运算符用空格隔开。
输出：
- 按要求输出字典序最小的表达式，数字与符号之间用空格隔开。
示例：
输入：
3
3 + 2 + 1
输出：1 + 2 + 3
提示：
1 ≤ n ≤ 100000
运算符包括“+，-，*，/”
整数的绝对值不超过 1000。
 */
