public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        final int STARTWHITE = 1;
        final int STARTBLACK = 6;


        if ((color == "White") && /*возможность бить пешкой*/
                (checkPieseStartStopPosition(line, column, toLine, toColumn)) &&
                (chessBoard.board[toLine][toColumn] != null) &&
                ((toLine == line + 1) && (toColumn == column + 1 || toColumn == column - 1))) return true;

        if ((color == "Black") && /*возможность бить пешкой*/
                (checkPieseStartStopPosition(line, column, toLine, toColumn)) &&
                (chessBoard.board[toLine][toColumn] != null) &&
                ((toLine == line - 1) && (toColumn == column + 1 || toColumn == column - 1))) return true;

        if ((checkPieseStartStopPosition(line, column, toLine, toColumn)) && // корректность хода пешки, первого хода,запрет бить прямо
                (chessBoard.board[toLine][toColumn] == null) &&   (toLine != line && toColumn == column)) {
            if (((color == "White" && line > STARTWHITE && (toLine - line) == 1)) ||
                    ((color == "Black" && line < STARTBLACK && (line - toLine) == 1)))
                return true;
        } else return false;
        if ((checkPieseStartStopPosition(line, column, toLine, toColumn)) &&
                (chessBoard.board[toLine][toColumn] == null) &&   (toLine != line && toColumn == column)) {
            if (((color == "White" && line == STARTWHITE) && (((toLine - line) == 2) || ((toLine - line) == 1))) ||
                    (((color == "Black" && line == STARTBLACK)) && (((line - toLine) == 2) || ((line - toLine) == 1))))
                return true;
            else return false;
        } else return false;
    }


    @Override
    public String getSymbol() {
        return "P";
    }

}

