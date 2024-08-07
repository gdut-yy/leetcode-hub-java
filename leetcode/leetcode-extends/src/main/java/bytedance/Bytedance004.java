package bytedance;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Bytedance004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = scanner.nextInt();
        }
        System.out.println(solve(N, H));
    }

    private static String solve(int N, int[] H) {
        int res = 0;
        for (int i = N - 1; i >= 0; i--) {
            // 现在遇到了4, 要达到目标为res也就是0, 上一个值最小应该为多少？，应该是2, X - (4 - X) = res， 2X = res + 4
            // 向上取整所以加一
            res = (res + H[i] + 1) / 2;
        }
        return String.valueOf(res);
    }
}
/*
bytedance-004. 机器人跳跃问题
https://leetcode.cn/problems/yBGFyZ/

机器人正在玩一个古老的基于 DOS 的游戏。游戏中有 N+1 座建筑——从 0 到 N 编号，从左到右排列。编号为 0 的建筑高度为 0 个单位，编号为 i 的建筑的高度为 H(i) 个单位。
起初， 机器人在编号为 0 的建筑处。每一步，它跳到下一个（右边）建筑。假设机器人在第 k 个建筑，且它现在的能量值是 E, 下一步它将跳到第个 k+1 建筑。
它将会得到或者失去正比于与 H(k+1) 与 E 之差的能量。如果 H(k+1) > E 那么机器人就失去 H(k+1) - E 的能量值，否则它将得到 E - H(k+1) 的能量值。
游戏目标是到达第个 N 建筑，在这个过程中，能量值不能为负数个单位。现在的问题是机器人以多少能量值开始游戏，才可以保证成功完成游戏？
格式：
输入：
- 第一行输入，表示一共有 N 组数据.
- 第二个是 N 个空格分隔的整数，H1, H2, H3, ..., Hn 代表建筑物的高度
输出：
- 输出一个单独的数表示完成游戏所需的最少单位的初始能量
示例 1：
输入：
     5
     3 4 3 2 4
输出：4
示例 2：
输入：
     3
     4 4 4
输出：4
示例 3：
输入：
     3
     1 6 4
输出：3
提示：
1 <= N <= 10^5
1 <= H(i) <= 10^5
 */