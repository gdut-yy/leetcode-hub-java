import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Meituan010 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        String[] info = reader.readLine().split(" ");
        String[] seq = reader.readLine().split(" ");
        reader.close();

        int m = Integer.parseInt(info[0]);
        int n = Integer.parseInt(info[1]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(seq[i]);
        }

        int res = 0;
        for (int i = 1; i <= m; i++) {
            int left = i, right = m + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (check(arr, i, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res += m - left + 1;
            if (left == m + 1) {
                break;
            }
        }

        writer.write(String.valueOf(res));
        writer.close();
    }

    private static boolean check(int[] arr, int left, int right) {
        int pre = -1;

        for (int x : arr) {
            if (left > x || right < x) {
                if (x < pre) {
                    return false;
                }
                pre = x;
            }
        }

        return true;
    }
}
/*
小团从某不知名论坛上突然得到了一个测试默契度的游戏，想和小美玩一次来检验两人的默契程度。游戏规则十分简单，首先给出一个长度为 n 的序列，最大值不超过 m 。
小团和小美各自选择一个 [1,m] 之间的整数，设小美选择的是 l ，小团选择的是 r ，我们认为两个人是默契的需要满足以下条件:

l 小于等于 r 。
对于序列中的元素 x ，如果 0<x<l ，或 r<x<m+1 ,则 x 按其顺序保留下来，要求保留下来的子序列单调不下降。
小团为了表现出与小美最大的默契，因此事先做了功课，他想知道能够使得两人默契的二元组 <l,r> 一共有多少种。
我们称一个序列 A 为单调不下降的，当且仅当对于任意的 i>j ，满足 A[i]>=A[j] 。

格式：


输入：
- 输入第一行包含两个正整数 m 和 n ，表示序列元素的最大值和序列的长度。
- 输入第二行包含 n 个正整数，表示该序列。
输出：
- 输出仅包含一个整数，表示能使得两人默契的二元组数量。
示例：


输入：
5 5
4 1 4 1 2
输出：10
提示：

1 <= n, m <= 100000
 */