public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if ((checkMove(toLine) && checkMove(toColumn) && checkMove(line) && checkMove(column)) &&
                (Math.abs(toLine - line) == Math.abs(toColumn - column)) && ((line != toLine) && column != toColumn)) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    boolean checkMove(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        return false;
    }
}
