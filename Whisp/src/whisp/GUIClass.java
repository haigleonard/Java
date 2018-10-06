/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whisp;
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
    JLabel[] labelArray = new JLabel[5];
    JLabel[] UIArray = new JLabel[5];

    Rank[] ranks = new Rank[5];
    Suit[] suits = new Suit[5];
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
        UI("Single", 190);
        setimage(hand.getCard(0).rank, hand.getCard(0).suit, 10);
        UI("Single", 710);
        setimage(hand.getCard(1).rank, hand.getCard(1).suit, 520);
        UI("Single", 1300);
        setimage(hand.getCard(2).rank, hand.getCard(2).suit, 1030);
        UI("Single", 1490);
        setimage(hand.getCard(3).rank, hand.getCard(3).suit, 1540);
        UI("Single", 2000);
        setimage(hand.getCard(4).rank, hand.getCard(4).suit, 2050);
        

    }
    
    public void UI(String u, int i)
    {
        JLabel label = new JLabel(); 
        label = new JLabel("");
        Image img = new ImageIcon(this.getClass().getResource("/" + u + ".png")).getImage();
        label.setIcon((Icon) new ImageIcon(img));
        label.setBounds(i, 350,175,75);
        frame.getContentPane().add(label);
        UIArray[C] = label;
        UIArray[C].setVisible(false);
    }
    
    public void setimage(Rank t1, Suit t2, int i){
      
        String t3 = t1.toString()+t2.toString();
        JLabel label = new JLabel(); 
        label = new JLabel("");
        Image img = new ImageIcon(this.getClass().getResource("/" + t3 + ".png")).getImage();
        label.setIcon((Icon) new ImageIcon(img));
        label.setBounds(i, 200,500,750);
        frame.getContentPane().add(label);
        ranks[C] = t1;
        suits[C] = t2;
        labelArray[C] = label;C++;
        frame.setScore(hand.getTot());
    }
    
    public boolean setNewimage(Rank t1, Suit t2, int i, int e){
        String t3 = t1.toString()+t2.toString();
        Image img = new ImageIcon(this.getClass().getResource("/" + t3 + ".png")).getImage();
        labelArray[e].setIcon((Icon) new ImageIcon(img));
        ranks[e] = t1;
        suits[e] = t2;
        frame.setDeckSize(deck.getDeckSize());
        frame.setScore(hand.getTot());
        return true;
    }
    
    void mouse()
    {
        
        UIArray[0].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 10, 0);
                    UIArray[0].setVisible(false);

            }
        });
        UIArray[1].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 510, 1);
                    UIArray[1].setVisible(false);

            }
        });
        UIArray[2].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 1030, 2);
                    UIArray[2].setVisible(false);

            }
        });
        UIArray[3].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                   Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 1540, 3);
                    UIArray[3].setVisible(false);

            }
        });
        UIArray[4].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                    Card card = hand.removeSpec(deck);
                    setNewimage(card.rank, card.suit, 2050, 4);
                    UIArray[4].setVisible(false);

            }
        });

       
        labelArray[0].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    UIArray[0].setVisible(true);

                }

                });
        
         labelArray[1].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    UIArray[1].setVisible(true);
                }
                });
         labelArray[2].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    UIArray[2].setVisible(true);

                    
                }
                });
         labelArray[3].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                                        UIArray[3].setVisible(true);

                    
                }
                });
         labelArray[4].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                                        UIArray[4].setVisible(true);

                    
                }
                });
       
        
    }
 

}
