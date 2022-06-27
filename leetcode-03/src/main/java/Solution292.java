public class Solution292 {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
/*
292. Nim 游戏
https://leetcode.cn/problems/nim-game/

如果开局碰到 4 的倍数，那就输了。同理，如果可以把对方控制在 4 的倍数里，则必胜。
 */