import org.junit.jupiter.api.Test;

public class Solution489Tests {
    Solution489.Robot robot = new Solution489.Robot() {
        int[][] room = {
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        int row = 1;
        int col = 3;

        @Override
        public boolean move() {
            return false;
        }

        @Override
        public void turnLeft() {

        }

        @Override
        public void turnRight() {

        }

        @Override
        public void clean() {

        }
    };

    @Test
    public void example1() {
        Solution489 solution489 = new Solution489();
        solution489.cleanRoom(robot);
    }
}
