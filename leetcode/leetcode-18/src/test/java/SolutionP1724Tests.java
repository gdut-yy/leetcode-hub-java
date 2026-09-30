import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1724Tests {
    @Test
    public void example1() {
        int n = 6;
        int[][] edgeList = UtUtils.stringToInts2("[[0,2,4],[0,3,2],[1,2,3],[2,3,1],[4,5,5]]");
        SolutionP1724.DistanceLimitedPathsExist distanceLimitedPathsExist =
                new SolutionP1724.DistanceLimitedPathsExist(n, edgeList);

        // 返回 true。存在一条从 2 到 3 ，距离为 1 的边，这条边的距离小于 2。
        Assertions.assertTrue(distanceLimitedPathsExist.query(2, 3, 2));

        // 返回 false。从 1 到 3 之间不存在每条边的距离都严格小于 3 的路径。
        Assertions.assertFalse(distanceLimitedPathsExist.query(1, 3, 3));

        // 返回 true。存在一条从 2 到 0 的路径，使得每条边的距离 < 3：从 2 到 3 到 0 行进即可。
        Assertions.assertTrue(distanceLimitedPathsExist.query(2, 0, 3));

        // 返回 false。从 0 到 5 之间不存在路径。
        Assertions.assertFalse(distanceLimitedPathsExist.query(0, 5, 6));
    }
}
