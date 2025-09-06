import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3391Tests {
    @Test
    public void example1() {
        // 初始化一个 3 x 3 x 3 的三维数组 matrix，用全 0 填充。
        SolutionP3391.Matrix3D matrix3D = new SolutionP3391.Matrix3D(3);

        // 将 matrix[0][0][0] 设为 1。
        matrix3D.setCell(0, 0, 0);

        // 返回 0。matrix[0] 1 的数量最多。
        Assertions.assertEquals(0, matrix3D.largestMatrix());

        // 将 matrix[1][1][2] 设为 1。
        matrix3D.setCell(1, 1, 2);

        // 返回 1。matrix[0] 和 matrix[1] 1 的数量一样多，但下标 1 更大。
        Assertions.assertEquals(1, matrix3D.largestMatrix());

        // 将 matrix[0][0][1] 设为 1。
        matrix3D.setCell(0, 0, 1);

        // 返回 0。matrix[0] 1 的数量最多。
        Assertions.assertEquals(0, matrix3D.largestMatrix());
    }

    @Test
    public void example2() {
        // 初始化一个 4 x 4 x 4 的三维数组 matrix，用全 0 填充。
        SolutionP3391.Matrix3D matrix3D = new SolutionP3391.Matrix3D(4);

        // 将 matrix[2][1][1] 设为 1。
        matrix3D.setCell(2, 1, 1);

        // 返回 2。matrix[2] 1 的数量最多。
        Assertions.assertEquals(2, matrix3D.largestMatrix());

        // 将 matrix[2][1][1] 设为 0。
        matrix3D.unsetCell(2, 1, 1);

        // 返回 3。0 到 3 的对应值都有相同数量的 1，但下标 3 最大。
        Assertions.assertEquals(3, matrix3D.largestMatrix());
    }
}