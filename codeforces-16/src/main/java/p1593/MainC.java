package p1593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class MainC {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String[] line1 = reader.readLine().split(" ");
            int n = Integer.parseInt(line1[0]);
            int k = Integer.parseInt(line1[1]);
            int[] nums = new int[k];
            String[] line2 = reader.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                nums[j] = Integer.parseInt(line2[j]);
            }
            int res = solution(n, nums);
            writer.write(String.valueOf(res));
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static int solution(int n, int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (cnt + n - nums[i] < n) {
                cnt += n - nums[i];
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
/*
3
10 6
8 7 5 4 9 4
2 8
1 1 1 1 1 1 1 1
12 11
1 2 3 4 5 6 7 8 9 10 11

3
1
4

 */