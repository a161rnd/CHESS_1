public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (((checkPieseStartStopPosition(line,column, toLine, toColumn)) &&
                (Math.abs(toLine - line) == Math.abs(toColumn - column)) && ((line != toLine) && (column != toColumn))) &&
                ((Math.abs(toLine - line) < 2) && (Math.abs(toColumn - column) < 2))) {
            check = false;
            return true;
        } else if (((checkPieseStartStopPosition(line,column, toLine, toColumn)) &&
                (((Math.abs(toLine - line) != 0) && (Math.abs(toColumn - column) == 0)) ||
                        ((Math.abs(toLine - line) == 0) && (Math.abs(toColumn - column) != 0)))) &&
                ((Math.abs(toLine - line) < 2) && (Math.abs(toColumn - column) < 2))) {
            check = false;
            return true;
        } else return false;
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        return false;

//    boolean checkMove(int pos) {
//        return pos >= 0 && pos <= 7;
//    }

//    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
//        return false;
//    }


    }
}
