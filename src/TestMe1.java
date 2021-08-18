public class TestMe1 {
    public static void main(String[] args) {
        ChessBoard chessBoard1 = new ChessBoard("White");

        Horse horseW1 = new Horse("white");
        System.out.println(horseW1.canMoveToPosition(new ChessBoard("white"), 0, 7, 1, 5));
        System.out.println();

        Pawn pawnW = new Pawn ("White");
        Pawn pawnB = new Pawn ("Black");
        System.out.println(pawnW.canMoveToPosition(new ChessBoard("White"), 2, 3, 3, 3));
        System.out.println(pawnB.canMoveToPosition(new ChessBoard("Black"), 5, 5, 4, 5));
        System.out.println();

        Bishop bishop = new Bishop("White");
        System.out.println(bishop.canMoveToPosition(new ChessBoard("White"), 7,5,4,2));

        System.out.println("\nЛадья:");

        Rook rook = new Rook("Black");
        System.out.println(rook.canMoveToPosition(chessBoard1, 6,4,6,7));



    }
}
