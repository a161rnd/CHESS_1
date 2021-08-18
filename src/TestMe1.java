public class TestMe1 {
    public static void main(String[] args) {
        Horse horseW1 = new Horse("white");
        System.out.println(horseW1.canMoveToPosition(new ChessBoard("white"), 0, 7, 1, 5));
    }
}
