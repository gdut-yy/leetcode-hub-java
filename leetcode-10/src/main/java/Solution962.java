import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution962 {
    public int maxWidthRamp(int[] nums) {
        int len = nums.length;

        List<Integer> idx = new ArrayList<>(IntStream.range(0, len).boxed().toList());
        idx.sort(Comparator.comparingInt(o -> nums[o]));

        int max = 0;
        int min = len;
        for (int x : idx) {
            max = Math.max(max, x - min);
            min = Math.min(min, x);
        }
        return max;
    }
}
