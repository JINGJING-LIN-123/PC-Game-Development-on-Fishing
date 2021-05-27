import java.lang.reflect.Constructor;

public class PetRock {
    private String name;
    private boolean happy = false;
    private int mass = 0;

    public PetRock(String name, int mass) {
        if (name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }

    public boolean isHappy() {
        return happy;
    }

    public void playWithRock() {
        happy = true;
    }

    public String getHappyMessage(){
        if (!happy) {
            throw new IllegalStateException();
        }
        return "I'm happy!";
    }

    public String toString(){
        return name+" "+mass;
    }

    public int getFavNumber(){
        return 42;
    }

    public void waitTillHappy(){
        while (!happy) {
            // do nothing!
        }
    }
}
