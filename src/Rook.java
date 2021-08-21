public class Rook extends ChessPiece{

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
//        chessBoard.board[0][0] = null;

        if (checkPieseStartStopPosition(line,column, toLine, toColumn) && (((Math.abs(toLine - line) != 0) &&
                (Math.abs(toColumn - column) == 0)) ||
                        ((Math.abs(toLine - line) == 0) && (Math.abs(toColumn - column) != 0)))) {
            check = false; return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

//    boolean checkMove(int pos) {
//        return pos >= 0 && pos <= 7;
//    }

//    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
//        return false;
//    }

}
