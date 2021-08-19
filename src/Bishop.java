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

        ChessBoard E = new ChessBoard("");
        int v;  // вспомогат для колонок
        int k;  // вспомогат для линий
        int s;  // для циклов
        if ((toLine - line > 0 && toColumn - column > 0) || (toLine - line < 0 && toColumn - column < 0))
            for (s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
                if (E.board[s][s - (line - column)] != null) ;
                return false;
            }

        if (toColumn - column < 0 && toLine - line > 0) {
            v = column - 1;
            for (s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
                if (E.board[s][v] != null) ;
                v -= 1;
                return false;
            }
            if
            (toColumn - column > 0 && toLine - line < 0) {
                k = line - 1; //(5)
                v = column + 1; //(-1)
                for (s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
                    if (E.board[k/*(5)*/][v] != null) ;
                    v++;
                    k--;
                    return false;

                }
            }
        }


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
