/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whist;

/**
 *
 * @author Haig
 */
public interface Player {
    Card playCard(Card.Suit trump);
    void removeCard(Card card);
    Card addCard();
}
