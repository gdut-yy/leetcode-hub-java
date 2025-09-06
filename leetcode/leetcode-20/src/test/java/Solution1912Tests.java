import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1912Tests {
    @Test
    public void example1() {
        int n = 3;
        int[][] entries = UtUtils.stringToInts2("[[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]");
        Solution1912.MovieRentingSystem movieRentingSystem = new Solution1912.MovieRentingSystem(n, entries);

        // 返回 [1, 0, 2] ，商店 1，0 和 2 有未借出的 ID 为 1 的电影。商店 1 最便宜，商店 0 和 2 价格相同，所以按商店编号排序。
        Assertions.assertEquals(List.of(1, 0, 2), movieRentingSystem.search(1));

        // 从商店 0 借出电影 1 。现在商店 0 未借出电影编号为 [2,3] 。
        movieRentingSystem.rent(0, 1);

        // 从商店 1 借出电影 2 。现在商店 1 未借出的电影编号为 [1] 。
        movieRentingSystem.rent(1, 2);

        // 返回 [[0, 1], [1, 2]] 。商店 0 借出的电影 1 最便宜，然后是商店 1 借出的电影 2 。
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0, 1], [1, 2]]");
        Assertions.assertEquals(expected, movieRentingSystem.report());

        // 在商店 1 返还电影 2 。现在商店 1 未借出的电影编号为 [1,2] 。
        movieRentingSystem.drop(1, 2);

        // 返回 [0, 1] 。商店 0 和 1 有未借出的 ID 为 2 的电影。商店 0 最便宜，然后是商店 1 。
        Assertions.assertEquals(List.of(0, 1), movieRentingSystem.search(2));
    }
}