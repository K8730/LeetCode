public class Leetcode73 {

}

// 矩阵置零

// 用数组标记哪一行列需要刷成 0
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

// 借用矩阵的第一行和第一列充当标记数组
class Solution2 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 第 0 行和第 0 列单独标记
        boolean flag_col0 = false, flag_row0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flag_col0 = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                flag_row0 = true;
                break;
            }
        }
        // 从后往前遍历，找到应该刷零的行列
        for (int i = m - 1; i > 0; i--) {
            for (int j = n - 1; j > 0; j--) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 将行列刷零
        for (int i = m - 1; i > 0; i--) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        // 第 0 行和第 0 列
        if (flag_col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flag_row0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}