
package com.thlink.shuffling;

import static java.lang.Math.abs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Deck 
{
    private HashMap<Integer, Card> deck;
    
    public Deck ()
    {
        int pos = 0;
        deck = new HashMap<>();
        for (int i = 0; i < 2; i++)
        {
            for (Card.Card_Face face : Card.Card_Face.values())
            {
                for (Card.Card_Suits suit : Card.Card_Suits.values())
                {
                    Card c = new Card(face, suit);
                    deck.put(pos, c);
                    pos++;
                }
            }
        }
    }

    public double calculateShuffleQuality ()
    {
        double q = 0;
        Iterator it = deck.entrySet().iterator();
        Map.Entry<Integer, Card> lastPair = null;
        while (it.hasNext()) 
        {
            Map.Entry<Integer, Card> pair = (Map.Entry)it.next();
            if (lastPair != null)
            {
                //Aqui temos pair (a próxima carta) e lastPair (a carta anterior)
                double diffFace = diffWeight(pair.getValue().getFace().getCode() - lastPair.getValue().getFace().getCode());
                if (pair.getValue().getSuit() == lastPair.getValue().getSuit())
                    diffFace *= 1.25;
                q += diffFace;
            }
            lastPair = pair;
        }
        return q;    
    }
    
    private double diffWeight (int pDiff)
    {
        switch (abs(pDiff))
        {
            case 0:
                return 10;
            case 1:
                return 5;
            case 2:
                return 2;
            case 3:
                return 1;
            default:
                return 0;
        }
    }
    
    private int rand ()
    {
        Random gerador = new Random();
        return gerador.nextInt(deck.size());
    }
    
    public Card findRep (int pRep)
    {
        int i, iRep = 0;
        Card lastCard = null;
        for (i = 0; i < deck.size() - pRep; i++)
        {
            Card c = deck.get(i);
            if (lastCard != null && lastCard.getFace().equals(c.getFace()))
            {
                iRep++;
                //if (iRep > 2)
                //    System.out.printf("iRep = %d. \n", iRep);
                if (iRep == pRep)
                {
                    System.out.println("findRep " + iRep);
                    for(int j = i; j > i-pRep; j--)
                    {
                        Card c2 = deck.get(j);
                        System.out.printf("\t%s", c2.toString());
                    }
                    System.out.printf(".\n");
                    return c;
                }
            }
            else
                iRep = 0;
            lastCard = c;
        }
        return null;
    }
    public double shuffle (int pMax)
    {
        for (int i = 0; i < pMax; i++)
        {
            int rnd1 = rand();
            int rnd2 = rand();
          //System.out.printf("rnd1 = %d. rnd2 = %d.\n", rnd1, rnd2);
            Card c1 = deck.get(rnd1);
            Card c2 = deck.get(rnd2);
            
            deck.put(rnd1, c2);
            deck.put(rnd2, c1);
        }
        return calculateShuffleQuality();
    }
    
    public HashMap<Integer, Card> getDeck() 
    {
        return deck;
    }

    public void setDeck(HashMap<Integer, Card> deck) {
        this.deck = deck;
    }
}
