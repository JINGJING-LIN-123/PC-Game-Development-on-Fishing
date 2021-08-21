package Models;

import javax.swing.*;
import java.awt.*;


public class Fish4 extends Models.Fish {
        public Fish4(double x, double y, double r, int value, int density,
              int movingDirection, double movingSpeed) {

            super(x, y, r, value, density, movingDirection, movingSpeed);
        }

        public void paint(Graphics g) {
            // If movingDirection is larger than 0,
            // Fish will move from left to right.
            Image icon;
            if (movingDirection > 0) {

                icon = new ImageIcon("res/images/fish4_head_right.png").getImage();
            } else {

                icon = new ImageIcon("res/images/fish4.png").getImage();
            }
            g.drawImage(icon, (int) (x - 2 * r), (int) (y - r), (int) (4 * r), (int) (2 * r), null);
        }
}


