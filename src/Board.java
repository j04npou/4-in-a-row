import java.util.Scanner;

public class Board {
    private final int[][] board = new int[7][6];
    private static final String p1 = "\uD83D\uDD34 ";
    private static final String p2 = "\uD83D\uDD35 ";
    private static final String blank = "\uD83C\uDF19 ";
    private static final String border = "\uD83D\uDFE8 ";

    public void printBoard() {
        System.out.print("   ");
        for (int i = 1; i <= board.length; i++) {
            System.out.print("[" + i + "]");
        }
        System.out.println();
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(border);
            for (int x = 0; x < board.length; x++) {
                if (board[x][y] == 0) {
                    System.out.print(blank);
                } else if (board[x][y] == 1) {
                    System.out.print(p1);
                } else {
                    System.out.print(p2);
                }
            }
            System.out.println(border);
        }
        System.out.println(border.repeat(board.length+2));
    }

    public boolean putTile(int column, int player) {
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

    public int askColumn(int player) {
        Scanner keys = new Scanner(System.in);
        int column = -1;
        String tile = (player == 1) ? p1 : p2;

        while (column < 0 || column > board.length) {

            System.out.println("Player " + tile + player + " enter your move");
            System.out.println("Or put [0] to leave the game");
            String columnStr = keys.next();
            column = Integer.parseInt(columnStr);

            if (column < 0 || column > 7){
                System.out.println("⛔ Select a column in the range, please. ⛔");
            }
        }

        if (column == 0) {
            System.out.println("The player " + tile + player + " left the game \uD83E\uDD37\u200D");
        }

        return column;
    }

    public int checkWinner() {
        int player = 0;
        int counter = 0;

        // Comprovam si tenim guanyador a les horitzontals.
        for (int y = 0; y < board[0].length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (board[x][y] == 0){
                    counter = 0;
                } else if (board[x][y] == player) {
                    counter++;
                } else {
                    counter = 1;
                }
                player = board[x][y];

                if (counter >= 4) {
                    return player;
                }
            }
            counter = 0;
            player = 0;
        }

        // Comprovam si tenim guanyador a les verticals.
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == 0){
                    counter = 0;
                } else if (board[x][y] == player) {
                    counter++;
                } else {
                    counter = 1;
                }
                player = board[x][y];

                if (counter >= 4) {
                    return player;
                }
            }
            counter = 0;
            player = 0;
        }

        // Comprovam si tenim guanyador a la diagonals descendents.

        // Diagonals de y=0 fins a y=6-3
        for (int y = 0; y < board[0].length-3; y++) {
            for (int x = 0; x < board.length; x++) {
                if (y+x >= board[0].length)
                    break;
                if (board[x][y+x] == 0){
                    counter = 0;
                } else if (board[x][y+x] == player) {
                    counter++;
                } else {
                    counter = 1;
                }
                player = board[x][y+x];

                if (counter >= 4) {
                    return player;
                }
            }
            counter = 0;
            player = 0;
        }
        // Diagonals de x=1 fins a x=7-3
        for (int x = 1; x < board.length-3; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (y+x >= board.length)
                    break;
                if (board[x+y][y] == 0){
                    counter = 0;
                } else if (board[x+y][y] == player) {
                    counter++;
                } else {
                    counter = 1;
                }
                player = board[x+y][y];

                if (counter >= 4) {
                    return player;
                }
            }
            counter = 0;
            player = 0;
        }

        // Comprovam si tenim guanyador a la diagonals ascendents.

        // Diagonals de y=3 fins a y=6
        for (int y = 3; y < board[0].length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (y-x < 0)
                    break;
                if (board[x][y-x] == 0){
                    counter = 0;
                } else if (board[x][y-x] == player) {
                    counter++;
                } else {
                    counter = 1;
                }
                player = board[x][y-x];

                if (counter >= 4) {
                    return player;
                }
            }
            counter = 0;
            player = 0;
        }
        // Diagonals de x=1 fins a x=7-3
        int yTotal = board[0].length - 1;
        for (int x = 1; x < board.length-3; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (x+y >= board.length)
                    break;
                if (board[x+y][yTotal-y] == 0){
                    counter = 0;
                } else if (board[x+y][yTotal-y] == player) {
                    counter++;
                } else {
                    counter = 1;
                }
                player = board[x+y][yTotal-y];

                if (counter >= 4) {
                    return player;
                }
            }
            counter = 0;
            player = 0;
        }

        // Comprovam si queden moviments possibles
        boolean availMoves = false;

        for (int x = 0; x < board.length; x++) {
            if (board[x][0] == 0) {
                availMoves = true;
                break;
            }
        }
        if (!availMoves) {
            return -1;
        }

        // Si no hi ha guanyador retornam 0.
        return 0;
    }
}
