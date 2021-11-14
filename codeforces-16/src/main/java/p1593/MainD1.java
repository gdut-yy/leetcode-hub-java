package p1593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainD1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[] testcase = new int[n];
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                testcase[j] = Integer.parseInt(line[j]);
            }
            int res = solution(testcase);
            writer.write(String.valueOf(res));
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static int solution(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().distinct().collect(Collectors.toList());
        if (list.size() == 1) {
            return -1;
        }
        int res = list.get(1) - list.get(0);
        for (int i = 2; i < list.size(); i++) {
            res = getGCD(res, list.get(i) - list.get(i - 1));
        }
        return Math.abs(res);
    }

    private static int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
3
6
1 5 3 1 1 5
8
-1 0 1 -1 0 1 -1 0
4
100 -1000 -1000 -1000

2
1
1100


3
6
1 5 3 1 1 5
8
-1 0 1 -1 0 1 -1 0
4
-1000 -1000 -1000 -1000
 */