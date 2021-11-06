import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution342 {
    public boolean isPowerOfFour(int n) {
        int[] nums = {1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576, 4194304, 16777216, 67108864,
                268435456, 1073741824};
        Set<Integer> hashSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return hashSet.contains(n);
    }
}
/*
342. 4的幂
https://leetcode-cn.com/problems/power-of-four/

给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x

打表。
相似题目: 231. 2 的幂
https://leetcode-cn.com/problems/power-of-two/
326. 3的幂
https://leetcode-cn.com/problems/power-of-three/
 */