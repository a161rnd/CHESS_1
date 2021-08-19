public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if ((checkMove(toLine) && checkMove(toColumn) && checkMove(line) && checkMove(column)) &&
                (Math.abs(toLine - line) == Math.abs(toColumn - column)) && ((line != toLine) && (column != toColumn)))
            return true;

        else if ((checkMove(toLine) && checkMove(toColumn) && checkMove(line) && checkMove(column)) &&
                (((Math.abs(toLine - line) != 0) && (Math.abs(toColumn - column) == 0)) ||
                        ((Math.abs(toLine - line) == 0) && (Math.abs(toColumn - column) != 0))))
            return true;
        else return false;
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    boolean checkMove(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        return false;
    }
}
