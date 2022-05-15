package p1676;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1676H2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            writer.write(solution(line1, line2).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line1, String line2) {
        int n = Integer.parseInt(line1);
        String[] line2s = line2.split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line2s[i]);
        }

        long cnt = 0;
        BIT bit = new BIT(new int[n]);
        for (int i = n - 1; i >= 0; i--) {
            bit.add(a[i], 1);
            cnt += bit.getsum(a[i]) - 1;
        }
        return String.valueOf(cnt);
    }

    private static class BIT {
        private final int N;
        private final int[] tree;

        // O(n) 建树
        public BIT(int[] nums) {
            this.N = nums.length;
            this.tree = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                tree[i] += nums[i - 1];
                int j = i + lowbit(i);
                if (j <= N) {
                    tree[j] += tree[i];
                }
            }
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        // nums[x] add k
        public void add(int x, int k) {
            while (x <= N) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        // nums [1,x] 的和
        public int getsum(int x) {
            int ans = 0;
            while (x >= 1) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
/*
H2. Maximum Crossings (Hard Version)
https://codeforces.com/contest/1676/problem/H2

题目大意：
同 CF1676H1。(n <= 10^5)

显然在 n <= 10^5 情况下，不能暴力了，需在时间复杂度 O(nlogn) 求救。
方法有 归并排序/树状数组/线段树。
======

input
4
7
4 1 4 6 7 7 5
2
2 1
1
1
3
2 2 2

output
6
1
0
3
 */