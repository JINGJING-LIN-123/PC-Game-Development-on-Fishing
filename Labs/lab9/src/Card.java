public class Card {
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

    public static Suit getRandomSuit() {
        int max = Suit.values().length - 1;
        int pick = (int)Math.round(Math.random() * max);
        return Suit.values()[pick];
    }

    public static Value getRandomValue() {
        int max = Value.values().length - 1;
        int pick = (int)Math.round(Math.random() * max);
        return Value.values()[pick];
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }

    public static String getRandomCard() {
        Card card = new Card(getRandomSuit(), getRandomValue());
        return card.toString();
    }

    public static void printBet() {
        Card card = new Card(getRandomSuit(), getRandomValue());
        switch (card.getSuit()) {
            case CLUB:
                System.out.println("Bet 10 dollars for " + card.toString()); break;
            case SPADE:
                System.out.println("Bet 20 dollars for " + card.toString()); break;
            case HEART:
                System.out.println("Bet 30 dollars for " + card.toString()); break;
            case DIAMOND:
                System.out.println("Bet 40 dollars for " + card.toString()); break;
            default:
                System.out.println("Invalid Suit!"); break;
        }
    }

    public static Card[] createDeck() {
        Card[] deck = new Card[52];
        for(int i=0; i<Suit.values().length; i++) {
            for (int j = 0; j < Value.values().length; j++) {
                deck[i * Value.values().length + j] = new Card(Suit.values()[i], Value.values()[j]);
            }
        }
        return deck;
    }

    public static final Card[] DECK = createDeck();

    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            System.out.println(getRandomCard());
        }
        printBet();
        Card newcard = new Card(getRandomSuit(),getRandomValue());
        DECK = createDeck();
    }
}
