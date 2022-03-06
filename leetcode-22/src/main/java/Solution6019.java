import java.util.LinkedList;
import java.util.List;

public class Solution6019 {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int num : nums) {
            list1.add(num);
        }
        LinkedList<Integer> list2 = new LinkedList<>();

        while (true) {
            if (list1.size() == 1) {
                list2.add(list1.get(0));
            } else {
                int idx = 1;
                while (idx < list1.size()) {
                    int num1 = list1.get(idx - 1);
                    int num2 = list1.get(idx);
                    int gcd = getGCD(num1, num2);
                    if (gcd > 1) {
                        list2.add((int) ((long)num1 * num2 / gcd));
                        idx += 2;
                    } else {
                        list2.add(num1);

                        idx++;
                    }
                }
                if (idx == list1.size()) {
                    list2.add(list1.get(idx - 1));
                }
            }

            if (list2.size() == list1.size()) {
                return list2;
            } else {
                list1 = new LinkedList<>(list2);
                list2.clear();
            }
        }
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution6019().replaceNonCoprimes(new int[]{6, 4, 3, 2, 7, 6, 2}));
//        System.out.println(new Solution6019().replaceNonCoprimes(new int[]{2,2,1,1,3,3,3}));
//        System.out.println(new Solution6019().replaceNonCoprimes(new int[]{48757}));
//        System.out.println(new Solution6019().replaceNonCoprimes(new int[]{517, 11, 121, 517, 3, 51, 3, 1887, 5}));
        System.out.println(new Solution6019().replaceNonCoprimes(new int[]{31,97561,97561,97561,97561,97561,97561,97561,97561}));
//        System.out.println(new Solution6019().getGCD(97561,97561));
//        System.out.println(new Solution6019().getGCD(31,97561));
    }
}
/*
6019. 替换数组中的非互质数
https://leetcode-cn.com/problems/replace-non-coprime-numbers-in-array/

给你一个整数数组 nums 。请你对数组执行下述操作：
1.从 nums 中找出 任意 两个 相邻 的 非互质 数。
2.如果不存在这样的数，终止 这一过程。
3.否则，删除这两个数，并 替换 为它们的 最小公倍数（Least Common Multiple，LCM）。
4.只要还能找出两个相邻的非互质数就继续 重复 这一过程。
返回修改后得到的 最终 数组。可以证明的是，以 任意 顺序替换相邻的非互质数都可以得到相同的结果。
生成的测试用例可以保证最终数组中的值 小于或者等于 108 。
两个数字 x 和 y 满足 非互质数 的条件是：GCD(x, y) > 1 ，其中 GCD(x, y) 是 x 和 y 的 最大公约数 。

输入：nums = [6,4,3,2,7,6,2]
输出：[12,7,6]

6,4,3,2,7,6,2
12,3,2,7,6

输入：
[517,11,121,517,3,51,3,1887,5]
输出：
[5687,1887]
预期：
[5687,1887,5]

输入：
[31,97561,97561,97561,97561,97561,97561,97561,97561]
输出：
[31,9514]
预期：
[31,97561]
 */