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

        if ((checkMove(toLine) && checkMove(toColumn) && checkMove(line) && checkMove(column)) &&
                (((Math.abs(toLine - line) != 0) && (Math.abs(toColumn - column) == 0)) ||
                        ((Math.abs(toLine - line) == 0) && (Math.abs(toColumn - column) != 0)))) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    boolean checkMove(int pos) {
        return pos >= 0 && pos <= 7;
    }

}
