package p1582;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MainB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String[] lineT1 = reader.readLine().split(" ");
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(lineT1[j]);
            }
            long res = solution(nums);
            writer.write(String.valueOf(res));
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static long solution(int[] nums) {
        int cnt0 = 0;
        int cnt1 = 0;
        for (int num : nums) {
            if (num == 0) {
                cnt0++;
            } else if (num == 1) {
                cnt1++;
            }
        }
        if (cnt1 == 0) {
            return 0;
        }
        return (long) (Math.pow(2, cnt0) * cnt1);
    }
}
/*
5
5
1 2 3 4 5
2
1000 1000
2
1 0
5
3 0 2 1 1
5
2 1 0 3 0

1
0
2
4
4
 */