package c276;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc276_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = scanner.nextInt();
        }

        nextPermutation(P);
        StringBuilder stringBuilder = new StringBuilder();
        for (int x : P) {
            stringBuilder.append(x).append(" ");
        }
        System.out.println(stringBuilder.toString().stripTrailing());
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
 */