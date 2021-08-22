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

        int kingLine = 0;
        int kingColumn = 4;

        for (int i = 0; i < chessBoard.board.length; i++) {
            for (int j = 0; j < chessBoard.board.length; j++) {

                if ((chessBoard.board[i][j] != null) &&
                        (chessBoard.board[i][j].getSymbol().equals("K"))
                        && (chessBoard.board[i][j].getColor().equals(this.getColor()))) {
                    kingLine = i;
                    kingColumn = j;
                }
            }
        }

        for (int s = 0; s < chessBoard.board.length; s++)
            for (int w = 0; w < chessBoard.board.length; w++)
                if ((chessBoard.board[s][w] != null) && (!(chessBoard.board[s][w].getColor().equals(this.getColor())))) {
                    if (chessBoard.moveToPositionCopy(s, w, line, column)) {
                        System.out.println("Field [" + line + "]" + "[" + column + "]" + " is under Attack !");
                        return true;
                    }
                    if (chessBoard.moveToPositionCopy(s, w, kingLine, kingColumn)) {
                        System.out.println("Checks the " + chessBoard.board[kingLine][kingColumn].getColor() + " King !!!");
                        return true;
                    }


                }
        return false;
    }


}
