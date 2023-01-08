package meituan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Meituan004 {
    private static final int N = 40010;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        // input
        String line0 = reader.readLine();
        int n = Integer.parseInt(line0);
        int[] A = new int[N];
        int[] B = new int[N];
        String[] line1 = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(line1[i - 1]);
            B[i] = -1;
        }
        String line2 = reader.readLine();
        int m = Integer.parseInt(line2);
        String[] lines = new String[m];
        for (int i = 0; i < m; i++) {
            lines[i] = reader.readLine();
        }

        // solution
        int[] res = solution(A, B, lines);

        // output
        for (int re : res) {
            writer.write(String.valueOf(re));
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static int[] solution(int[] A, int[] B, String[] lines) {
        List<Integer> resList = new ArrayList<>();
        for (String line : lines) {
            String[] lineM = line.split(" ");
            int op = Integer.parseInt(lineM[0]);
            if (op == 1) {
                int k = Integer.parseInt(lineM[1]);
                int x = Integer.parseInt(lineM[2]);
                int y = Integer.parseInt(lineM[3]);
                for (int i = x, j = y; i < k + x; i++, j++) {
                    B[j] = A[i];
                }
            } else {
                int x = Integer.parseInt(lineM[1]);
                resList.add(B[x]);
            }
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }
}
/*
meituan-004. 小团的复制粘贴
https://leetcode.cn/problems/TOVGD1/

小团是一个莫得感情的 CtrlCV 大师，他有一个下标从 1 开始的序列 A 和一个初始全部为 -1 序列 B ，两个序列的长度都是 n 。
他会进行若干次操作，每一次操作，他都会选择 A 序列中一段连续区间，将其粘贴到 B 序列中的某一个连续的位置，
在这个过程中他也会查询 B 序列中某一个位置上的值。
我们用如下的方式表示他的粘贴操作和查询操作：
粘贴操作：1 k x y，表示把 A 序列中从下标 x 位置开始的连续 k 个元素粘贴到 B 序列中从下标 y 开始的连续 k 个位置上。
原始序列中的元素被覆盖。（注意：输入数据可能会出现粘贴后 k 个元素超出 B 序列原有长度的情况，超出部分可忽略）
查询操作：2 x，表示询问B序列下标 x 处的值是多少。
格式：
输入：
- 输入第一行包含一个正整数 n ，表示序列 A 和序列 B 的长度。
- 输入第二行包含 n 个正整数，表示序列 A 中的 n 个元素，第 i 个数字表示下标为 i 的位置上的元素，每一个元素保证在 10^9 以内。
- 输入第三行是一个操作数 m ，表示进行的操作数量。
- 接下来 m 行，每行第一个数字为 1 或 2 ，具体操作细节详见题面。
输出：
- 对于每一个操作 2 输出一行，每行仅包含一个正整数，表示针对某一个询问的答案。
示例 1：
输入：
5
1 2 3 4 5
5
2 1
2 5
1 2 3 4
2 3
2 5
输出：
-1
-1
-1
4
示例 2：
输入：
5
1 2 3 4 5
9
1 2 3 4
2 3
2 5
1 2 2 3
2 1
2 2
2 3
2 4
2 5
输出：
-1
4
-1
-1
2
3
4
提示：
1 <= n <= 20000
1 <= m <= 20000
 */