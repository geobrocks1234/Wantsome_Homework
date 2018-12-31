package week6.CardDeck;

public class CardDeckTest {
    public static void main(String[] args) {
        CardDeck deck = new CardDeck();

        System.out.println("Initial deck cards count: " + deck.getAvailableCardCount());
        System.out.println(deck.deal(5)); // <- print 5 cards 3 times
        System.out.println(deck.deal(5));
        System.out.println(deck.deal(5));
        System.out.println("Used cards count: " + deck.getUsedCardCount());
        deck.shuffle();
        System.out.println("After shuffle deck cards count: " + deck.getAvailableCardCount());
        System.out.println(deck.deal(5)); // <- another 5 cards
        System.out.println("Used cards count: " + deck.getUsedCardCount());
    }
}
