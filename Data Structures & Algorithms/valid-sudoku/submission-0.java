class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> visitedSet = new HashSet<>();

        // check if any of the rows have any duplicates
        for (int row = 0; row < board.length; row++) {
            visitedSet.clear();
            for (int column = 0; column < board[row].length; column++) {
                char current = board[row][column];
                if (current == '.')
                    continue;
                int intValue = Integer.valueOf(String.valueOf(current));
                if (!visitedSet.add(intValue))
                    return false;
            }
        }

        // check if any of the columns have any duplicates
        for (int column = 0; column < board[0].length; column++) {
            visitedSet.clear();
            for (int row = 0; row < board.length; row++) {
                char current = board[row][column];
                if (current == '.')
                    continue;
                int intValue = Integer.valueOf(String.valueOf(current));
                if (!visitedSet.add(intValue))
                    return false;
            }
        }

        // check if any of the 9 3x3 boxes have any duplicates
        for (int row = 0; row < 9; row += 3) {
            for (int column = 0; column < 9; column += 3) {
                if (!runDedupCheckOn2DArray(row, row + 2, column, column + 2, board))
                    return false;
            }
        }

        return true;   
    }

    private static boolean runDedupCheckOn2DArray(int startRow, int endRow, int startCol, int endCol, char[][] board) {
        Set<Integer> visitedSet = new HashSet<>();
        for (int row = startRow; row <= endRow; row++) {
            for (int column = startCol; column <= endCol; column++) {
                char current = board[row][column];
                if (current == '.')
                    continue;
                int intValue = Integer.valueOf(String.valueOf(current));
                if (!visitedSet.add(intValue))
                    return false;
            }
        }
        return true;
    }

}
