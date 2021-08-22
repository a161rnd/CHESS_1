public abstract class ChessPiece {

     String color;
    boolean check = true;  //  checkCastling can be castled if move is first, then it becomes to false

//    int line ;
//    int toLine;
//    int column;
//    int toColumn;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();


    public boolean checkMove(int pos) {
        return pos >= 0 && pos <= 7;
    }

        public boolean checkPieseStartStopPosition(int line, int column, int toLine, int toColumn) {

        if
        (checkMove(toLine) && checkMove(toColumn) && checkMove(line) && checkMove(column))  {

            return true;
        }

        return false;
    }

//     boolean checkStraightDirection(ChessPiece[][] chessBoard, int line, int column, int toLine, int toColumn) {
//
//        int straightlDirection = 0;
//
//        {
//            if
//            (toLine == line && toColumn != column) straightlDirection = 1; // горизонт направл
//            if (toLine != line && toColumn == column) straightlDirection = 2; // вертик направ
//        }
//
//        if (straightlDirection == 1) // горизонт
//            for (int s = Math.min(column, toColumn) + 1; s < Math.max(column, toColumn); s++) {
//                if (chessBoard[line][s] == null) return true;
//            }
//
//        if (straightlDirection == 2)  // вертикал
//            for (int s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
//                if (chessBoard[s][column] == null) return true;
//            }
//        return false;
//
//    }
//
//
//     boolean checkDiagonalDirection(ChessPiece[][] chessBoard, int line, int column, int toLine, int toColumn) {
//
//        int diagonalDirection = 0;
//        int cntLine = 0;
//        int cntColumn = 0;
//        {
//            if
//            ((toLine - line > 0 && toColumn - column > 0) || (toLine - line < 0 && toColumn - column < 0))
//                diagonalDirection = 1; // слева - направо, снизу вверз (или наоборот)
//            if (toColumn - column < 0 && toLine - line > 0) diagonalDirection = 2; // справа - налево, снизу вверх
//            else if (toColumn - column > 0 && toLine - line < 0) diagonalDirection = 3; // слева ноправо, сверху вниз
//        }
//
//        if (diagonalDirection == 1) // слева - направо, снизу вверз (или наоборот)
//            for (int s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
//                cntColumn++;
//                if (chessBoard[s][Math.min(column, toColumn) + cntColumn] == null) return true;
//            }
//
//        if (diagonalDirection == 2)     // справа - налево, снизу вверх
//            for (int s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
//                cntColumn--;
//                if (chessBoard[s][Math.max(column, toColumn) + cntColumn] == null) return true;
//            }
//
//        if (diagonalDirection == 3)  // слева ноправо, сверху вниз
//            for (int s = Math.min(column, toColumn) + 1; s < Math.max(column, toColumn); s++) {
//                cntLine--;
//                if (chessBoard[Math.max(line, toLine) + cntLine][s] == null) return true;
//            }
//        return false;
//    }

}