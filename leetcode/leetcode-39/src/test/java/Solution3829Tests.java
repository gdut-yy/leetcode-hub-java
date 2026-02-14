import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3829Tests {
    @Test
    public void example1() {
        // 初始化系统
        Solution3829.RideSharingSystem rideSharingSystem = new Solution3829.RideSharingSystem();

        // 乘客 3 加入队列
        rideSharingSystem.addRider(3);

        // 司机 2 加入队列
        rideSharingSystem.addDriver(2);

        // 乘客 1 加入队列
        rideSharingSystem.addRider(1);

        // 返回 [2, 3]
        Assertions.assertArrayEquals(new int[]{2, 3}, rideSharingSystem.matchDriverWithRider());

        // 司机 5 变为可用
        rideSharingSystem.addDriver(5);

        // 乘客 3 已被匹配，取消操作无效
        rideSharingSystem.cancelRider(3);

        // 返回 [5, 1]
        Assertions.assertArrayEquals(new int[]{5, 1}, rideSharingSystem.matchDriverWithRider());

        // 返回 [-1, -1]
        Assertions.assertArrayEquals(new int[]{-1, -1}, rideSharingSystem.matchDriverWithRider());
    }
}