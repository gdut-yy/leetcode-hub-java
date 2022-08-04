package p1650;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CF1650E {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
//        int t = Integer.parseInt(reader.readLine());
//        for (int i = 0; i < t; i++) {
//            reader.readLine();
//            String line1 = reader.readLine();
//            String line2 = reader.readLine();
//            writer.write(solution(line1, line2).concat(System.lineSeparator()));
//        }
//        writer.close();
//        reader.close();

        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 0));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 1));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 2));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 3));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 4));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 5));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 6));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 7));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 8));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 9));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 10));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 11));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 12));
        System.out.println(checkMid(3, 12, new int[]{3, 5, 9}, 13));

//        System.out.println(checkMid(2, new int[]{3, 5, 9}, 13));
    }

    private static String solution(String line1, String line2) {
        String[] line1s = line1.split(" ");
        int n = Integer.parseInt(line1s[0]);
        int d = Integer.parseInt(line1s[1]);
        String[] line2s = line2.split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line2s[i]);
        }

        int left = 0;
        int right = d;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(n, d, a, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left - 1);
    }

    private static boolean checkMid(int n, int d, int[] a, int mid) {
        int[] aCopy = a.clone();
        int pre = 0;

        // 一次调整机会
        boolean change = false;
        for (int i = 0; i < n; i++) {
            // 3-0-1=2 < 2
            if (aCopy[i] - pre - 1 < mid && !change) {
                aCopy[i] = mid + pre + 1;
                if (i + 1 < n && aCopy[i] > aCopy[i + 1]) {
                    return false;
                }
                pre = aCopy[i];
            } else {
                return false;
            }
        }
        if (d - aCopy[n - 1] - 1 < mid) {
            return false;
        }
        return true;
    }
}
/*
9

3 12
3 5 9

2 5
1 5

2 100
1 2

5 15
3 6 9 12 15

3 1000000000
1 400000000 500000000

2 10
3 4

2 2
1 2

4 15
6 11 12 13

2 20
17 20


2
1
1
2
99999999
3
0
1
9

 */