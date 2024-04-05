package lq240127;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240127T7 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 5];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long cnt_lan = 0, cnt_qiao = 0;
        reverseSort(a);
        int j = 0;
        for (int i = 1; i <= n / 2; i++) {
            if ((i & 1) == 1) {
                cnt_lan += a[j++];
                cnt_qiao += a[j++];
            } else {
                cnt_qiao += a[j++];
                cnt_lan += a[j++];
            }
        }
        return cnt_lan + " " + cnt_qiao;
    }

    private static void reverseSort(int[] nums) {
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
/*
终极PK【算法赛】

贪心。模拟。
 */