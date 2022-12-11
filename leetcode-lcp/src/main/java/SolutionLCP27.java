public class SolutionLCP27 {
    static class BlackBox {
        private final int n;
        private final int m;
        private final int[] data;

        // https://leetcode.cn/problems/IQvJ9i/solution/qi-shi-jiu-shi-yi-ge-shu-xue-wen-ti-zhao-pnxh/
        public BlackBox(int n, int m) {
            this.n = n;
            this.m = m;
            this.data = new int[2 * (n + m)];
        }

        public int open(int index, int direction) {
            data[index] = 1;
            int target = reflectTo(index, direction);
            return target == -1 ? index : target;
        }

        public void close(int index) {
            this.data[index] = 0;
        }

        private int reflectTo(int index, int direction) {
            while (true) {
                int nextIndex = -1;
                // 方向为 1 时带入公式 2m+2n-index
                if (direction > 0) {
                    nextIndex = 2 * (m + n) - index;
                }
                // 方向为 -1 时带入公式 2m-index
                else {
                    nextIndex = 2 * m - index;
                }
                // 纠正方向为 -1 时结果为负数的情况，实际公式为 4m+2n-index
                if (nextIndex < 0) {
                    nextIndex += 2 * (m + n);
                }

                // 检查该点位是否打开，打开则直接返回
                if (data[nextIndex] == 1) {
                    return nextIndex;
                }
                // 未打开，但该点位为角，返回 -1 表示将沿原路返回初始点位
                if (nextIndex == 0 || nextIndex == m || nextIndex == m + n || nextIndex == m + n + m) {
                    return -1;
                }
                // 否则将继续遍历
                index = nextIndex;
                direction = -direction;
            }
        }
    }
}
/*
LCP 27. 黑盒光线反射
https://leetcode.cn/problems/IQvJ9i/

秋日市集上有个奇怪的黑盒，黑盒的主视图为 n*m 的矩形。从黑盒的主视图来看，黑盒的上面和下面各均匀分布有 m 个小孔，黑盒的左面和右面各均匀分布有 n 个小孔。
黑盒左上角小孔序号为 0，按顺时针编号，总共有 2*(m+n) 个小孔。每个小孔均可以打开或者关闭，初始时，所有小孔均处于关闭状态。每个小孔上的盖子均为镜面材质。例如一个 2*3 的黑盒主视图与其小孔分布如图所示:
店长告诉小扣，这里是「几何学的快问快答」，店长可能有两种操作：
- open(int index, int direction) - 若小孔处于关闭状态，则打开小孔，照入光线；否则直接照入光线；
- close(int index) - 关闭处于打开状态小孔，店长保证不会关闭已处于关闭状态的小孔；
其中：
- index： 表示小孔序号
- direction：1 表示光线沿 y=xy=x 方向，-1 表示光线沿 y=-xy=−x 方向。
当光线照至边界时：若边界上的小孔为开启状态，则光线会射出；否则，光线会在小孔之间进行反射。特别地：
1. 若光线射向未打开的拐角（黑盒顶点），则光线会原路反射回去；
2. 光线自拐角处的小孔照入时，只有一种入射方向（如自序号为 0 的小孔照入方向只能为 -1）
请帮助小扣判断并返回店长每次照入的光线从几号小孔射出。
提示：
1 <= n, m <= 10000
1 <= 操作次数 <= 10000
direction 仅为 1 或 -1
0 <= index < 2*(m+n)
 */