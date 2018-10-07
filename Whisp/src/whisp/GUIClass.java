/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whisp;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import whisp.Card.Rank;
import whisp.Card.Suit;


/**
 *
 * @author Haig
 */
public class GUIClass {
    
    GUI frame = new GUI();;
    JLabel[] labelArray = new JLabel[13];
    JLabel[] UIArray = new JLabel[5];

    Rank[] ranks = new Rank[13];
    Suit[] suits = new Suit[13];
    int C=0;
    Deck deck = new Deck();
    Hand hand = new Hand(deck.getHand());
    GUIClass(){
        initialize();
        
    }

    private void initialize() {

        

        frame.setBounds(100, 100, 3500, 1500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(null);
        frame.setDeckSize(deck.getDeckSize());
        frame.setScore(hand.getTot());
        Container c = frame.getContentPane(); 
       
        c.setBackground(Color.DARK_GRAY);
        setimage(hand.getCard(0).rank, hand.getCard(0).suit, 10);
        setimage(hand.getCard(1).rank, hand.getCard(1).suit, 220);
        setimage(hand.getCard(2).rank, hand.getCard(2).suit, 430);
        setimage(hand.getCard(3).rank, hand.getCard(3).suit, 640);
        setimage(hand.getCard(4).rank, hand.getCard(4).suit, 850);
        setimage(hand.getCard(5).rank, hand.getCard(5).suit, 1060);
        setimage(hand.getCard(6).rank, hand.getCard(6).suit, 1270);
        setimage(hand.getCard(7).rank, hand.getCard(7).suit, 1480);
        setimage(hand.getCard(8).rank, hand.getCard(8).suit, 1690);
        setimage(hand.getCard(9).rank, hand.getCard(9).suit, 1900);
        setimage(hand.getCard(10).rank, hand.getCard(10).suit, 2110);
        setimage(hand.getCard(11).rank, hand.getCard(11).suit, 2320);
        setimage(hand.getCard(12).rank, hand.getCard(12).suit, 2540);
    }
    
    
    
    public void setimage(Rank t1, Suit t2, int i){
      
        String t3 = t1.toString()+t2.toString();
        JLabel label = new JLabel(); 
        label = new JLabel("");
        label.setBounds(i, 800,250,400);
        Image img = new ImageIcon(this.getClass().getResource("/" + t3 + ".png")).getImage();
        img = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
        label.setIcon((Icon) new ImageIcon(img));
        frame.getContentPane().add(label);
        ranks[C] = t1;
        suits[C] = t2;
        labelArray[C] = label;C++;
        frame.setScore(hand.getTot());
    }
    
    public boolean setNewimage(Rank t1, Suit t2, int e){
        String t3 = t1.toString()+t2.toString();
        Image img = new ImageIcon(this.getClass().getResource("/" + t3 + ".png")).getImage();
        img = img.getScaledInstance(labelArray[e].getWidth(), labelArray[e].getHeight(),Image.SCALE_SMOOTH);
        labelArray[e].setIcon((Icon) new ImageIcon(img));
        ranks[e] = t1;
        suits[e] = t2;
        frame.setDeckSize(deck.getDeckSize());
        frame.setScore(hand.getTot());
        return true;
    }
    
    void mouse()
    {
        labelArray[0].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                   Card card = hand.removeSpec(deck);
                   setNewimage(card.rank, card.suit, 0);
                }
                });
        
         labelArray[1].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 1);
                }
                });
         labelArray[2].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 2);
                }
                });
         labelArray[3].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 3);
                }
                });
         labelArray[4].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 4);
                }
                });
         labelArray[5].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                   Card card = hand.removeSpec(deck);
                   setNewimage(card.rank, card.suit, 5);
                }
                });
        
         labelArray[6].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 6);
                }
                });
         labelArray[7].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 7);
                }
                });
         labelArray[8].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 8);
                }
                });
         labelArray[9].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 9);
                }
                });
         labelArray[10].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                   Card card = hand.removeSpec(deck);
                   setNewimage(card.rank, card.suit, 10);
                }
                });
        
         labelArray[11].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 11);
                }
                });
         labelArray[12].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 12);
                }
                });
        
       
        
    }
}
