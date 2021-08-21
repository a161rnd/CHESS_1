public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (checkPieseStartStopPosition(line,column, toLine, toColumn)) {
            if ((Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1) ||
                    (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 2)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

//    boolean checkMove(int pos) {
//        return pos >= 0 && pos <= 7;
//    }

//    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
//        return false;
//    }


}
