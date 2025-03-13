import java.util.*;

public class Leetcode54 {

}

// 螺旋矩阵
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        List<Integer> order = new ArrayList<Integer>();

        if (matrix == null || m == 0 || n == 0) {
            return order;
        }

        boolean[][] visited = new boolean[m][n];
        int total = m * n;

        int x = 0, y = 0;
        // 四个方向
        int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int index = 0;

        for (int i = 0; i < total; i++) {
            order.add(matrix[x][y]);
            visited[x][y] = true;

            // 计算下一个位置
            int a = x + direction[index][0];
            int b = y + direction[index][1];

            // 下一个位置是否有效
            if (a < 0 || a >= m || b < 0 || b >= n || visited[a][b]) {
                index = (index + 1) % 4;
            }

            x += direction[index][0];
            y += direction[index][1];
        }
        return order;
    }
}

// 按层模拟
// 将矩阵看成若干层
class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom) {
            // 向右
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            // 向下
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                // 向左
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                // 向上
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            // 向内一层
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
