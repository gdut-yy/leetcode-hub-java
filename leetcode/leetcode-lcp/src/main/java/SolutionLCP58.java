public class SolutionLCP58 {
    // 每个面的起始位置
    private static final int[][] CUBE_BASE = {
            {0, 0, 0},
            {0, 0, 1},
            {1, 0, 1},
            {0, 0, 1},
            {0, 0, 1},
            {0, 1, 1},
    };
    // 每个面 xyz 的增加“方向”
    private static final int[][] CUBE_DIR = {
            {1, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 1, 0},
            {0, 0, -1, 0, 1, 0},
            {0, 0, -1, 0, 1, 0},
            {0, 0, -1, 1, 0, 0},
            {0, 0, -1, 1, 0, 0},
    };
    // 形状旋转后的起始位置
    private static final int[][] SHAPE_BASE = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    // 形状旋转后行和列的增加“方向”
    private static final int[][] SHAPE_DIR = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    private int n;
    private String[][] shapes;
    // 整个立方体有哪些位置被占用了
    private boolean[][][] A;
    // 哪些面被占用了
    private boolean[] used;

    public boolean composeCube(String[][] shapes) {
        n = shapes[0].length;
        int expected = n * n * n - (n - 2) * (n - 2) * (n - 2);
        int actual = 0;
        for (String[] shape : shapes) {
            for (String s : shape) {
                for (char ch : s.toCharArray()) {
                    actual += ch - '0';
                }
            }
        }
        if (expected != actual) {
            return false;
        }

        this.shapes = shapes;
        A = new boolean[10][10][10];
        used = new boolean[6];
        return dfs(0);
    }

    // x：哪个形状
    // k：哪个面
    // s：哪种旋转
    // rc：行列是否交换
    // modify：0 = 检查是否占用；1 = 占用；-1 = 取消占用
    private boolean gao(int x, int k, int s, boolean rc, int modify) {
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                int i = CUBE_BASE[k][0] * (n - 1) + CUBE_DIR[k][0] * a + CUBE_DIR[k][3] * b;
                int j = CUBE_BASE[k][1] * (n - 1) + CUBE_DIR[k][1] * a + CUBE_DIR[k][4] * b;
                int z = CUBE_BASE[k][2] * (n - 1) + CUBE_DIR[k][2] * a + CUBE_DIR[k][5] * b;
                int si = SHAPE_BASE[s][0] * (n - 1) + SHAPE_DIR[s][0] * (rc ? b : a);
                int sj = SHAPE_BASE[s][1] * (n - 1) + SHAPE_DIR[s][1] * (rc ? a : b);
                if (shapes[x][si].charAt(sj) == '1') {
                    if (modify == 1) {
                        A[i][j][z] = true;
                    } else if (modify == -1) {
                        A[i][j][z] = false;
                    } else if (A[i][j][z]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean dfs(int x) {
        if (x == 6) {
            return true;
        }
        for (int k = 0; k < 6; k++) {
            if (used[k]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 1; j++) {
                    if (!gao(x, k, i, j == 1, 0)) {
                        continue;
                    }
                    gao(x, k, i, j == 1, 1);
                    used[k] = true;
                    if (dfs(x + 1)) {
                        return true;
                    }
                    used[k] = false;
                    gao(x, k, i, j == 1, -1);
                }
            }
        }
        return false;
    }
}
/*
LCP 58. 积木拼接
https://leetcode.cn/problems/De4qBB/

LCCUP 力扣杯 2022 春季编程大赛战队赛 T4。

欢迎各位勇者来到力扣城，本次试炼主题为「积木拼接」。
勇者面前有 6 片积木（厚度均为 1），每片积木的形状记录于二维字符串数组 shapes 中，shapes[i] 表示第 i 片积木，其中 1 表示积木对应位置无空缺，0 表示积木对应位置有空缺。
例如 ["010","111","010"] 对应积木形状为
拼接积木的规则如下：
- 积木片可以旋转、翻面
- 积木片边缘必须完全吻合才能拼接在一起
- 每片积木片 shapes[i] 的中心点在拼接时必须处于正方体对应面的中心点
例如 3*3、4*4 的积木片的中心点如图所示（红色点）：
请返回这 6 片积木能否拼接成一个严丝合缝的正方体且每片积木正好对应正方体的一个面。
注意：
- 输入确保每片积木均无空心情况（即输入数据保证对于大小 N*N 的 shapes[i]，内部的 (N-2)*(N-2) 的区域必然均为 1）
- 输入确保每片积木的所有 1 位置均连通
提示：
shapes.length == 6
shapes[i].length == shapes[j].length
shapes[i].length == shapes[i][j].length
3 <= shapes[i].length <= 10

搜索 & 模拟 https://leetcode.cn/problems/De4qBB/solution/mo-ni-by-tsreaper-k7rl/
 */