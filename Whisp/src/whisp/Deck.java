/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whisp;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import whisp.Card.Rank;
import whisp.Card.Suit;

/**
 *
 * @author Haig
 */
public class Deck {

        public ArrayList<Card> deck = new ArrayList<Card>();
        
        public Deck()
        {
                for(Rank r : Rank.values()) {
                     for(Suit s : Suit.values()) {
                        Card card= new Card(r, s);
                        deck.add(card);
                     }
                }
                    
                
                Collections.shuffle(deck);
        }
        
        public Card[] getHand()
        {
            Card[] hand = new Card[5];
            for(int i = 0; i < 5; i ++){
                hand[i] = deck.remove(0);
            }
            return hand;
        }
        
        public void shuffle()
        {
            Collections.shuffle(deck);
        }
        
        public void print()
        {
            for(int i = 0; i< deck.size(); i++){
                System.out.println(i + "   " + deck.get(i));
            }
        }
        
        public int getDeckSize()
        {
            return deck.size();
        }
        
        public Card getCard()
        {
            return deck.remove(0);
        }
        final void newDeck()
        {
            deck.clear();
            for(Suit s: Suit.values()){
                    for(Rank r: Rank.values()){
                        Card card= new Card(r, s);
                        deck.add(card);
                    }
                }
                Collections.shuffle(deck);
        }
}