import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Solution710 {
    static class Solution {
        private final Map<Integer, Integer> b2w;
        private final Random random;
        private final int bound;

        public Solution(int n, int[] blacklist) {
            b2w = new HashMap<>();
            random = new Random();
            int m = blacklist.length;
            bound = n - m;
            Set<Integer> black = new HashSet<>();
            for (int b : blacklist) {
                if (b >= bound) {
                    black.add(b);
                }
            }

            int w = bound;
            for (int b : blacklist) {
                if (b < bound) {
                    while (black.contains(w)) {
                        ++w;
                    }
                    b2w.put(b, w);
                    ++w;
                }
            }
        }

        public int pick() {
            int x = random.nextInt(bound);
            return b2w.getOrDefault(x, x);
        }
    }
}
