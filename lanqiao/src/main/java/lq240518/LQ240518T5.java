package lq240518;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240518T5 {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(s);
        char[] c = s.clone();
        reverseSort(c);

        int i = 0;
        while (i < s.length && s[i] == '0') i++;
        if (i < s.length) {
            char tmp = s[0];
            s[0] = s[i];
            s[i] = tmp;
        }
        return new String(c) + " " + new String(s);
    }

    static void reverseSort(char[] nums) {
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            char tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
/*
数学魔术家【算法赛】

从贪心角度考虑，较大的数字越往左放数字会越大，越往右数字会越小。
所以直接将数字串进行从大到小排序可以得到最大值，将字符串进行从小到大排序可以得到最小值。
唯一需要注意的是 0 开头的数字不合法，最小值的开头应该是最小的非 0 元素。
 */