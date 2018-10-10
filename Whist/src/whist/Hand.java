/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import whist.Card.Rank;
import whist.Card.Suit;
import static whist.Card.Suit.CLUB;
import static whist.Card.Suit.DIAMOND;
import static whist.Card.Suit.HEART;
import static whist.Card.Suit.SPADE;


/**
 *
 * @author Haig
 */
public class Hand implements Iterator<Card>{
    int Score = 0;
    int current = 0;
    int tot = 0;
    public ArrayList<Card> hand = new ArrayList<Card>();
    int numinHand = 0;
    public int[] suits = {0,0,0,0};
    public String[] suitsString = {"Hearts", "Diamonds", "Spades", "Clubs"};
    
    Hand(Card card[])
    {
        for(int i = 0 ; i < 13; i ++){
            addCardtoHand(card[i]);
        }
        sortHand();
    }
    
    void addCollection(Card card[])
    {
        for(int i = 0 ; i < 13; i ++){
            addCardtoHand(card[i]);
        }
    }
    int getSize(){
        return hand.size();
    }
    void addCardtoHand(Card card) {
       hand.add(card);
       switch(hand.get(numinHand).suit){
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
            for(int i = 0; i < hand.size();i++){
                if(m.equals(hand.get(i).rank)){
                    tot += m.getR();
                }
            }
        }
        return tot;
    }
    public int getSpace()
    {
        return 13 - numinHand;
    }
    boolean handContains(Suit s)
    {
        if(hand.contains(s)){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Hand{" + "hand=" + hand.get(0) + " " + hand.get(0) + " " + hand.get(0) +" " + hand.get(0) +" " + hand.get(0) +'}';
    }
    
    void printSuitTot()
    {
        for(int i = 0; i < 4;i++){
            System.out.println(suitsString[i] + ": " + suits[i]);
        }
    }
    
    public int getSuitTot(Suit suit)
    {
        int count = 0;
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i).suit == suit){
            count++;
            }
        }
        return count;
    }
    public boolean hasSuit2(Suit suit)
    {
        for(int i = 0; i < 5; i++){
            if(hand.get(i).suit == suit){
            return true;
            }
        }
        return false;
    }
    public Card getCard(int i)
    {
        return hand.get(i);
    }
    void printHand()
    {
        for(int i = 0; i < 5;i++){
            System.out.println(hand.get(i));
        }
    }
    public boolean hasSuit(Suit suit)
    {
        for(int i = 0; i < numinHand; i++){
            if(hand.get(i).suit == suit){
                return true;
            }
        }
        return false;
    }
    
    public boolean remveSingle(Card card)
    {
        for(int i = 0; i <13; i++)
        {
            if(hand.get(i) != null){
                if(card.suit.equals(hand.get(i).suit) && card.rank.equals(hand.get(i).rank))
            {
                hand.remove(i);
                numinHand --;
                sortHand();
                return true;
            }
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
        return hand.get(0);
    }

    @Override
    public boolean hasNext() {
        return (current < hand.size());
    }

    @Override
    public Card next() {
        return hand.get(current++);    
    }
    
    void sortHand()
    {
        CompareAscendingRank CP = new CompareAscendingRank();
        CompareAscendingSuit CS = new CompareAscendingSuit();
        hand.sort(CP);
         hand.sort(CS);
    }
    
    public class CompareAscendingRank implements Comparator<Card>
    {
        public int compare(Card t, Card t1) {
           return t.rank.ordinal() - t1.rank.ordinal();

        }
    }
    public class CompareAscendingSuit implements Comparator<Card>
    {
        public int compare(Card t, Card t1) {
           return t.suit.ordinal() - t1.suit.ordinal();

        }
    }
}
