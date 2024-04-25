
package com.thlink.shuffling;

public class Main 
{
    public static void main (String [] args)
    {
        //caculateSQ();
        findReps(5);
    }
    
    private static void findReps (int pRep)
    {
        Deck d = new Deck();
        int iRep = 0;
        for (int i = 0; i < 1; i++)
        {
            double q = d.shuffle(200);
            Card c = d.findRep(pRep);
            if (c != null)
            {
                System.out.printf("Achou %d na tentativa %d. Carta = %s.\n", pRep, i, c);
                iRep++;
            }
        }
        System.out.printf("Reps. encontradoas: %d. \n", iRep);
    }
    
    private static void caculateSQ ()
    {
        for (int i = 0; i < 250; i++)
        {
            Deck d = new Deck();
            double q = d.shuffle(i);
            System.out.printf("%d\t%6.3f \n", i, q);
        }
    }
}
