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
public class Trick {
    Hand hand;
    boolean turn = false;
   Trick(Hand h)
   {
       hand = h;
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
}
