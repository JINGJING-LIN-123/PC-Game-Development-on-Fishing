package Models;
import Views.*;
import Controllers.*;
// Fish can move in the sea in background
// If: fish touches hook,
//
// Return a boolean if fish touches hook
//
// then fish and hook come back to cat together with line
// going up backwards

import javax.swing.*;
import java.awt.*;


// Parent Class Fish
public abstract class Fish {
    public double x;
    public double y;
    public double r;
    public int value;
    public int density;
    public int movingDirection;
    public double movingSpeed;
    public boolean isHooked;

    public Fish(double x, double y, double r, int value, int density, int movingDirection, double movingSpeed) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.value = value;
        this.density = density;
        this.movingDirection = movingDirection;
        this.movingSpeed = movingSpeed;
        this.isHooked = false;
    }

    public abstract void paint(Graphics g);

    public void refresh(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public void hooked(Views.Stage stage, int i) {
        stage.fishList.remove(i);
    }

    // Refresh positions of fish:
    // If fish goes to the limit of the window, fish will go back.
    public void runFish() {
        x += movingDirection * movingSpeed;
        if (x < 0 || x > 1050) {
            movingDirection = -movingDirection;
        }
    }
}
