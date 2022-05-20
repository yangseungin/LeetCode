class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (word.length() == index) {
            return true;
        }

        int row = board.length, col = board[0].length;
        //배열범위내, 방문여부체크
        if ((i < 0 || i >= row) || (j < 0 || j >= col) || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        //상하좌우체크
        boolean check = dfs(board, visited, i + 1, j, word, index + 1) ||
                dfs(board, visited, i - 1, j, word, index + 1) ||
                dfs(board, visited, i, j + 1, word, index + 1) ||
                dfs(board, visited, i, j - 1, word, index + 1);

        visited[i][j] = false;

        return check;
    }
}