package cs5004.marblesolitaire.controller;
import cs5004.marblesolitaire.model.MarbleSolitaireModel;

/**
 * This interface represents the controller for the marble solitaire
 * model.
 */
public interface MarbleSolitaireController {

    /*
     * This method should play a new game of Marble Solitaire using the provided model.
     *
     * @param model the marble solitaire model to use for play.
     * @throws IllegalArgumentException if the model is null.
     */
    void playGame(MarbleSolitaireModel model) throws IllegalArgumentException;

}
