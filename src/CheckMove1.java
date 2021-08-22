public interface CheckMove1 {


    default boolean checkDiagonalDirection(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        int diagonalDirection = 0;
        int cntLine = 0;
        int cntColumn = 0;
        {
            if
            ((toLine - line > 0 && toColumn - column > 0) || (toLine - line < 0 && toColumn - column < 0))
                diagonalDirection = 1; // слева - направо, снизу вверз (или наоборот)
            if (toColumn - column < 0 && toLine - line > 0) diagonalDirection = 2; // справа - налево, снизу вверх
            else if (toColumn - column > 0 && toLine - line < 0) diagonalDirection = 3; // слева ноправо, сверху вниз
        }

        if (diagonalDirection == 1) // слева - направо, снизу вверз (или наоборот)
            for (int s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
                cntColumn++;
                if (chessBoard.board[s][Math.min(column, toColumn) + cntColumn] == null) return true;
            }

        if (diagonalDirection == 2)     // справа - налево, снизу вверх
            for (int s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
                cntColumn--;
                if (chessBoard.board[s][Math.max(column, toColumn) + cntColumn] == null) return true;
            }

        if (diagonalDirection == 3)  // слева ноправо, сверху вниз
            for (int s = Math.min(column, toColumn) + 1; s < Math.max(column, toColumn); s++) {
                cntLine--;
                if (chessBoard.board[Math.max(line, toLine) + cntLine][s] == null) return true;
            }
        return false;
    }

    default boolean checkStraightDirection(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        int straightlDirection = 0;

        {
            if
            (toLine == line && toColumn != column) straightlDirection = 1; // горизонт направл
            if (toLine != line && toColumn == column) straightlDirection = 2; // вертик направ
        }

        if (straightlDirection == 1) // горизонт
            for (int s = Math.min(column, toColumn) + 1; s < Math.max(column, toColumn); s++) {
                if (chessBoard.board[line][s] == null) return true;
            }

        if (straightlDirection == 2)  // вертикал
            for (int s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
                if (chessBoard.board[s][column] == null) return true;
            }
        return false;

    }
}
