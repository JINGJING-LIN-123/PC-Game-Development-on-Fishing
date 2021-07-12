package cs5004.marblesolitaire.model;
import java.lang.*;

/*
 * This java class implements interface MarbleSolitaireModel.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 07/12/2021
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
    private boolean [] [] board;
    private int arm_thickness;

    /*
     * Default constructor with no parameters.
     */
    public MarbleSolitaireModelImpl() {
        arm_thickness = 3;
        board = new boolean[arm_thickness*3-2][arm_thickness*3-2];
        for(int i=0; i<arm_thickness*3-2; i++) {
            for(int j=0; j<arm_thickness*3-2; j++) {
                if(((i>=arm_thickness-1 && i<=arm_thickness*2-2) || (j>=arm_thickness-1 && j<=arm_thickness*2-2))
                        && !(i==(arm_thickness-1)*3/2 && j==(arm_thickness-1)*3/2)) {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }
    }

    /*
     * Constructor with parameters to indicate the position of the empty slot.
     *
     * @param sRow the row number of the empty slot
     * @param sCol the column number of the empty slot
     * @throws IllegalArgumentException if the position is invalid
     */
     public MarbleSolitaireModelImpl(int sRow, int sCol) {
         arm_thickness = 3;
         if((sRow<arm_thickness-1 || sRow>arm_thickness*2-2) && (sCol<arm_thickness-1 || sCol>arm_thickness*2-2)) {
             throw new IllegalArgumentException("Invalid empty cell position ("+sRow+","+sCol+")");
         }
         board = new boolean[arm_thickness*3-2][arm_thickness*3-2];
         for(int i=0; i<arm_thickness*3-2; i++) {
             for (int j = 0; j < arm_thickness * 3 - 2; j++) {
                 if (((i >= arm_thickness - 1 && i <= arm_thickness * 2 - 2) || (j >= arm_thickness - 1 && j <= arm_thickness * 2 - 2))
                         && !(i == sRow && j == sCol)) {
                     board[i][j] = true;
                 } else {
                     board[i][j] = false;
                 }
             }
         }
     }

    /*
     * Constructor with parameter to indicate arm thickness.
     *
     * @param arm_thickness the input parameter for arm thickness
     * @throws IllegalArgumentException if the arm_thickness is not a positive odd number
     */
    public MarbleSolitaireModelImpl(int arm_thickness) {
        if(arm_thickness <= 0 || arm_thickness%2 == 0) {
            throw new IllegalArgumentException();
        }
        this.arm_thickness = arm_thickness;
        board = new boolean[arm_thickness*3-2][arm_thickness*3-2];
        for(int i=0; i<arm_thickness*3-2; i++) {
            for(int j=0; j<arm_thickness*3-2; j++) {
                if(((i>=arm_thickness-1 && i<=arm_thickness*2-2) || (j>=arm_thickness-1 && j<=arm_thickness*2-2))
                        && !(i==(arm_thickness-1)*3/2 && j==(arm_thickness-1)*3/2)) {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }
    }
    /*
     * Constructor with parameters to indicate arm thickness and position of the empty slot.
     *
     * @param arm_thickness the input parameter for arm thickness
     * @param sRow the row number of the empty slot
     * @param sCol the column number of the empty slot
     * @throws IllegalArgumentException if the arm_thickness is not a positive odd number or the position is invalid
     */
    public MarbleSolitaireModelImpl(int arm_thickness, int sRow, int sCol) {
        if(arm_thickness <= 0 || arm_thickness%2 == 0
                || ((sRow<arm_thickness-1 || sRow>arm_thickness*2-2)
                && (sCol<arm_thickness-1 || sCol>arm_thickness*2-2))) {
            throw new IllegalArgumentException();
        }
        this.arm_thickness = arm_thickness;
        board = new boolean[arm_thickness*3-2][arm_thickness*3-2];
        for(int i=0; i<arm_thickness*3-2; i++) {
            for (int j = 0; j < arm_thickness * 3 - 2; j++) {
                if (((i >= arm_thickness - 1 && i <= arm_thickness * 2 - 2) || (j >= arm_thickness - 1 && j <= arm_thickness * 2 - 2))
                        && !(i == sRow && j == sCol)) {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }
    }

    /**
     * Return a string that represents the current state of the board. The
     * string should have one line per row of the game board. Each slot on the
     * game board is a single character (O, X or space for a marble, empty and
     * invalid position respectively). Slots in a row should be separated by a
     * space. Each row has no space before the first slot and after the last slot.
     * @return the game state as a string
     */
    public String getGameState() {
        String result = "";
        for(int i=0; i<arm_thickness*3-2; i++) {
            for (int j = 0; j < arm_thickness * 3 - 2; j++) {
                if (((i < (arm_thickness - 1) || i > (arm_thickness * 2 - 2)) && (j < (arm_thickness - 1) || j > (arm_thickness * 2 - 2)))) {
                    result += ' ';
                } else if(board[i][j]) {
                    result += 'o';
                } else {
                    result += '_';
                }
                if(j != arm_thickness*3-3) {
                    result += ' ';
                }
            }
            if(i != arm_thickness*3-3) {
                result += '\n';
            }
        }
        return result;
    }

    /*
     * Check whether a move is valid.
     *
     * @param fromRow the row number of the position to be moved from
     *                (starts at 0)
     * @param fromCol the column number of the position to be moved from
     *                (starts at 0)
     * @param toRow the row number of the position to be moved to
     *              (starts at 0)
     * @param toCol the column number of the position to be moved to
     *              (starts at 0)
     * @return boolean Whether the move is valid
     */
    private boolean isValidMove(int fromRow,int fromCol,int toRow,int toCol) {
        if(((fromRow<arm_thickness-1 || fromRow>arm_thickness*2-2) && (fromCol<arm_thickness-1 || fromCol>arm_thickness*2-2))
                || ((toRow<arm_thickness-1 || toRow>arm_thickness*2-2) && (toCol<arm_thickness-1 || toCol>arm_thickness*2-2))) {
            return false;
        } else if(!board[fromRow][fromCol]) {
            return false;
        } else if(board[toRow][toCol]) {
            return false;
        } else if(!(fromRow==toRow && Math.abs(fromCol-toCol)==2) && !(fromCol==toCol && Math.abs(fromRow-toRow)==2)) {
            return false;
        } else if(!board[(fromRow+toRow)/2][(fromCol+toCol)/2]) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Move a single marble from a given position to another given position.
     * A move is valid only if the from and to positions are valid. Specific
     * implementations may place additional constraints on the validity of a move.
     * @param fromRow the row number of the position to be moved from
     *                (starts at 0)
     * @param fromCol the column number of the position to be moved from
     *                (starts at 0)
     * @param toRow the row number of the position to be moved to
     *              (starts at 0)
     * @param toCol the column number of the position to be moved to
     *              (starts at 0)
     * @throws IllegalArgumentException if the move is not possible
     */
    public void move(int fromRow,int fromCol,int toRow,int toCol) throws
            IllegalArgumentException {
        if(!isValidMove(fromRow, fromCol, toRow, toCol)) {
            throw new IllegalArgumentException();
        } else {
            board[fromRow][fromCol] = false;
            board[toRow][toCol] = true;
            board[(fromRow+toRow)/2][(fromCol+toCol)/2] = false;
        }
    }

    /**
     * Determine and return if the game is over or not. A game is over if no
     * more moves can be made.
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        for(int i=0; i<arm_thickness*3-2; i++) {
            for (int j = 0; j < arm_thickness * 3 - 2; j++) {
                for (int m = 0; m < arm_thickness * 3 - 2; m++) {
                    for (int n = 0; n < arm_thickness * 3 - 2; n++) {
                        if (isValidMove(i, j, m, n)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    /**
     * Return the number of marbles currently on the board.
     * @return the number of marbles currently on the board
     */
    public int getScore() {
        int score = 0;
        for(int i=0; i<arm_thickness*3-2; i++) {
            for (int j = 0; j < arm_thickness * 3 - 2; j++) {
                if(board[i][j]) {
                    score++;
                }
            }
        }
        return score;
    }
}
