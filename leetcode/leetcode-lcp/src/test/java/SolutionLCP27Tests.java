import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP27Tests {
    @Test
    public void example1() {
        // 新建一个 2x3 的黑盒
        SolutionLCP27.BlackBox b = new SolutionLCP27.BlackBox(2, 3);

        // 打开 6 号小孔，并沿 y=-x 方向照入光线，光线至 0 号小孔反射，从 6 号小孔射出
        Assertions.assertEquals(6, b.open(6, -1));

        // 打开 4 号小孔，并沿 y=-x 方向照入光线，光线轨迹为 4-2-8-2-4，从 4 号小孔射出
        Assertions.assertEquals(4, b.open(4, -1));

        // 打开 0 号小孔，并沿 y=-x 方向照入光线，由于 6 号小孔为开启状态，光线从 6 号小孔射出
        Assertions.assertEquals(6, b.open(0, -1));

        // 关闭 6 号小孔
        b.close(6);

        // 从 0 号小孔沿 y=-x 方向照入光线，由于 6 号小孔为关闭状态，4 号小孔为开启状态，光线轨迹为 0-6-4，从 4 号小孔射出
        Assertions.assertEquals(4, b.open(0, -1));
    }

    @Test
    public void example2() {
        // 新建一个 3x3 的黑盒
        SolutionLCP27.BlackBox b = new SolutionLCP27.BlackBox(3, 3);

        // 打开 1 号小孔，并沿 y=-x 方向照入光线，光线轨迹为 1-5-7-11-1，从 1 号小孔射出
        Assertions.assertEquals(1, b.open(1, -1));

        // 打开 5 号小孔，并沿 y=x 方向照入光线，光线轨迹为 5-7-11-1，从 1 号小孔射出
        Assertions.assertEquals(1, b.open(5, 1));

        // 打开 11 号小孔，并沿逆 y=-x 方向照入光线，光线轨迹为 11-7-5，从 5 号小孔射出
        Assertions.assertEquals(5, b.open(11, -1));

        // 从 11 号小孔沿 y=x 方向照入光线，光线轨迹为 11-1，从 1 号小孔射出
        Assertions.assertEquals(1, b.open(11, 1));

        // 关闭 1 号小孔
        b.close(1);

        // 从 11 号小孔沿 y=x 方向照入光线，光线轨迹为 11-1-5，从 5 号小孔射出
        Assertions.assertEquals(5, b.open(11, 1));

        // 关闭 5 号小孔
        b.close(5);

        // 从 11 号小孔沿 y=-x 方向照入光线，光线轨迹为 11-1-5-7-11，从 11 号小孔射出
        Assertions.assertEquals(11, b.open(11, -1));
    }
}
