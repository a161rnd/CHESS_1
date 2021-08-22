public class Bishop extends ChessPiece {

    public boolean legalMove = false;

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {


        if ((checkPieseStartStopPosition(line, column, toLine, toColumn) &&
                (Math.abs(toLine - line) == Math.abs(toColumn - column)) && ((line != toLine) && column != toColumn)))
            return true;
        else return false;
    }


    @Override
    public String getSymbol() {
        return "B";
    }


}
