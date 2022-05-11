class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         for (int i = 0; i < matrix.length; i++) {
            if (target > matrix[i][matrix[i].length - 1]) {
                continue;
            }
            int left = 0, right = matrix[i].length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}