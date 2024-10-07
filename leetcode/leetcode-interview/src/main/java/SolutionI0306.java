import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SolutionI0306 {
    static class AnimalShelf {
        Queue<int[]>[] qs;

        public AnimalShelf() {
            qs = new ArrayDeque[2];
            Arrays.setAll(qs, e -> new ArrayDeque<>());
        }

        public void enqueue(int[] animal) {
            int type = animal[1];
            qs[type].add(animal);
        }

        public int[] dequeueAny() {
            if (qs[0].isEmpty() && qs[1].isEmpty()) return new int[]{-1, -1};
            else if (qs[0].isEmpty()) return dequeueDog();
            else if (qs[1].isEmpty()) return dequeueCat();
            if (qs[0].peek()[0] < qs[1].peek()[0]) return dequeueCat();
            return dequeueDog();
        }

        public int[] dequeueDog() {
            if (qs[1].isEmpty()) return new int[]{-1, -1};
            return qs[1].remove();
        }

        public int[] dequeueCat() {
            if (qs[0].isEmpty()) return new int[]{-1, -1};
            return qs[0].remove();
        }
    }
}
/*'
面试题 03.06. 动物收容所
https://leetcode.cn/problems/animal-shelter-lcci/description/

动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
说明:
收纳所的最大容量为20000

两个队列模拟。
 */