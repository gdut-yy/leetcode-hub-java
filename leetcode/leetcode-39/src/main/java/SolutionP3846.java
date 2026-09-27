public class SolutionP3846 {
    static String[] BOARD = {
            "qwertyuiop",
            "asdfghjkl ",
            "zxcvbnm   "
    };

    static int[][] KEYS;

    static {
        KEYS = new int[128][2];
        int n = BOARD.length;
        int m = BOARD[0].length();
        for (int i = 0; i < n; i++) {
            char[] row = BOARD[i].toCharArray();
            for (int j = 0; j < m; j++) {
                int c = row[j];
                KEYS[c][0] = i;
                KEYS[c][1] = j;
            }
        }
    }

    public int totalDistance(String s) {
        int x1 = KEYS['a'][0], y1 = KEYS['a'][1];
        int dist = 0;
        for (char c : s.toCharArray()) {
            int x2 = KEYS[c][0], y2 = KEYS[c][1];
            dist += Math.abs(x1 - x2) + Math.abs(y1 - y2);
            x1 = x2;
            y1 = y2;
        }
        return dist;
    }
}
/*
$3846. 使用单指输入字符串的总距离
https://leetcode.cn/problems/total-distance-to-type-a-string-using-one-finger/description/

有一个特殊的键盘，其按键排列成如下矩形网格。
q	w	e	r	t	y	u	i	o	p
a	s	d	f	g	h	j	k	l
z	x	c	v	b	n	m
给定一个只包含小写英文字母的字符串 s。返回一个整数，表示使用仅一个手指输入字符串 s 的总距离。手指初始位置在字母键 'a' 上。
两个位于 (r1, c1) 和 (r2, c2) 的按键距离是 |r1 - r2| + |c1 - c2|。
示例 1：
输入：s = "hello"
输出：17
示例 2：
输入：s = "a"
输出：0
提示：
1 <= s.length <= 10^4
s 只包含小写英文字母。
 */