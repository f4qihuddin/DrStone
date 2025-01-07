package model;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck
{
    private ArrayList<Card> deck;

    public CardDeck()
    {
        this.deck = new ArrayList<>();
    }

    public void addCardToDeck(Card card)
    {
        this.deck.add(card);
    }

    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    public Card takeTopCard()
    {
        if (deck.size() > 0)
        {
            return deck.remove(0);
        }
        else
        {
            return null;
        }
    }

    public int getNumOfCards()
    {
        return deck.size();
    }
}
