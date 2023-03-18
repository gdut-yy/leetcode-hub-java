package c277;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.TreeMap;

public class Abc277_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        long sum = 0L;
        // remain
        TreeMap<Integer, Long> map = new TreeMap<>();
        for (int x : A) {
            sum += x;
            int remain = x % M;
            map.put(remain, map.getOrDefault(remain, 0L) + x);
        }

        long max = 0L;
        for (Integer key = map.firstKey(); key != null; key = map.higherKey(key)) {
            max = Math.max(max, map.get(key));
            if (map.containsKey(key + 1)) {
                map.put(key + 1, map.get(key + 1) + map.get(key));
                map.put(key, 0L);
                max = Math.max(max, map.get(key + 1));
            }
        }
        // 两遍松弛
        if (map.lastKey() == M - 1) {
            map.put(-1, map.get(M - 1));
            map.put(M - 1, 0L);
        }
        for (Integer key = map.firstKey(); key != null; key = map.higherKey(key)) {
            if (map.containsKey(key + 1)) {
                map.put(key + 1, map.get(key + 1) + map.get(key));
                map.put(key, 0L);
                max = Math.max(max, map.get(key + 1));
            }
        }
        System.out.println(sum - max);
    }
}
/*
D - Takahashi's Solitaire
https://atcoder.jp/contests/abc277/tasks/abc277_d
 */