import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3709Tests {
    @Test
    public void example1() {
        Solution3709.ExamTracker examTracker = new Solution3709.ExamTracker();

        // Alice 在时间 1 参加了一次新考试，获得了 98 分。
        examTracker.record(1, 98);

        // 在时间 1 和时间 1 之间，Alice 参加了 1 次考试，时间为 1，得分为 98。总分是 98。
        Assertions.assertEquals(98, examTracker.totalScore(1, 1));

        // Alice 在时间 5 参加了一次新考试，获得了 99 分。
        examTracker.record(5, 99);

        // 在时间 1 和时间 3 之间，Alice 参加了 1 次考试，时间为 1，得分为 98。总分是 98。
        Assertions.assertEquals(98, examTracker.totalScore(1, 3));

        // 在时间 1 和时间 5 之间，Alice 参加了 2 次考试，时间分别为 1 和 5，得分分别为 98 和 99。总分是 98 + 99 = 197。
        Assertions.assertEquals(197, examTracker.totalScore(1, 5));

        // 在时间 3 和时间 4 之间，Alice 没有参加任何考试。因此，答案是 0。
        Assertions.assertEquals(0, examTracker.totalScore(3, 4));

        // 在时间 2 和时间 5 之间，Alice 参加了 1 次考试，时间为 5，得分为 99。总分是 99。
        Assertions.assertEquals(99, examTracker.totalScore(2, 5));
    }
}