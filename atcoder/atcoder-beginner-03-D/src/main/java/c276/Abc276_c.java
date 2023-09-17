package c276;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc276_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(solve(p));
    }

    private static String solve(int[] p) {
        nextPermutation(p);
        return Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] <= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] <= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(int[] nums, int start) {
        int right = nums.length - 1;
        while (start < right) {
            swap(nums, start, right);
            start++;
            right--;
        }
    }
}
/*
C - Previous Permutation
https://atcoder.jp/contests/abc276/tasks/abc276_c

题目大意：
给你一个排列 P = (P 1,…,P N)(1…N),在(P 1,…,P N)=(1…N)。
假设 P 是(1…，N)的所有排列中字典顺序最小的第 k 个。找出(K−1)-第(K−1)个字典最小的排列。

相似题目: 31. 下一个排列
https://leetcode.cn/problems/next-permutation/
======

Input 1
3
3 1 2
Output 1
2 3 1

Input 2
10
9 8 6 5 10 3 1 2 4 7
Output 2
9 8 6 5 10 2 7 4 3 1
 */