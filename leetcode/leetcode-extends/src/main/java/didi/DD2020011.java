package didi;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DD2020011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String line = scanner.nextLine();
        System.out.println(solve(line));
    }

    private static String solve(String line) {
        String[] lines = line.split(",");
        int n = lines.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(lines[i]);
        }
        Arrays.sort(nums);
        return Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining("\t"));
    }
}
/*
DD-2020011. 冒泡排序
https://leetcode.cn/problems/tpjs10/

给定一个数组，使用冒泡实现排序。
格式：
输入：
- 一个数组，元素以逗号分隔。
输出：
- 冒泡排序后的结果。
示例：
输入：71,44,21,76,24,1,3,6
输出：1 3 6 21 24 44 71 76

答案的分隔符为 '\t' 多少有点变态。。
 */