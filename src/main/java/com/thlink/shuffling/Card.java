
package com.thlink.shuffling;


public class Card 
{
    public enum Card_Face { 
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(11), QUEEN(12), KING(13);
                            
        int iFace;
        private Card_Face (int pFace)
        {
            iFace = pFace;
        }
        public int getCode()
        {
            return this.iFace;
        }
    };
    public enum Card_Suits { HARTS, SPADES, CLUBS, DIAMOND};
    
    
    private Card_Face face;
    private Card_Suits suit;
    
    @Override
    public String toString ()
    {
        return String.format("%s @ %s", this.face.toString(), this.suit.toString());
    }
    
    public Card (Card_Face pFace, Card_Suits pSuit)
    {
        this.face = pFace;
        this.suit = pSuit;
    }
    
    public Card_Face getFace() {
        return face;
    }

    public void setFace(Card_Face face) {
        this.face = face;
    }

    public Card_Suits getSuit() {
        return suit;
    }

    public void setSuit(Card_Suits suit) {
        this.suit = suit;
    }
    
    
    
}
