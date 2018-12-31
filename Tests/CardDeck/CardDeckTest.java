package CardDeck;

import org.junit.Test;
import week6.CardDeck.Card;
import week6.CardDeck.CardDeck;
import java.util.List;
import static org.junit.Assert.*;

public class CardDeckTest {

    @Test
    public void testThatCanDealGivenNumberOfCards(){
        CardDeck cardDeck = new CardDeck();
        List<Card> deal1 = cardDeck.deal(21);
        List<Card> deal2 = cardDeck.deal(44);

        assertEquals(21, deal1.size());
        assertNotEquals(44, deal2.size());
    }

    @Test
    public void testThatCanDealTheRestOfCardsFromPackAfterFirstDeal(){
        CardDeck cardDeck = new CardDeck();
        cardDeck.deal(21);
        List<Card> deal = cardDeck.deal(52);

        assertEquals(31, deal.size());
    }

    @Test
    public void testThatCardsFromPackAreAllAvailableAfterShuffle(){
        CardDeck cardDeck = new CardDeck();
        cardDeck.deal(22);
        cardDeck.shuffle();

        assertEquals(52, cardDeck.getAvailableCardCount());
    }

    @Test
    public void testThatBeforeDealAreAllCardsAvailableInPack(){
        CardDeck cardDeck = new CardDeck();

        assertEquals(52, cardDeck.getAvailableCardCount());
    }

    @Test
    public void testThatNumberOfAvailableCardsAfterDealsAreCorrect(){
        CardDeck cardDeck = new CardDeck();
        List<Card> deal1 = cardDeck.deal(2);
        List<Card> deal2 = cardDeck.deal(4);
        List<Card> deal3 = cardDeck.deal(10);
        List<Card> deal4 = cardDeck.deal(15);

        assertEquals(52-(deal1.size ()+deal2.size ()+deal3.size ()+deal4.size ()), cardDeck.getAvailableCardCount());
    }

    @Test
    public void testThatNumberOfPulledCardsAreZeroBeforeDealing(){
        CardDeck cardDeck = new CardDeck();

        assertEquals ( 0, cardDeck.getUsedCardCount());
    }

    @Test
    public void testThatNumberOfPulledCardsAreCorrectAfterDealing(){
        CardDeck cardDeck = new CardDeck();
        List<Card> deal1 = cardDeck.deal(2);
        List<Card> deal2 = cardDeck.deal(4);
        List<Card> deal3 = cardDeck.deal(10);

        assertEquals(deal1.size ()+deal2.size ()+deal3.size (), cardDeck.getUsedCardCount());
    }
}