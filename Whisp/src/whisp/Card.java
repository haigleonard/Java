/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whisp;

/**
 *
 * @author Haig
 */
public class Card implements Comparable<Card>{

    
    
    public enum Rank {TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11); 
    private int r;
 
    private Rank(int code) {
        this.r = code;
    }
 
    public int getR() {
        return r;
    }
    }
    public enum Suit { CLUB(0), DIAMOND(1), HEART(2), SPADE(3);
    private int s;
 
    private Suit(int code) {
        this.s = code;
    }
 
    public int getS() {
        return s;
    }
    }
    
    Rank rank;
    Suit suit;
    
    Card(Rank r, Suit s){
        rank = r;
        suit = s;
    }
    
    public Rank getRank()
    {
        return rank;
    }
    public Suit getSuit()
    {
        return suit;
    }
    
    @Override
    public int compareTo(Card t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Card{" + "rank=" + rank + ", suit=" + suit + '}';
    }
}
