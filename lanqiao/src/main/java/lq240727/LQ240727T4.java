package lq240727;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LQ240727T4 {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] L = getL();
        reverse(arr);
        int[] R = getL();
        reverse(R);

        long ans = 0;
        for (int i = 2; i <= n - 1 - 2; i++) {
            ans += (long) L[i] * R[i];
        }
        return String.valueOf(ans);
    }

    static void reverse(int[] nums) {
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }

    static int[] getL() {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int[] L = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (i >= 2) {
                    L[i] = cntMap.getOrDefault(arr[i], 0);
                }
                int sum = arr[j] + arr[i];
                cntMap.merge(sum, 1, Integer::sum);
            }
        }
        return L;
    }
}
/*
拯救美猴王【算法赛】

O(n^2) 预处理前后缀。
 */