
package com.thlink.shuffling;


public class Game 
{
    private Deck deck;
    
    public double shuffle()
    {
        deck = new Deck();
        return deck.shuffle(0);
        
    }
}
