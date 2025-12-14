package object_oriented_design_interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DesignConnectFour {
    enum GridPosition {
        EMPTY,
        YELLOW,
        RED,
    }

    class Grid {
        private int rows;
        private int columns;
        private GridPosition[][] grid;

        public Grid(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;

            initGrid();
        }

        void initGrid() {
            grid = new GridPosition[rows][columns];
            for (GridPosition[] row : grid) {
                Arrays.fill(row, GridPosition.EMPTY);
            }
        }

        GridPosition[][] getGrid() {
            return this.grid;
        }

        int getColumnCount() {
            return this.columns;
        }

        int placePiece(int column, GridPosition piece) {
            if (column < 0 || column >= this.columns) {
                throw new IndexOutOfBoundsException("Invalid column");
            }

            if (piece == GridPosition.EMPTY) {
                throw new IndexOutOfBoundsException("Invalid piece");
            }

            for (int row = 0; row < this.rows; row++) {
                if (grid[row][column] == GridPosition.EMPTY) {
                    grid[row][column] = piece;
                    return row;
                }
            }

            return -1;
        }

        boolean checkWin(int connectN, int row, int column, GridPosition piece) {
            int count = 0;

            // Check horizontal
            for (int c = 0; c < this.columns; c++) {
                if (this.grid[row][c] == piece) {
                    count += 1;
                } else {
                    count = 0;
                }

                if (count == connectN) {
                    return true;
                }
            }

            // Check vertical
            count = 0;
            for (int r = 0; r < this.rows; r++) {
                if (this.grid[r][column] == piece) {
                    count += 1;
                } else {
                    count = 0;
                }

                if (count == connectN) {
                    return true;
                }
            }

            // Check diagonal
            count = 0;
            for (int r = 0; r < this.rows; r++) {
                int c = row + column - r;
                if (c >= 0 && c < this.columns && this.grid[r][c] == piece) {
                    count += 1;
                } else {
                    count = 0;
                }

                if (count == connectN) {
                    return true;
                }
            }

            // Check anti-diagonal
            count = 0;
            for (int r = 0; r < this.rows; r++) {
                int c = column - row + r;
                if (c >= 0 && c < this.columns && this.grid[r][c] == piece) {
                    count += 1;
                } else {
                    count = 0;
                }

                if (count == connectN) {
                    return true;
                }
            }

            return false;
        }
    }

    class Player {
        private String name;
        private GridPosition pieceColour;

        public Player(String name, GridPosition pieceColour) {
            this.name = name;
            this.pieceColour = pieceColour;
        }

        String getName() {
            return this.name;
        }

        GridPosition getPieceColour() {
            return this.pieceColour;
        }
    }

    class Move {
        private int row;
        private int column;

        public Move(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return this.row;
        }

        public int getColumn() {
            return this.column;
        }
    }

    class Game {
        private Grid grid;
        private int connectN;
        private int targetScore;
        private Player[] players;
        private Map<Player, Integer> scoreMap;

        public Game(Grid grid, int connectN, int targetScore) {
            this.grid = grid;
            this.connectN = connectN;
            this.targetScore = targetScore;

            this.players = new Player[]{
                    new Player("Player 1", GridPosition.YELLOW),
                    new Player("Player 2", GridPosition.RED),
            };

            this.scoreMap = new HashMap<>();
            for (Player player : this.players) {
                this.scoreMap.put(player, 0);
            }
        }

        void printBoard() {
            System.out.println("Board:");
            GridPosition[][] grid = this.grid.getGrid();
            for (int i = 0; i < grid.length; i++) {
                StringBuilder row = new StringBuilder();
                for (GridPosition piece : grid[i]) {
                    if (piece == GridPosition.EMPTY) {
                        row.append("0 ");
                    } else if (piece == GridPosition.YELLOW) {
                        row.append("Y ");
                    } else if (piece == GridPosition.RED) {
                        row.append("R ");
                    }
                }
                System.out.print(row);
            }
            System.out.println();
        }

        Move playMove(Player player) {
            printBoard();
            System.out.println(player.getName() + "'s Turn");

            Scanner sc = new Scanner(System.in);

            int columnCount = this.grid.getColumnCount();

            System.out.println("Enter column between 0 and " + (columnCount - 1) + " to add piece: ");
            int moveColumn = sc.nextInt();
            int moveRow = this.grid.placePiece(moveColumn, player.getPieceColour());

            return new Move(moveRow, moveColumn);
        }

        Player playRound() {
            while (true) {
                for (Player player : this.players) {
                    Move move = playMove(player);
                    GridPosition pieceColour = player.getPieceColour();

                    if (this.grid.checkWin(connectN, move.getRow(), move.getColumn(), pieceColour)) {
                        this.scoreMap.put(player, this.scoreMap.get(player) + 1);
                        return player;
                    }
                }
            }
        }
    }

    static void main() {

    }
}
