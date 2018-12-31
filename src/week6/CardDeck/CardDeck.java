package week6.CardDeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardDeck {
    private ArrayList <Card> mCards;
    private ArrayList <Card> mPulledCards;
    private Random mRandom;

    public CardDeck () {
        mRandom = new Random ();
        mPulledCards = new ArrayList <Card> ();
        mCards = new ArrayList <Card> ( Suit.values ().length * Rank.values ().length );
        reset ();
    }

    public ArrayList <Card> getmCards () { return mCards; }

    public ArrayList <Card> getmPulledCards () { return mPulledCards; }

    public Random getmRandom () { return mRandom; }

    public void reset () {
        mPulledCards.clear ();
        mCards.clear ();
        /* Creating all possible cards... */
        for (Suit s : Suit.values ()) {
            for (Rank r : Rank.values ()) {
                Card c = new Card ( s, r );
                mCards.add ( c );
            }
        }
    }

    /**
     * get a random card, removing it from the pack
     *
     * @return
     */
    public Card pullRandom () {
        if ( mCards.isEmpty () )
            return null;

        Card res = mCards.remove ( randInt ( 0, mCards.size () - 1 ) );
        if ( res != null )
            mPulledCards.add ( res );
        return res;
    }

    public ArrayList<Card> deal(int cardsToDeal){
        ArrayList<Card> cards = new ArrayList <>();
        if(getAvailableCardCount ()==0){
            System.out.println ("Number of cards in the pack is zero.");
            return cards;
        }
        if(cardsToDeal > getAvailableCardCount()) {
            System.out.println("We can deal just "+getAvailableCardCount ()+" cards.");
            for(int i = 0; i < getAvailableCardCount(); i++){
                Card card = mCards.get(i);
                cards.add(card);
                mPulledCards.add(card);
            }
        }
        else {
            while(cardsToDeal!=0){
                Card card = mCards.get(cardsToDeal);
                cards.add (card);
                mPulledCards.add (card);
                cardsToDeal--;
            }
        }
        for(Card card: mPulledCards){
            mCards.remove(card);
        }
        Collections.shuffle(cards);
        return cards;
    }

    /**
     * Get a random cards, leaves it inside the pack
     *
     * @return
     */
    public Card getRandom () {
        if ( mCards.isEmpty () )
            return null;

        Card res = mCards.get ( randInt ( 0, mCards.size () - 1 ) );
        return res;
    }

    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public int randInt ( int min, int max ) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = mRandom.nextInt ( (max - min) + 1 ) + min;
        return randomNum;
    }

    public void shuffle(){
        for(Card card: mPulledCards){
            mCards.add(card);
        }
        for(Card card: mCards){
            mPulledCards.remove(card);
        }
        Collections.shuffle(mCards);
    }

    public int getAvailableCardCount(){
        return mCards.size();
    }

    public int getUsedCardCount(){
        return mPulledCards.size();
    }

    public boolean isEmpty () { return mCards.isEmpty (); }
}
