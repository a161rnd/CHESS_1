public class Bishop extends ChessPiece {

    public boolean legalMove = false;

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

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

        if ((checkPieseStartStopPosition(line, column, toLine, toColumn) &&
                (Math.abs(toLine - line) == Math.abs(toColumn - column)) && ((line != toLine) && column != toColumn)))

        {
            if (diagonalDirection == 1) // слева - направо, снизу вверз (или наоборот)
                for (int s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
                    cntColumn++;
                    if (chessBoard.board[s][Math.min(column, toColumn) + cntColumn] == null) return true; else return false;
                }

            if (diagonalDirection == 2)     // справа - налево, снизу вверх
                for (int s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
                    cntColumn--;
                    if (chessBoard.board[s][Math.max(column, toColumn) + cntColumn] == null) return true; else return false;
                }

            if (diagonalDirection == 3)  // слева ноправо, сверху вниз
                for (int s = Math.min(column, toColumn) + 1; s < Math.max(column, toColumn); s++) {
                    cntLine--;
                    if (chessBoard.board[Math.max(line, toLine) + cntLine][s] == null) return true; else return false;
                }
            return true;
        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "B";
    }


}
