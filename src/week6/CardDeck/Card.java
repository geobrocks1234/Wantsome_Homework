package week6.CardDeck;

public class Card {
    private Suit mSuit;
    private Rank mRank;

    public Card ( Suit suit, Rank rank ) {
        this.mSuit = suit;
        this.mRank = rank;
    }

    public Suit getSuit () {
        return mSuit;
    }

    public Rank getRank () {
        return mRank;
    }

    public int getValue () {
        return mRank.ordinal () + 2;
    }

    @Override
    public boolean equals ( Object o ) {
        return (o != null && o instanceof Card && ((Card) o).mRank == mRank && ((Card) o).mSuit == mSuit);
    }

    @Override
    public String toString () {
        return "Card{" +
                "Suit: " + mSuit +
                ", Rank: " + mRank +
                '}';
    }
}