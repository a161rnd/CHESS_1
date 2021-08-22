public class King extends ChessPiece {

    public boolean kingCheck = false;

    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (((checkPieseStartStopPosition(line, column, toLine, toColumn)) &&
                (Math.abs(toLine - line) == Math.abs(toColumn - column)) && ((line != toLine) && (column != toColumn))) &&
                ((Math.abs(toLine - line) < 2) && (Math.abs(toColumn - column) < 2))) {
            check = false;
            return true;
        } else if (((checkPieseStartStopPosition(line, column, toLine, toColumn)) &&
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
        for (int i = 0; i < chessBoard.board.length - 1; i++) {
            if (canMoveToPosition(chessBoard, i, i, line, column))
                return true;
        }
        return false;
    }
}
