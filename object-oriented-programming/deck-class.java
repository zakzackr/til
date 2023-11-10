public class Main {
    
    public static void main(String[] args) {
        // shuffle in-place
        Deck d1 = new Deck();
        System.out.println(d1);
        d1.shuffleDeck();
        System.out.println(d1);

        // shuffle in-place
        System.out.println();
        Card[] d2 = Deck.createDeck();
        System.out.println(Deck.cardToString(d2));
        Deck.shuffleDeckInPlace(d2);
        System.out.println(Deck.cardToString(d2));

        // shuffle out-of-place
        System.out.println();
        Card[] d3 = Deck.createDeck();
        System.out.println(Deck.cardToString(d3));
        Card[] shuffledD3 = Deck.shuffleDeckOutOfPlace(d3);
        System.out.println(Deck.cardToString(d3));
        System.out.println(Deck.cardToString(shuffledD3));
    }
}

class Card{
    public String rank;
    public String suit;

    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String toString(){
        return rank + suit;
    }
}

class Deck{
    public static final String[] SUITS = {"♠","♡","♢","♣"};
    public static final String[] RANKS = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    public Card[] cards;

    public Deck(){
        this.cards = Deck.createDeck();
    };

    public static Card[] createDeck(){
        int s = SUITS.length;
        int r = RANKS.length;
        Card[] cards = new Card[s * r];

        for (int i = 0; i < s; i++){
            for (int j = 0; j < r; j++){
                cards[i * r + j] = new Card(RANKS[j], SUITS[i]);
            }
        }

        return cards;
    }

    // shuffle the current deck in-place
    public void shuffleDeck(){
        int len = cards.length;
        for (int i = len - 1; i >= 0; i--){
            int random = (int)Math.floor(Math.random() * (i + 1));
            Card temp = cards[i];
            cards[i] = cards[random];
            cards[random] = temp;
        }
    }

    // this method does not rely on the instance as it is defined with static keyword
    // shuffle the deck given as a parameter in-place
    public static void shuffleDeckInPlace(Card[] shuffledCards){
        int len = shuffledCards.length;
        for (int i = len - 1; i >= 0; i--){
            int random = (int)Math.floor(Math.random() * (i + 1));
            Card temp = shuffledCards[i];
            shuffledCards[i] = shuffledCards[random];
            shuffledCards[random] = temp;
        }
    }

    // error
    // java: staticでない変数 thisをstaticコンテキストから参照することはできません
//    public static void shuffleDeckInPlace2(Card[] shuffledCards){
//        this.cards = shuffledCards;
//        this.shuffleDeck();
//    }

    // this method does not rely on the instance as it is defined with static keyword
    // shuffle the deck given as a parameter out-of-place, which requires extra memory space
    public static Card[] shuffleDeckOutOfPlace(Card[] shuffledCards){
        Card[] copy = new Card[shuffledCards.length];
        for (int i = 0; i < shuffledCards.length; i++){
            copy[i] = shuffledCards[i];
        }

        for (int i = copy.length - 1; i >= 0; i--){
            int random = (int)Math.floor(Math.random() * (i + 1));
            Card temp = copy[i];
            copy[i] = copy[random];
            copy[random] = temp;
        }

        return copy;
    }

    public static String cardToString(Card[] cards){
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < cards.length; i++){
            string.append("(" + cards[i].toString() + ")");
        }

        return string.toString();
    }


    public String toString(){
        return Deck.cardToString(cards);
    }
}

