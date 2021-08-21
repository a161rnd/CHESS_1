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
        ChessBoard E = new ChessBoard("");

        final int STARTWHITE = 1;
        final int STARTBLACK = 6;
        if ((checkPieseStartStopPosition(line,column, toLine, toColumn)) &&
                (toLine != line && toColumn == column)) {
            if (((color == "White" && line > STARTWHITE && (toLine - line) == 1)) ||
                    ((color == "Black" && line < STARTBLACK && (line - toLine) == 1)))
            {E.board[line][column] = null; return true;}
        } else return false;
        if ((checkPieseStartStopPosition(line,column, toLine, toColumn)) &&
                (toLine != line && toColumn == column)) {
            if (((color == "White" && line == STARTWHITE) && (((toLine - line) == 2) || ((toLine - line) == 1))) ||
            (((color == "Black" && line == STARTBLACK)) && (((line - toLine) == 2) || ((line - toLine) == 1))))
            { E.board[line][column] = null; return true;}
            else return false;
        } else return false;
    }


    @Override
    public String getSymbol() {
        return "P";
    }

//    boolean checkMove(int pos) {
//        return pos >= 0 && pos <= 7;
//    }

//    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
//        return false;
//    }
}

