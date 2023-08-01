# Connect Four Game

This is a simple implementation of the classic Connect Four game in Java. The game can be played in a terminal environment.

## How to Play

1.  If you want to play without having to compile the code, you can download the JAR file of the game from the latest release from the following link: [Download JAR](https://github.com/j04npou/4-in-a-row/releases/tag/1.0)
2. To play, simply run the downloaded JAR file in your terminal: `java -jar 4-in-a-row.jar`
3.  You will be presented with a menu to choose the game mode.
    -   [1] One player: Player vs. AI (AI implementation is not yet provided).
    -   [2] Two players: Player vs. Player.
    -   [0] Exit: To quit the game.
4.  The game board will be displayed in the terminal, and each player will take turns to enter their moves.
5.  Players need to enter the column number (1-7) where they want to place their tile. The game will update the board accordingly.
6.  The first player to connect four tiles either vertically, horizontally, or diagonally wins the game.
7.  If the board is full and there is no winner, the game will end in a draw.

## Board Representation

The board is represented by a 7x6 matrix. Each cell can contain one of the following:

-   `🔴`: Player 1 tile (Red circle)
-   `🔵`: Player 2 tile (Blue circle)
-   `🌙`: Blank cell
-   `🟨`: Border

## Additional Notes

-   The "One player" mode currently does not have any AI logic, so it is recommended to play the "Two players" mode for an interactive experience.

Have fun playing Connect Four!
