public class Board {
    private static int[][] board = new int[7][8];
    private static String p1 = "\uD83D\uDD34 ";
    private static String p2 = "\uD83D\uDD35 ";
    private static String blank = "\uD83C\uDF19 ";
    private static String border = "\uD83D\uDFE8 ";

    public static void printBoard() {
        System.out.println("[1] [2] [3] [4] [5] [6] [7] [8]");
        for (int i = 0; i < 7; i++) {
            System.out.print(border);
            for (int j = 0; j < 8; j++) {
                if (Board.board[i][j] == 0) {
                    System.out.print(blank);
                } else if (Board.board[i][j] == 1) {
                    System.out.print(p1);
                } else {
                    System.out.print(p2);
                }
            }
            System.out.println(border);
        }
        System.out.println(border.repeat(10));
    }
}
