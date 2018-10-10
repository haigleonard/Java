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
public interface Strategy {
    void chooseCard(Hand h, Trick t);
    void updateData(Trick c);
}
