public class Leetcode240 {

}

// 搜索二维矩阵 II

// 从右上角开始找
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) {
            return false;
        }
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            }
        }
        return false;
    }
}