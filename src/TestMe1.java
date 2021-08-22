public class TestMe1 {
    public static void main(String[] args) {
        ChessBoard chessBoard1 = new ChessBoard("White");

        System.out.println("\nКонь:");

        Horse horseW1 = new Horse("white");
        System.out.println(horseW1.canMoveToPosition(chessBoard1, 0, 7, 1, 5));
        System.out.println();

        System.out.println("\nПешки:");

        Pawn pawnW = new Pawn ("White");
        Pawn pawnB = new Pawn ("Black");
        System.out.println(pawnW.canMoveToPosition(chessBoard1, 1, 3, 2, 3));
        System.out.println(pawnB.canMoveToPosition(chessBoard1, 5, 5, 4, 5));
        System.out.println();

        System.out.println("\nСлон:");

        Bishop bishop = new Bishop("White");
        System.out.println(bishop.canMoveToPosition(chessBoard1, 7,1,6,0));

        System.out.println("\nЛадья:");

        Rook rook = new Rook("Black");
        System.out.println(rook.canMoveToPosition(chessBoard1, 2,5,6,5));

        System.out.println("\nФерзь:");

        Queen queen = new Queen("Black");
        System.out.println(queen.canMoveToPosition(chessBoard1, 1,2,5,2));

        System.out.println("\nКороль:");

        King king = new King("White");
        System.out.println(king.canMoveToPosition(chessBoard1, 1,7,0,7));

//        ChessBoard chessBoard2 = new ChessBoard("Black");
//        chessBoard2.printBoard();


    }
}
