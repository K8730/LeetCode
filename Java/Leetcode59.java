public class Leetcode59 {

}

// 螺旋矩阵 II

// 一条边一条边画出来
// 要点是每一个判定都遵循一样的规则
// 这处为 左闭右开
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0; // 每一圈的起始点
        int offset = 1;
        int count = 1; // 矩阵中需要填写的数字
        int loop = 1; // 记录当前的圈数
        int i, j; // j 代表列, i 代表行;

        while (loop <= n / 2) {

            // 顶部
            // 左闭右开，所以判断循环结束时， j 不能等于 n - offset
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            // 右列
            // 左闭右开，所以判断循环结束时， i 不能等于 n - offset
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            // 底部
            // 左闭右开，所以判断循环结束时， j != startY
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            // 左列
            // 左闭右开，所以判断循环结束时， i != startX
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) { // n 为奇数时，单独处理矩阵中心的值
            nums[startX][startY] = count;
        }
        return nums;
    }
}

// 用 int[][] direction 表示方向
class Solution2 {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];

        int x = 0, y = 0;
        int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int index = 0;

        for (int i = 1; i <= n * n; i++) {
            nums[x][y] = i;

            // 计算下一个位置
            int a = x + direction[index][0];
            int b = y + direction[index][1];

            // 判断下一个位置是否有效
            if (a < 0 || a >= n || b < 0 || b >= n || nums[a][b] != 0) {
                index = (index + 1) % 4;
            }
            x += direction[index][0];
            y += direction[index][1];
        }
        return nums;
    }
}