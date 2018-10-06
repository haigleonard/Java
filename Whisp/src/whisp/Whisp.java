/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whisp;

import java.awt.EventQueue;


/**
 *
 * @author Haig
 */
public class Whisp {
   
    public static void main(String[] args) {
        
        GUIClass window = new GUIClass();
        
        
        /*
        System.out.println("Hand: " +hand.toString());
        System.out.println("Deck Size:" + deck.getDeckSize());
        System.out.println("Hand Contains:" + hand.hasSuit(Card.Suit.CLUB));
        hand.printSuitTot();
        System.out.println("Hand Contains Ranks:" + hand.getRankTot(Rank.ACE));
        System.out.println("Hand Contains Ranks:" + hand.hasSuit2(Suit.HEART));
        System.out.println("Hand Value:" + hand.getTot());
        */
        
        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {
                    window.frame.setVisible(true);
                    window.mouse();
                    
                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

        
        
        
    }
    
}
