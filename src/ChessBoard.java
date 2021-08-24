
/*
 * @author Гуренко Андрей
 * vers 1.1
 * Что смог реализовать:
 * проверка корректности ходов всех фигур
 * у пешки: возможность бить по диагонали и невозможность бить прямо, проход в Ферзи
 * проверка хода на Шах (фиксация наличия Шаха на доске)
 *
 * Что не получилось:
 * создать способ анализа будущей ситуации на доске, для реализации невозможности ходить, если ход не отменяет шах
 * попытки этой реализации в закомментированных блоках
 *
 * */


import java.util.regex.Pattern;

public class ChessBoard implements Cloneable {


    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game

    String nowPlayer;
//  String colorOfKingUnderAttack;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {

        String pieceName = board[startLine][startColumn].getSymbol();


        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor()))
                return false;
            if ((board[endLine][endColumn] != null) && nowPlayer.equals(board[endLine][endColumn].getColor()))
                return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {

                if (board[startLine][startColumn].getSymbol().equals("K") ||  // check position for castling
                        board[startLine][startColumn].getSymbol().equals("R")) {
                    board[startLine][startColumn].check = false;
                }

                if ((Pattern.matches("[QB]", pieceName)) &&
                        checkDiagonalDirection(startLine, startColumn, endLine, endColumn) == false) {
                    System.out.println("проверка диагонали = false ");
                    return false;
                }

                if ((Pattern.matches("[QR]", pieceName)) &&
                        (checkStraightDirection(startLine, startColumn, endLine, endColumn)) == false) {
                    System.out.println("проверка прямой = false ");
                    return false;
                }

//              if (checkPositionAfterMove(startLine, startColumn, endLine, endColumn) == false) return false;

                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell

                if ((Pattern.matches("[P]", pieceName)) && (((nowPlayer.equals("White") && endLine == 7) || // проход в ферзи
                        ((nowPlayer.equals("Black")) && endLine == 0))))
                    board[endLine][endColumn] = new Queen(nowPlayer);

                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";
                checkWhiteKingsUnderAttack(); // проверяем наличие шаха белым
                checkBlackKingsUnderAttack(); // проверяем наличие шаха черным

                return true;
            }
            return false;
        }
        return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");
        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");

    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean castling0() {
        if (nowPlayer.equals("White")) {
            if (board[0][0] == null || board[0][4] == null) return false;
            if (board[0][0].getSymbol().equals("R") && board[0][4].getSymbol().equals("K") && // check that King and Rook
                    board[0][1] == null && board[0][2] == null && board[0][3] == null) {              // never moved
                if (board[0][0].getColor().equals("White") && board[0][4].getColor().equals("White") &&
                        board[0][0].check && board[0][4].check &&
                        !new King("White").isUnderAttack(this, 0, 2)) { // check that position not in under attack
                    board[0][4] = null;
                    board[0][1] = new King("White");   // move King
                    board[0][1].check = false;
                    board[0][0] = null;
                    board[0][2] = new Rook("White");   // move Rook
                    board[0][2].check = false;
                    nowPlayer = "Black";  // next turn
                    return true;
                } else return false;
            } else return false;
        } else {
            if (board[7][0] == null || board[7][4] == null) return false;
            if (board[7][0].getSymbol().equals("R") && board[7][4].getSymbol().equals("K") && // check that King and Rook
                    board[7][1] == null && board[7][2] == null && board[7][3] == null) {              // never moved
                if (board[7][0].getColor().equals("Black") && board[7][4].getColor().equals("Black") &&
                        board[7][0].check && board[7][4].check &&
                        !new King("Black").isUnderAttack(this, 7, 2)) { // check that position not in under attack
                    board[7][4] = null;
                    board[7][1] = new King("Black");   // move King
                    board[7][1].check = false;
                    board[7][0] = null;
                    board[7][2] = new Rook("Black");   // move Rook
                    board[7][2].check = false;
                    nowPlayer = "White";  // next turn
                    return true;
                } else return false;
            } else return false;
        }
    }

    public boolean castling7() {
        if (nowPlayer.equals("White")) {
            if (board[0][7] == null || board[0][4] == null) return false;
            if (board[0][7].getSymbol().equals("R") && board[0][4].getSymbol().equals("K") && // check that King and Rook
                    board[0][6] == null && board[0][5] == null) {                             // never moved
                if (board[0][7].getColor().equals("White") && board[0][4].getColor().equals("White") &&
                        board[0][7].check && board[0][4].check &&
                        !new King("White").isUnderAttack(this, 0, 6)) { // check that position nit in under attack
                    board[0][4] = null;
                    board[0][6] = new King("White");   // move King
                    board[0][6].check = false;
                    board[0][7] = null;
                    board[0][5] = new Rook("White");   // move Rook
                    board[0][5].check = false;
                    nowPlayer = "Black";  // next turn
                    return true;
                } else return false;
            } else return false;
        } else {
            if (board[7][7] == null || board[7][4] == null) return false;
            if (board[7][7].getSymbol().equals("R") && board[7][4].getSymbol().equals("K") && // check that King and Rook
                    board[7][6] == null && board[7][5] == null) {                             // never moved
                if (board[7][7].getColor().equals("Black") && board[7][4].getColor().equals("Black") &&
                        board[7][7].check && board[7][4].check &&
                        !new King("Black").isUnderAttack(this, 7, 6)) { // check that position not in under attack
                    board[7][4] = null;
                    board[7][6] = new King("Black");   // move King
                    board[7][6].check = false;
                    board[7][7] = null;
                    board[7][5] = new Rook("Black");   // move Rook
                    board[7][5].check = false;
                    nowPlayer = "White";  // next turn
                    return true;
                } else return false;
            } else return false;
        }
    }

    public boolean checkStraightDirection(int line, int column, int toLine, int toColumn) { /*проверка прямых ходов*/

        int straightlDirection = 0;

        {
            if
            (toLine == line && toColumn != column) straightlDirection = 1; // горизонт направл
            if (toLine != line && toColumn == column) straightlDirection = 2; // вертик направ
        }

        if (straightlDirection == 1) // горизонт
            for (int s = Math.min(column, toColumn) + 1; s < Math.max(column, toColumn); s++) {
                if (this.board[line][s] != null) return false;
            }

        if (straightlDirection == 2)  // вертикал
            for (int s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
                if (this.board[s][column] != null) return false;
            }
        return true;
    }

    public boolean checkDiagonalDirection(int line, int column, int toLine, int toColumn) {  /*проверка диагональных ходов*/

        int diagonalDirection = 0;
        int cntLine = 0;
        int cntColumn = 0;
        {
            if
            ((toLine - line > 0 && toColumn - column > 0) || (toLine - line < 0 && toColumn - column < 0))
                diagonalDirection = 1; // слева - направо, снизу вверз (или наоборот)
            if (toColumn - column < 0 && toLine - line > 0) diagonalDirection = 2; // справа - налево, снизу вверх
            else if (toColumn - column > 0 && toLine - line < 0) diagonalDirection = 3; // слева ноправо, сверху вниз
        }

        if (diagonalDirection == 1) // слева - направо, снизу вверз (или наоборот)
            for (int s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
                cntColumn++;
                if (this.board[s][Math.min(column, toColumn) + cntColumn] != null) return false;
            }

        if (diagonalDirection == 2)     // справа - налево, снизу вверх
            for (int s = Math.min(line, toLine) + 1; s < Math.max(line, toLine); s++) {
                cntColumn--;
                if (this.board[s][Math.max(column, toColumn) + cntColumn] != null) return false;
            }

        if (diagonalDirection == 3)  // слева ноправо, сверху вниз
            for (int s = Math.min(column, toColumn) + 1; s < Math.max(column, toColumn); s++) {
                cntLine--;
                if (this.board[Math.max(line, toLine) + cntLine][s] != null) return false;
            }
        return true;
    }

//    public boolean isAnyKingUnderAttack() {
//
//        if (checkWhiteKingsUnderAttack() == true) colorOfKingUnderAttack = "White";
//        if (checkBlackKingsUnderAttack() == true) colorOfKingUnderAttack = "Black";
//
//        if (checkWhiteKingsUnderAttack() == true || checkBlackKingsUnderAttack() == true)
//            return true;
//        else return false;
//    }


    public boolean moveToPositionCheckingForBothPlayers(int startLine, int startColumn, int endLine, int endColumn) {

        String pieceName = board[startLine][startColumn].getSymbol();

        if (checkPos(startLine) && checkPos(startColumn)) {

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {

                if (board[startLine][startColumn].getSymbol().equals("K") ||  // check position for castling
                        board[startLine][startColumn].getSymbol().equals("R")) {
                    board[startLine][startColumn].check = false;
                }

                if ((Pattern.matches("[QB]", pieceName)) &&
                        checkDiagonalDirection(startLine, startColumn, endLine, endColumn) == false) {
//                    System.out.println("проверка диагонали = false ");
                    return false;
                }

                if ((Pattern.matches("[QR]", pieceName)) &&
                        (checkStraightDirection(startLine, startColumn, endLine, endColumn)) == false) {
//                    System.out.println("проверка прямой = false ");
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }


//    public boolean checkPositionAfterMove(int startLine, int startColumn, int endLine, int endColumn) {
//
//
//        if ((board[endLine][endColumn]== board[startLine][startColumn]) &&
//                ((board[startLine][startColumn] == null)))  {
//
//            if (isAnyKingUnderAttack() == true && colorOfKingUnderAttack.equals(nowPlayer)) return false;
//
//
//        } return true;
//    }

    public boolean checkWhiteKingsUnderAttack() {

        int kingLine = 0;
        int kingColumn = 4;

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {

                if ((board[i][j] != null) &&
                        (board[i][j].getSymbol().equals("K"))
                        && (board[i][j].getColor().equals("White"))) {
                    kingLine = i;
                    kingColumn = j;
                }
            }
        }

        for (int s = 0; s < board.length; s++)
            for (int w = 0; w < board.length; w++)
                if ((board[s][w] != null) && (board[s][w].getColor().equals("Black"))) {
                    if (moveToPositionCheckingForBothPlayers(s, w, kingLine, kingColumn)) {
                        System.out.println(("\nCheck to the White !!!"));
                        return true;
                    }
                }
        return false;
    }

    public boolean checkBlackKingsUnderAttack() {

        int kingLine = 7;
        int kingColumn = 4;

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {

                if ((board[i][j] != null) &&
                        (board[i][j].getSymbol().equals("K"))
                        && (board[i][j].getColor().equals("Black"))) {
                    kingLine = i;
                    kingColumn = j;
                }
            }
        }

        for (int s = 0; s < board.length; s++)
            for (int w = 0; w < board.length; w++)
                if ((board[s][w] != null) && (board[s][w].getColor().equals("White"))) {
                    if (moveToPositionCheckingForBothPlayers(s, w, kingLine, kingColumn)) {
                        System.out.println(("\nCheck to the Black !!!"));
                        return true;
                    }
                }
        return false;
    }


}


