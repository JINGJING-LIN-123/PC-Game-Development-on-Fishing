package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

import java.security.spec.ECField;
import java.util.Scanner;

/**
 * This class implements interface MarbleSolitaireController.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
    private final Readable rd;
    private final Appendable ap;

    /*
     * Constructor controller with parameters
     *
     * @param rd the Readable object
     * @param ap the Appendable object
     * @throws IllegalArgumentException if rd or ap is null
     */
    public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
        if (rd == null || ap == null) {
            throw new IllegalArgumentException();
        }
        this.rd = rd;
        this.ap = ap;
    }

    public void playGame(MarbleSolitaireModel model) throws IllegalArgumentException {
        if (model == null) {
            throw new IllegalArgumentException();
        }
        Scanner scan = new Scanner(this.rd);
        int[] pos = new int[4];
        while(!model.isGameOver()) {
            try {
                this.ap.append(model.getGameState()+'\n');
                this.ap.append("Score: " + Integer.toString(model.getScore()) + '\n');
            } catch (Exception e) {
                throw new IllegalStateException();
            }
            boolean validmove = false;
            while(!validmove) {
                int i = 0;
                while (i < 4) {
                    if (scan.hasNextInt()) {
                        int temp = scan.nextInt();
                        if (temp > 0) {
                            pos[i] = temp - 1;
                            i++;
                        } else {
                            try {
                                this.ap.append("Invalid input. Input again.\n");
                            } catch (Exception e) {
                                throw new IllegalStateException();
                            }
                        }
                    }
                    else if (scan.hasNext()) {
                        char temp = scan.next().charAt(0);
                        if (temp == 'q' || temp == 'Q') {
                            try {
                                this.ap.append("Game quit!\n");
                                this.ap.append(model.getGameState()+'\n');
                                this.ap.append("Score: " + Integer.toString(model.getScore()) + '\n');
                            } catch (Exception e) {
                                throw new IllegalStateException();
                            }
                            return;
                        } else {
                            try {
                                this.ap.append("Invalid input. Input again.\n");
                            } catch (Exception e) {
                                throw new IllegalStateException();
                            }
                        }

                    } else {
                        try {
                            this.ap.append("Invalid input. Input again.\n");
                        } catch (Exception e) {
                            throw new IllegalStateException();
                        }
                    }
                }
                validmove = true;
                try {
                    model.move(pos[0], pos[1], pos[2], pos[3]);
                } catch (Exception e) {
                    try {
                        this.ap.append("Invalid move. Play again.\n");
                    } catch (Exception e2) {
                        throw new IllegalStateException();
                    }
                    validmove= false;
                }
            }
        }
        try {
            this.ap.append("Game over!\n");
            this.ap.append(model.getGameState()+'\n');
            this.ap.append("Score: " + Integer.toString(model.getScore()) + '\n');
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }
}
