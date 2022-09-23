package didi;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DD2020009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String line = scanner.nextLine();
        System.out.println(solve(line));
    }

    private static String solve(String line) {
        // 移除空格
        line = line.replace(" ", "");
        String left = line.replace(" ", "").split("=")[0];
        String[] nums = left.split("x");
        double a;
        double b = Double.parseDouble(nums[1]);
        if (nums[0].equals("")) {
            a = 1;
        } else if (nums[0].equals("-")) {
            a = -1;
        } else {
            a = Double.parseDouble(nums[0]);
        }
        return String.format("x=%.1f", -b / a);
    }
}
/*
DD-2020009. 一元一次方程求根
https://leetcode.cn/problems/QXxprA/

已知一元一次方程，以 x 为未知数，求方程的根。
格式：
输入：
- 一元一次方程，标准形式，以 x 为未知数，右侧为 '=0' 。中间可能存在空格。
输出：
- 方程的解表达式，中间为等号，等号两边没有空格，解四舍五入保留一位小数。
示例：
输入：5x - 10 = 0
输出：x=2.0
 */