import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3885Tests {
    @Test
    public void example1() {
        int[][] events = UtUtils.stringToInts2("[[5,7], [2,7], [9,4]]");

        // 使用三个事件初始化管理器
        Solution3885.EventManager eventManager = new Solution3885.EventManager(events);

        // 两个事件 5 和 2 的优先级均为 7，因此返回 id 最小的事件 2
        Assertions.assertEquals(2, eventManager.pollHighest());

        // 将事件 9 的优先级更新为 7
        eventManager.updatePriority(9, 7);

        // 剩下的优先级最高的事件是 5 和 9，返回 5
        Assertions.assertEquals(5, eventManager.pollHighest());

        // 返回 9
        Assertions.assertEquals(9, eventManager.pollHighest());
    }

    @Test
    public void example2() {
        int[][] events = UtUtils.stringToInts2("[[4,1], [7,2]]");

        // 使用两个事件初始化管理器
        Solution3885.EventManager eventManager = new Solution3885.EventManager(events);
        // 返回 7
        Assertions.assertEquals(7, eventManager.pollHighest());
        // 返回 4
        Assertions.assertEquals(4, eventManager.pollHighest());
        // 没有剩余事件，返回 -1
        Assertions.assertEquals(-1, eventManager.pollHighest());
    }
}