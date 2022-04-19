import java.util.Scanner;

public class Game {

    private static void menu() {
        Scanner keys = new Scanner(System.in);

        System.out.println("[1] - One player");
        System.out.println("[2] - Two player");
        System.out.println("[0] - To exit");
        String menu = keys.next();

        if (menu.equals("1")) {
            onePlayerGame();
        }else if (menu.equals("2")) {
            twoPlayerGame();
        }else if (menu.equals("0")) {
            System.exit(0);
        } else {
            System.out.println("⛔ Select one of the indicated options, please. ⛔");
        }
    }

    private static void onePlayerGame() {
        System.out.println("⛔ This game mode is not implemented yet ⛔");
    }

    private static void twoPlayerGame() {
        Board twoP = new Board();
        twoP.printBoard();

        int winner = 0;
        int player = 1;
        int column = twoP.askColumn(player);

        while (winner == 0 && column != 0 ) {
            if (twoP.putTile(column-1, player)) {
                twoP.printBoard();

                if (player == 1) {
                    player = 2;
                } else {
                    player = 1;
                }
            } else {
                System.out.println("⛔ This row is full, please select another row. ⛔");
            }

            winner = twoP.checkWinner();
            if (winner == 0) {
                column = twoP.askColumn(player);
            }
        }
        switch (winner) {
            case 1:
                System.out.println("  _____  _                         __            _           \n" +
                        " |  __ \\| |                       /_ |          (_)          \n" +
                        " | |__) | | __ _ _   _  ___ _ __   | | __      ___ _ __  ___ \n" +
                        " |  ___/| |/ _` | | | |/ _ \\ '__|  | | \\ \\ /\\ / / | '_ \\/ __|\n" +
                        " | |    | | (_| | |_| |  __/ |     | |  \\ V  V /| | | | \\__ \\\n" +
                        " |_|    |_|\\__,_|\\__, |\\___|_|     |_|   \\_/\\_/ |_|_| |_|___/\n" +
                        "                  __/ |                                      \n" +
                        "                 |___/                                       ");
                break;
            case 2:
                System.out.println("  _____  _                         ___             _           \n" +
                        " |  __ \\| |                       |__ \\           (_)          \n" +
                        " | |__) | | __ _ _   _  ___ _ __     ) | __      ___ _ __  ___ \n" +
                        " |  ___/| |/ _` | | | |/ _ \\ '__|   / /  \\ \\ /\\ / / | '_ \\/ __|\n" +
                        " | |    | | (_| | |_| |  __/ |     / /_   \\ V  V /| | | | \\__ \\\n" +
                        " |_|    |_|\\__,_|\\__, |\\___|_|    |____|   \\_/\\_/ |_|_| |_|___/\n" +
                        "                  __/ |                                        \n" +
                        "                 |___/                                         ");
                break;
            case -1:
                System.out.println("  _____                     \n" +
                        " |  __ \\                    \n" +
                        " | |  | |_ __ __ ___      __\n" +
                        " | |  | | '__/ _` \\ \\ /\\ / /\n" +
                        " | |__| | | | (_| |\\ V  V / \n" +
                        " |_____/|_|  \\__,_| \\_/\\_/  \n" +
                        "                            \n" +
                        "                            ");
                break;
        }
    }

    public static void main(String[] args) {
        while (true) {
            menu();
        }

    }
}