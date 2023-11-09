public class Main {

    public static void main(String[] args) {
        Deck d = new Deck();
        System.out.println(d);

        Card[] myCards = Deck.createDeck();
        System.out.println();
        System.out.println(Deck.cardsToString(myCards));
        System.out.println();

        d.shuffleDeck();
        System.out.println(d);

        d.shuffleDeck();
        System.out.println(d);
    }
}

class Card{
    public String rank;
    public String suit;

    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return rank + suit;
    }
}

class Deck{
    public static final String[] SUITS = {"♠","♡","♢","♣"};
    public static final String[] RANKS = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    public Card[] cards;

    public Deck(){
        this.cards = Deck.createDeck();
    };

    public static Card[] createDeck(){
        Card[] cards = new Card[SUITS.length * RANKS.length];

        for (int i = 0; i < SUITS.length; i++){
            for (int j = 0; j < RANKS.length; j++){
                cards[i * RANKS.length + j] = new Card(RANKS[j], SUITS[i]);
            }
        }

        return cards;
    }

    public void shuffleDeck(){
        for (int i = cards.length - 1; i >= 0; i--){
            int random = (int)Math.floor(Math.random() * (i + 1));
            Card temp = cards[random];
            cards[random] = cards[i];
            cards[i] = temp;
        }
    }

    public static String cardsToString(Card[] cards){
        StringBuilder string = new StringBuilder();

        for (Card card: cards){
            string.append("(" + card.rank + card.suit + ") ");
        }

        return string.toString();
    }

    public String toString(){
        return Deck.cardsToString(cards);
    }
}
