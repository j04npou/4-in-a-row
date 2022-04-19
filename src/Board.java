public class Board {
    private static final int[][] board = new int[7][6];
    private static final String p1 = "\uD83D\uDD34 ";
    private static final String p2 = "\uD83D\uDD35 ";
    private static final String blank = "\uD83C\uDF19 ";
    private static final String border = "\uD83D\uDFE8 ";

    public static void printBoard() {
        System.out.print("   ");
        for (int i = 1; i <= board.length; i++) {
            System.out.print("[" + i + "]");
        }
        System.out.println();
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(border);
            for (int x = 0; x < board.length; x++) {
                if (Board.board[x][y] == 0) {
                    System.out.print(blank);
                } else if (Board.board[x][y] == 1) {
                    System.out.print(p1);
                } else {
                    System.out.print(p2);
                }
            }
            System.out.println(border);
        }
        System.out.println(border.repeat(board.length+2));
    }

    public static boolean putTile(int column, int player) {
        // Si la columna está plena no es pot colocar fitxa.
        if (board[column][0] != 0) {
            return false;
        }
        // Recorrem la columna i colocam fitxa a la darrera casella buida.
        for (int i = 0; i < board[0].length; i++) {
            if (board[column][i] != 0) {
                board[column][i-1] = player;
                return true;
            }
        }
        // Si tota la columna está buida colocam la fitxa a la darrera casella.
        board[column][board[0].length-1] = player;
        return true;
    }
}
