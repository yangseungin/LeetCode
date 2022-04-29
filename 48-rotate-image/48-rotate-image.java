class Solution {
    public void rotate(int[][] matrix) {
         int[][] rotateArr = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int[] tmp = new int[matrix[i].length];
            int tmpCount = 0;
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                tmp[tmpCount++] = matrix[j][i];
            }
            rotateArr[i] = tmp;
        }

        for (int i = 0; i < rotateArr.length; i++) {
            System.arraycopy(rotateArr[i], 0, matrix[i], 0, matrix[0].length);
        }
    }
}