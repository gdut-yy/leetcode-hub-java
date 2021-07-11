public class Solution319 {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
/*
319. 灯泡开关
https://leetcode-cn.com/problems/bulb-switcher/

初始时有 n 个灯泡处于关闭状态。
对某个灯泡切换开关意味着：如果灯泡状态为关闭，那该灯泡就会被开启；而灯泡状态为开启，那该灯泡就会被关闭。
第 1 轮，每个灯泡切换一次开关。即，打开所有的灯泡。
第 2 轮，每两个灯泡切换一次开关。 即，每两个灯泡关闭一个。
第 3 轮，每三个灯泡切换一次开关。
第 i 轮，每 i 个灯泡切换一次开关。 而第 n 轮，你只切换最后一个灯泡的开关。
找出 n 轮后有多少个亮着的灯泡。

平方根。

 */