public class Solution832 {
    public int[][] flipAndInvertImage(int[][] image) {
        int imageM = image.length;
        int imageN = image[0].length;
        for (int i = 0; i < imageM; i++) {
            // 水平翻转图像
            for (int j = 0; j < imageN / 2; j++) {
                int tmp = image[i][j];
                image[i][j] = image[i][imageN - 1 - j];
                image[i][imageN - 1 - j] = tmp;
            }
            // 反转图像
            for (int j = 0; j < imageN; j++) {
                if (image[i][j] == 0) {
                    image[i][j] = 1;
                } else {
                    image[i][j] = 0;
                }
            }
        }
        return image;
    }
}
/*
832. 翻转图像
https://leetcode.cn/problems/flipping-an-image/

第 84 场周赛 T1。

给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

根据题意进行模拟即可
 */
