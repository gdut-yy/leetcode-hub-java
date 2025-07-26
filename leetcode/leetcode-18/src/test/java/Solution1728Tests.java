import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1728Tests {
    private final Solution1728 solution1728 = new Solution1728();

    @Test
    public void example1() {
        String[] grid = {"####F", "#C...", "M...."};
        int catJump = 1;
        int mouseJump = 2;
        Assertions.assertTrue(solution1728.canMouseWin(grid, catJump, mouseJump));
    }

    @Test
    public void example2() {
        String[] grid = {"M.C...F"};
        int catJump = 1;
        int mouseJump = 4;
        Assertions.assertTrue(solution1728.canMouseWin(grid, catJump, mouseJump));
    }

    @Test
    public void example3() {
        String[] grid = {"M.C...F"};
        int catJump = 1;
        int mouseJump = 3;
        Assertions.assertFalse(solution1728.canMouseWin(grid, catJump, mouseJump));
    }

    @Test
    public void example4() {
        String[] grid = {"C...#", "...#F", "....#", "M...."};
        int catJump = 2;
        int mouseJump = 5;
        Assertions.assertFalse(solution1728.canMouseWin(grid, catJump, mouseJump));
    }

    @Test
    public void example5() {
        String[] grid = {".M...", "..#..", "#..#.", "C#.#.", "...#F"};
        int catJump = 3;
        int mouseJump = 1;
        Assertions.assertTrue(solution1728.canMouseWin(grid, catJump, mouseJump));
    }
}