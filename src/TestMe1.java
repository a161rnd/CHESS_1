public class TestMe1 {
    public static void main(String[] args) {
        Horse horseW1 = new Horse("white");
        System.out.println(horseW1.canMoveToPosition(new ChessBoard("white"), 0, 7, 1, 5));
        System.out.println();

        Pawn pawnW = new Pawn ("White");
        Pawn pawnB = new Pawn ("Black");
        System.out.println(pawnW.canMoveToPosition(new ChessBoard("White"), 2, 3, 3, 3));
        System.out.println(pawnB.canMoveToPosition(new ChessBoard("Black"), 5, 4, 4, 5));
    }
}
