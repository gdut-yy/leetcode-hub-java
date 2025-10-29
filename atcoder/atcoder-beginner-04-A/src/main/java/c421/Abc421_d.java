package c421;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc421_d {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int Rt = scanner.nextInt();
        int Ct = scanner.nextInt();
        int Ra = scanner.nextInt();
        int Ca = scanner.nextInt();
        long N = scanner.nextLong();
        int M = scanner.nextInt();
        int L = scanner.nextInt();

        List<Fragment> s_frags = new ArrayList<>();
        long start = 1;
        for (int i = 0; i < M; i++) {
            char ch = scanner.next().charAt(0);
            long len = scanner.nextLong();
            long end = start + len - 1;
            s_frags.add(new Fragment(ch, start, end));
            start = end + 1;
        }

        List<Fragment> t_frags = new ArrayList<>();
        start = 1;
        for (int i = 0; i < L; i++) {
            char ch = scanner.next().charAt(0);
            long len = scanner.nextLong();
            long end = start + len - 1;
            t_frags.add(new Fragment(ch, start, end));
            start = end + 1;
        }

        long D_r = Ra - Rt;
        long D_c = Ca - Ct;

        int s_idx = 0, t_idx = 0;
        long t_cur = 0;
        long delta_r = 0, delta_c = 0;
        long count = 0;

        while (t_cur < N) {
            long s_end_val = (s_idx < s_frags.size()) ? s_frags.get(s_idx).end : Long.MAX_VALUE;
            long t_end_val = (t_idx < t_frags.size()) ? t_frags.get(t_idx).end : Long.MAX_VALUE;
            long block_end = Math.min(s_end_val, t_end_val);
            if (block_end > N) block_end = N;

            char s_ch = (s_idx < s_frags.size()) ? s_frags.get(s_idx).ch : 'X';
            char t_ch = (t_idx < t_frags.size()) ? t_frags.get(t_idx).ch : 'X';

            long step_r_s = 0, step_c_s = 0;
            if (s_ch == 'U') step_r_s = -1;
            else if (s_ch == 'D') step_r_s = 1;
            else if (s_ch == 'L') step_c_s = -1;
            else if (s_ch == 'R') step_c_s = 1;

            long step_r_t = 0, step_c_t = 0;
            if (t_ch == 'U') step_r_t = -1;
            else if (t_ch == 'D') step_r_t = 1;
            else if (t_ch == 'L') step_c_t = -1;
            else if (t_ch == 'R') step_c_t = 1;

            long step_dr = step_r_s - step_r_t;
            long step_dc = step_c_s - step_c_t;

            long T_steps = block_end - t_cur;

            long dr0 = delta_r;
            long dc0 = delta_c;
            long dr_diff = D_r - dr0;
            long dc_diff = D_c - dc0;

            if (step_dr == 0 && step_dc == 0) {
                if (dr_diff == 0 && dc_diff == 0) {
                    count += T_steps;
                }
            } else if (step_dr == 0) {
                if (dr_diff == 0) {
                    if (dc_diff % step_dc == 0) {
                        long k = dc_diff / step_dc;
                        if (k >= 1 && k <= T_steps) {
                            count++;
                        }
                    }
                }
            } else if (step_dc == 0) {
                if (dc_diff == 0) {
                    if (dr_diff % step_dr == 0) {
                        long k = dr_diff / step_dr;
                        if (k >= 1 && k <= T_steps) {
                            count++;
                        }
                    }
                }
            } else {
                if (dr_diff % step_dr == 0 && dc_diff % step_dc == 0) {
                    long k_r = dr_diff / step_dr;
                    long k_c = dc_diff / step_dc;
                    if (k_r == k_c && k_r >= 1 && k_r <= T_steps) {
                        count++;
                    }
                }
            }

            delta_r += step_dr * T_steps;
            delta_c += step_dc * T_steps;
            t_cur = block_end;

            if (s_idx < s_frags.size() && block_end == s_frags.get(s_idx).end) {
                s_idx++;
            }
            if (t_idx < t_frags.size() && block_end == t_frags.get(t_idx).end) {
                t_idx++;
            }
        }

        out.println(count);
    }

    static class Fragment {
        char ch;
        long start;
        long end;

        Fragment(char ch, long start, long end) {
            this.ch = ch;
            this.start = start;
            this.end = end;
        }
    }
}
/*
D - RLE Moving
https://atcoder.jp/contests/abc421/tasks/abc421_d

题目大意：
最初，高桥位于 (Rt,Ct) 单元，青木位于 (Ra,Ca) 单元。他们将根据长度为 N 的字符串 S 和 T （由 `U`、`D`、`L`、`R` 组成）分别下出 N 步。
对于每个 i ，高桥和青木的 i-th 移动同时发生：如果 S 的 i-th字符是 "U"，高桥就会向上移动一格，如果是 "D"，他就会向下移动一格，如果是 "L"，他就会向左移动一格，如果是 "R"，他就会向右移动一格；青木也会根据 T 的 i-th字符进行类似的移动。
求在 N 步棋中，高桥和青木紧接着下完一步后在同一格的次数。
由于 N 非常大， S 和 T 以 ((S'_1, A_1),...,(S'_M,A_M)) 和 ((T'_1,B_1),...,(T'_L,B_L)) 的形式给出，其中 S 是将 "字符 S'_1 的 A_1 份、 \dots 、字符 S'_M 的 A_M 份 "按此顺序串联起来得到的字符串， T 也是类似的形式。

https://yuanbao.tencent.com/chat/naQivTmsDa/b57d43eb-b1d4-46bf-9462-34e78cf2f248
======

Input 1
0 0 4 2
3 2 1
R 2
D 1
U 3
Output 1
1

Input 2
1000000000 1000000000 -1000000000 -1000000000
3000000000 3 3
L 1000000000
U 1000000000
U 1000000000
D 1000000000
R 1000000000
U 1000000000
Output 2
1000000001

Input 3
3 3 3 2
1 1 1
L 1
R 1
Output 3
0

Input 4
0 0 0 0
1 1 1
L 1
R 1
Output 4
0
 */
