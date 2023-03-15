package bytedance;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Bytedance002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = scanner.nextInt();
        }
        System.out.println(solve(K, N, T));
    }

    private static String solve(int K, int N, int[] T) {
        int left = 0;
        int right = N;
        for (int i = 0; i < N; i++) {
            right += T[i];
        }

        // 2. 对答案区间(有序递增区间)进行二分法
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValid(T, K, mid)) {
                right = mid; // 符合条件要等于 => 逼近下限
            } else {
                left = mid + 1; // 不符合条件要+1 => 逼近下限
            }
        }
        return String.valueOf(left);
    }

    private static boolean isValid(int[] T, int K, int res) {
        // 模拟派送过程: 用完人数资源后, 是否能配送完成。
        int[] nums = Arrays.copyOfRange(T, 0, T.length);
        // 1. 可用人数（每个人可用res个配送时间）
        for (int i = 0; i < K; i++) {
            int t = res;// 每个人可用的时间
            // 从每个工区头部进行配送
            for (int j = 0; j < nums.length; j++) {
                t--; // 往前移动一步
                if (t <= 0) {
                    break; // 时间用完
                }
                if (nums[j] >= t) {
                    nums[j] = nums[j] - t; // 用完全部配送时间
                    break;
                } else {
                    t -= nums[j]; // 配送完还剩余时间
                    nums[j] = 0;
                }
            }
        }
        // 2. 派送完毕验证是否存在没有配送的情况
        boolean done = true;
        for (int num : nums) {
            if (num > 0) {
                done = false;
                break;
            }
        }
        return done;
    }
}
/*
bytedance-002. 发下午茶
https://leetcode.cn/problems/OMrszv/

有 K 名字节君，每天下午都要推着推车给字节的同学送下午茶，字节的同学分布在不同的工区，字节的工区分布和字节君的位置分布如下。
在上图中，每个方框内的单位长度为 1。已知字节君的推车可以装无限份下午茶，所以不需要字节君回到初始地点补充下午茶。每个字节君只有两个动作。
把推车向前移动一个单位。
1.把一份下午茶投放到当前工区。
2.现在告诉你字节君的数量以及每个工具需要的下午茶个数请问，所有的字节君最少花费多长时间才能送完所有的下午茶？
格式：
输入：
- 第一行是字节君的数量K和工区的数量 N
- 第二行 N 个数字是每个工区需要的下午茶数量 Ti
输出：
- 输出一个数字代表所有字节均最少花费多长时间才能送完所有的下午茶
示例 1：
输入：
     3 3
     7 1 1
输出：5
解释：
字节君1：右移->放置->放置->放置->放置
字节君2：右移->放置->放置->放置
字节君3：右移->右移->放置->右移->放置
示例 2：
输入：
     2 4
     3 3 1 1
输出：7
解释：
字节君1：右移->放置->放置->放置->右移->放置->放置
字节君2：右移->右移->放置->右移->放置->右移->放置
提示：
0< K, N <= 1000
0<= Ti <= 10000
 */