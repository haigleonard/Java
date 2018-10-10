/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whist;

import java.util.Random;
import whist.Card.Suit;

/**
 *
 * @author Haig
 */
public class Trick implements Player{
    Hand hand;
    boolean turn = false;
    int[] suitCounts = {0,0,0,0};
   Trick(Hand h)
   {
       hand = h;
   }
   void updateStats()
   {
       suitCounts[0] =hand.getSuitTot(Card.Suit.HEART);
       suitCounts[1] =hand.getSuitTot(Card.Suit.DIAMOND);
       suitCounts[2] =hand.getSuitTot(Card.Suit.SPADE);
       suitCounts[3] =hand.getSuitTot(Card.Suit.CLUB);
   }
   public Hand getHand()
   {
       return hand;
   }
   public boolean getTurn()
   {
       return turn;
   }
   public void setTurn()
   {
       if(turn){
        turn = false;
       }else{
        turn = true;
       }
   }
   public void setTurnOff()
   {
       turn = false;
   }

    @Override
    public Card playCard(Suit trump) {
        
        if(hand.handContains(trump))
        {
            for(int i = hand.getSize(); i>0; i --){
              Card card = hand.getCard(i);
              if(card.suit == trump){
                  removeCard(card);
                  return card;
              }
            }
        }
        Random r = new Random();
        int rand = r.nextInt(hand.getSize()-0);
        Card card = hand.getCard(rand);
        return card;
    }

    @Override
    public void removeCard(Card card) {
        hand.remveSingle(card);
    }

    @Override
    public Card addCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
