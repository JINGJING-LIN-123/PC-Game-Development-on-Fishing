package Models;

// hook is at the end of line
// if hook touches fish, hook and fish comes up together with line
// catch mouse action and position

// line will draw a semicircle
// if: mouse clicks, line stops, goes down outwards
// if: hook touches fish, line goes up backwards to cat
// if: hook does not touch fish, line is too long to its limit, then line goes
// up backwards to cat.

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hook {
    // hook location
    private double basePositionX;
    private double basePositionY;
    // hook rotation angle
    private double theta = 0;
    // line length
    private double lineLength= 0.0;
    // radius of object hook
    final double hookRadius = 14.0;
    // weight of hook
    private double hookWeight = 700.0;
    // the velocity that hook goes down
    public double downVelocity = 40.0;
    // hook direction
    public int hookDirection = 1;
    // import fish type from Fish
    private Models.Fish fish;
    // the state of hook: wait, forward and backward
    public HookState hookState;

    // constructor of hook, assign hook's position.
    public Hook(double width, double height){
        basePositionX = width;
        basePositionY = height;
        hookState = HookState.WAIT;
    }

    // current hook position x
    double hookX(){
        double hookPositionX = basePositionX + lineLength * Math.cos(theta);
        return hookPositionX;
    }

    // current hook position y
    double hookY(){
        double hookPositionY = basePositionY + lineLength * Math.sin(theta);
        return hookPositionY;
    }

    // current weight of fish and hook
    double curWeight(){
        double curWeight;
        // no fish, no other weight
        if (fish == null){
            curWeight = hookWeight;
        }
        // with fish, weight is fish's weight + hook weight
        else{
            curWeight = hookWeight + fish.density * fish.r * fish.r;
        }
        return curWeight;
    }

    // The velocity that the hook goes up
    double upVelocity(){
        double upV = 15000.0 / curWeight();
        return upV;
    }

    // The distance between point A and point B using theory of triangle
    public double distanceBetweenAB(double Ax, double Ay, double Bx, double By){
        return Math.sqrt((Ax-Bx)*(Ax-Bx) + (Ay-By)*(Ay-By));
    }

    // A boolean showing if fish is hooked or not
    boolean hookFish(Models.Fish fishA){
        // if distance between fish and hook is smaller enough to make intersection
        if(distanceBetweenAB(hookX(),hookY(),fishA.x,fishA.y) < (hookRadius/2 + fishA.r)){
            // hook goes up after fish is caught
            fish = fishA;
            hookState = HookState.UP;
            return true;
        } else {
            return false;
        }
    }

    // refresh the hook's position in three different situations
    public void refresh(Views.Stage stage){
        switch (hookState){
            // in the WAIT situation, hook is above water
            case WAIT:
                theta += hookDirection * Math.PI / Controllers.HomeController.PERIOD;
                // When theta goes to the edge, it goes backwards by changing hookDirection
                if (theta >= Math.PI * 9 / 10) {
                    hookDirection = -1;
                }
                else if (theta <= Math.PI / 10) {
                    hookDirection = 1;
                }
                break;
            // in the DOWN situation, hook goes into the water
            case DOWN:
                lineLength += downVelocity;
                // When hook reaches edge, hooks goes up
                if (hookX() < 50 || hookY() > 1000 || hookY() > 700) {
                    hookState = HookState.UP;
                    break;
                }
                // When hook gets fish, fish is hooked
                for(int i = 0; i < stage.fishList.size(); i++){
                    Models.Fish testFish = stage.fishList.get(i);
                    if(hookFish(testFish)){
                        testFish.hooked(stage,i);
                        break;
                    }
                }
                break;
            // in the UP situation, hook goes out of water
            case UP:
                lineLength -= upVelocity();

                // fish is caught or not
                if (fish != null){
                    // hooked fish will move with hook
                    fish.refresh(hookX() + hookRadius * Math.cos(theta),
                            hookY() + hookRadius * Math.sin(theta));
                }
                // When fish comes back, add score and return to WAIT state
                if (lineLength <= 0){
                    if (fish != null) {
                        stage.score += fish.value;
                        fish = null;
                    }
                    lineLength = 0;
                    hookState = HookState.WAIT;
                }
                break;
        }
    }
    // When press space button, launch is used to change state
    public void launch(){
        if(hookState == HookState.WAIT)
            hookState = HookState.DOWN;
    }

    // paint fish, hook and fishing line here
    public void paint(Graphics g) throws IOException{
        switch (hookState) {
            case UP:
                if (fish != null){
                    fish.paint(g);	// If fish is hooked, draw the fish.
                }
            default:
                // drawing the fishing line
                Graphics2D drawing = (Graphics2D)g;
                drawing.setStroke(new BasicStroke(2.0f));
                drawing.drawLine((int)(basePositionX), (int)(basePositionY)-120, (int)hookX(), (int)hookY());
                // drawing the hook
                BufferedImage hookImage = ImageIO.read(new File("res/images/fishhook.png"));
                BufferedImage rotatedHook = rotateImage(hookImage, theta );
                g.drawImage(rotatedHook, (int)(hookX()-hookRadius), (int)(hookY()-hookRadius),
                        2*(int)hookRadius, 2*(int)hookRadius, null);
        }
    }

    // Rotate the hook using this function.
    public static BufferedImage rotateImage(final BufferedImage image, final double theta) {
        int w = image.getWidth();
        int h = image.getHeight();
        int type = image.getColorModel().getTransparency();
        BufferedImage imageA;
        Graphics2D graphic;
        (graphic = (imageA = new BufferedImage(w, h, type)).createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphic.rotate(theta, w / 2, h / 2);
        graphic.drawImage(image, 0, 0, null);
        graphic.dispose();
        return imageA;
    }


}
