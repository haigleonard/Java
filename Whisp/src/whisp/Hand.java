/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whisp;

import whisp.Card.Rank;
import whisp.Card.Suit;
import static whisp.Card.Suit.CLUB;
import static whisp.Card.Suit.DIAMOND;
import static whisp.Card.Suit.HEART;
import static whisp.Card.Suit.SPADE;


/**
 *
 * @author Haig
 */
public class Hand {
    int tot = 0;
    public Card[] hand = new Card[5];
    int numinHand = 0;
    public int[] suits = {0,0,0,0};
    public String[] suitsString = {"Hearts", "Diamonds", "Spades", "Clubs"};
    
    Hand(Card card[])
    {
        for(int i = 0 ; i < 5; i ++){
            addCardtoHand(card[i]);
        }
    }
    
    void addCollection(Card card[])
    {
        for(int i = 0 ; i < 5; i ++){
            addCardtoHand(card[i]);
        }
    }
    
    void addCardtoHand(Card card) {
       hand[numinHand] = card;
       switch(hand[numinHand].suit){
           case HEART:
               suits[0]++;
               break;
           case DIAMOND:
               suits[1]++;
               break;
           case SPADE:
               suits[2]++;
               break;
           case CLUB:
               suits[3]++;
               break;
       }
       numinHand++;
    }
    
    public int getTot()
    {
        tot = 0;
        for(Rank m : Rank.values()) {
            for(int i = 0; i < 5;i++){
                if(m.equals(hand[i].rank)){
                    tot += m.getR();
                }
            }
        }
        return tot;
    }
    public int getSpace()
    {
        return 5 - numinHand;
    }

    @Override
    public String toString() {
        return "Hand{" + "hand=" + hand[0] + " " + hand[1] + " " + hand[2] +" " + hand[3] +" " + hand[4] +'}';
    }
    
    void printSuitTot()
    {
        for(int i = 0; i < 4;i++){
            System.out.println(suitsString[i] + ": " + suits[i]);
        }
    }
    
    public int getRankTot(Rank rank)
    {
        int count = 0;
        for(int i = 0; i < 5; i++){
            if(hand[i].rank == rank){
            count++;
            }
        }
        return count;
    }
    public boolean hasSuit2(Suit suit)
    {
        for(int i = 0; i < 5; i++){
            if(hand[i].suit == suit){
            return true;
            }
        }
        return false;
    }
    public Card getCard(int i)
    {
        return hand[i];
    }
    void printHand()
    {
        for(int i = 0; i < 5;i++){
            System.out.println(hand[i]);
        }
    }
    public boolean hasSuit(Suit suit)
    {
        for(int i = 0; i < numinHand; i++){
            if(hand[i].suit == suit){
                return true;
            }
        }
        return false;
    }
    
    public boolean remveSingle(Card card)
    {
        for(int i = 0; i <5; i++)
        {
            if(card.suit == hand[i].suit && card.rank == hand[i].rank)
            {
                hand[i] = null;
                numinHand --;
                return true;
            }
        }
        return false;
    }
    public boolean removeAll()
    {
        numinHand = 0;
        return true;
    }
    public Card removeSpec(Deck deck)
    {
        hand[0] = deck.getCard();
        return hand[0];
    }
}
