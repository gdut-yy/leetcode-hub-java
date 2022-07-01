import org.junit.jupiter.api.Test;

public class Solution1756Tests {
    @Test
    public void example1() {
        // 初始化队列为 [1,2,3,4,5,6,7,8]。
        Solution1756.MRUQueue mRUQueue = new Solution1756.MRUQueue(8);
        // 将第 3 个元素 (3) 移到队尾，使队列变为 [1,2,4,5,6,7,8,3] 并返回该元素。
        mRUQueue.fetch(3);
        // 将第 5 个元素 (6) 移到队尾，使队列变为 [1,2,4,5,7,8,3,6] 并返回该元素。
        mRUQueue.fetch(5);
        // 将第 2 个元素 (2) 移到队尾，使队列变为 [1,4,5,7,8,3,6,2] 并返回该元素。
        mRUQueue.fetch(2);
        // 第 8 个元素 (2) 已经在队列尾部了，所以直接返回该元素即可。
        mRUQueue.fetch(8);
    }
}
