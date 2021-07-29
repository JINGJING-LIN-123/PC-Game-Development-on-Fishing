import java.util.ArrayList;
import java.util.Iterator;

public class Card implements Comparable<Card> {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }

    @Override
    public int compareTo(Card other) {
        if (suit.ordinal() != other.getSuit().ordinal()) {
            return suit.ordinal() - other.getSuit().ordinal();
        } else {
            return value.ordinal() - other.getValue().ordinal();
        }
    }

    public static void main(String[] args) {
        ArrayList<Character> alist = new ArrayList<Character>();
        for (int i=0; i<26; i++) {
            alist.add((char) ('A' + i));
        }
        Iterator<Character> it = alist.iterator();
        while(it.hasNext()) {
            Character c = it.next();
            if (c.equals('A') || c.equals('E') || c.equals('I') || c.equals('O') || c.equals('U')) {
                it.remove();
            }
        }
        Iterator<Character> it2 = alist.iterator();
        while(it2.hasNext()) {
            System.out.println(it2.next());
        }
        Card diamondAce = new Card(Suit.DIAMONDS, Value.ACE);
        Card clubTwo = new Card(Suit.CLUBS, Value.TWO); // Either TWO or 2 is fine
        System.out.println(diamondAce.compareTo(clubTwo) > 0);
    }
}
