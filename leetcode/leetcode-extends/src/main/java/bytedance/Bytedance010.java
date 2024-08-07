package bytedance;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Bytedance010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String line = scanner.next();
        System.out.println(solve(line));
    }

    private static String solve(String line) {
        line = line.substring(1, line.length() - 1);
        String[] lines = line.split(",");
        Arrays.sort(lines, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        return String.join("", lines);
    }
}
/*
bytedance-010. 数组组成最大数
https://leetcode.cn/problems/9nsGSS/

给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
示例 1：
输入：[10,1,2]
输出：2110
示例 2：
输入：[3,30,34,5,9]
输出：9534330
 */