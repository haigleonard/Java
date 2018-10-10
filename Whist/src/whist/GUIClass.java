/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whist;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import whist.Card.Rank;
import whist.Card.Suit;


/**
 *
 * @author Haig
 */
public class GUIClass {
    
    GUI frame = new GUI();
    int played = 0;
    Card[] playedCard = new Card[4];
    public ArrayList<JLabel> labelArray = new ArrayList<JLabel>();
    public JLabel[] ps = new JLabel[3];
    public Trick[] ts = new Trick[4];
    int[] team = {0,0};
    JLabel next = new JLabel();
    int pos = 10;
    Deck deck = new Deck();
    Suit trump = deck.getTrump();
    Random r = new Random();
    int rand = 0;
    
    GUIClass(){
        for(int i = 0; i < 4; i++){
           Hand hand = new Hand(deck.getHand());
           Trick p = new Trick(hand);
           ts[i] = p;
        }
        for(int i = 0; i < 3; i++){
            JLabel Jp = new JLabel();
            ps[i] = Jp;
        }
        
        next.setBounds(1400,100,250,100);
        Image img = new ImageIcon(this.getClass().getResource("/Single.png")).getImage();
        img = img.getScaledInstance(next.getWidth(), next.getHeight(),Image.SCALE_SMOOTH);
        next.setIcon((Icon) new ImageIcon(img));
        frame.getContentPane().add(next);
        
        JLabel label = new JLabel();
        label.setBounds(1000, 300,250,400);
        img = new ImageIcon(this.getClass().getResource("/" + trump.toString() + ".png")).getImage();
        img = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
        label.setIcon((Icon) new ImageIcon(img));
        frame.getContentPane().add(label);
        
        frame.setBounds(100, 100, 3500, 1500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        Container c = frame.getContentPane(); 
       
        c.setBackground(Color.DARK_GRAY);
        aiMove();
        for(int i = 0; i < 13; i ++){
             JLabel l = new JLabel();
             l.setBounds(pos, 800,250,400);
             labelArray.add(l);
             frame.getContentPane().add(l);
             pos+=200;
         }
         for(int i = 0; i < 13; i ++){
              setNewimage(); 
         }
        updateStats();
        
    }

    
    void updateStats()
    {
        frame.setDeckSize(deck.getDeckSize());
        frame.setScore(ts[0].getHand().getTot());
        frame.setSuits(ts[0].getHand().getSuitTot(Suit.HEART), ts[0].getHand().getSuitTot(Suit.DIAMOND), ts[0].getHand().getSuitTot(Suit.SPADE),ts[0].getHand().getSuitTot(Suit.CLUB));
        frame.setTeamScore(team[0], team[1]);
    }
    
    public void setNewimage(){
       for(int i = 0; i < ts[0].getHand().getSize(); i++){
                       if(ts[0].getHand().getCard(i) != null){
                        String t3 = ts[0].getHand().getCard(i).rank.toString()+ts[0].getHand().getCard(i).suit.toString();
                        Image img = new ImageIcon(this.getClass().getResource("/" + t3 + ".png")).getImage();
                        img = img.getScaledInstance(labelArray.get(i).getWidth(), labelArray.get(i).getHeight(),Image.SCALE_SMOOTH);
                        labelArray.get(i).setIcon((Icon) new ImageIcon(img));
                        
                       }
                   }
    }
    
    public void round()
    {
       pos = 10;
       int temp = played;
       for(int i = 1; i <4-temp; i ++){
           playedCard[i] = ts[i].playCard(trump);
            setAIimage(playedCard[i].rank, playedCard[i].suit, pos, ps[i-1]);
            
            pos+=200;played++;
        }
       roundWinner();
       int i = ts[0].getHand().getSize();
       frame.remove(labelArray.get(i));
       frame.revalidate();
       frame.repaint();
       labelArray.remove(i);
       updateStats();
    }
    
    public void setAIimage(Rank t1, Suit t2, int i, JLabel j){
      
        String t3 = t1.toString()+t2.toString();
        j.setBounds(i, 200,250,400);
        Image img = new ImageIcon(this.getClass().getResource("/" + t3 + ".png")).getImage();
        img = img.getScaledInstance(j.getWidth(), j.getHeight(),Image.SCALE_SMOOTH);
        j.setIcon((Icon) new ImageIcon(img));
        frame.getContentPane().add(j);
    }
    
    public void roundWinner()
    {
        int top = 0;
        int player = 0;
        for(int i = 0; i < 4; i++)
        {
            if(playedCard[i].rank.ordinal() > top){
                top = playedCard[i].rank.ordinal();
                player = i;
            }
            
        }
        if(player == 0 || player == 2)
        {
            team[0]++;
        }else{
            team[1]++;
        }
        
    }
    
    public void aiMove()
    {
        pos = 10;
        played = 0;
        rand = r.nextInt(4-0);
        for(int i = 1; i <4; i ++){
            ts[i].setTurnOff();
        }
        for(int i = 0; i <3; i ++){
        frame.remove(ps[i]);
        frame.revalidate();
        frame.repaint();
        }
        ts[rand].setTurn();
        for(int i = 1; i <4; i ++){
            if(ts[i].getTurn()){
                playedCard[i] = ts[i].playCard(trump);
                setAIimage(playedCard[i].rank, playedCard[i].suit, pos, ps[i-1]); 
                ts[i].setTurn();played++;
                if(i != 3){
                    ts[i+1].setTurn();
                }
            }pos+=200;
        }
        
    }
    
   
    
    void mouse() throws InterruptedException
    {
        
        labelArray.get(0).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                   Card card = new Card(ts[0].getHand().getCard(0).rank, ts[0].getHand().getCard(0).suit);
                   playedCard[0] = card;
                   ts[0].getHand().remveSingle(card);setNewimage();round();
                }
                }
                });
        
         labelArray.get(1).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                    Card card = new Card(ts[0].getHand().getCard(1).rank, ts[0].getHand().getCard(1).suit);
                    playedCard[0] = card;
                    ts[0].getHand().remveSingle(card);setNewimage();round();
                }
                }
                });
         labelArray.get(2).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                     Card card = new Card(ts[0].getHand().getCard(2).rank, ts[0].getHand().getCard(2).suit);
                     playedCard[0] = card;
                   ts[0].getHand().remveSingle(card);setNewimage();round();
}
                }
                });
         labelArray.get(3).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                     Card card = new Card(ts[0].getHand().getCard(3).rank, ts[0].getHand().getCard(3).suit);
                     playedCard[0] = card;
                   ts[0].getHand().remveSingle(card);setNewimage();round();
                    }
                }
                });
         labelArray.get(4).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                     Card card = new Card(ts[0].getHand().getCard(4).rank, ts[0].getHand().getCard(4).suit);
                     playedCard[0] = card;
                   ts[0].getHand().remveSingle(card);setNewimage();round();
                    }
                }
                });
         labelArray.get(5).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                    Card card = new Card(ts[0].getHand().getCard(5).rank, ts[0].getHand().getCard(5).suit);
                    playedCard[0] = card;
                   ts[0].getHand().remveSingle(card);setNewimage();round();
                    }
                }
                });
        
         labelArray.get(6).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                     Card card = new Card(ts[0].getHand().getCard(6).rank, ts[0].getHand().getCard(6).suit);
                     playedCard[0] = card;
                   ts[0].getHand().remveSingle(card);setNewimage();round();
                    }
                }
                });
         labelArray.get(7).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                     Card card = new Card(ts[0].getHand().getCard(7).rank, ts[0].getHand().getCard(7).suit);
                     playedCard[0] = card;
                   ts[0].getHand().remveSingle(card);setNewimage();round();
                    }
                }
                });
         labelArray.get(8).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                     Card card = new Card(ts[0].getHand().getCard(8).rank, ts[0].getHand().getCard(8).suit);
                     playedCard[0] = card;
                   ts[0].getHand().remveSingle(card);setNewimage();round();
                    }
                }
                });
         labelArray.get(9).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                     Card card = new Card(ts[0].getHand().getCard(9).rank, ts[0].getHand().getCard(9).suit);
                     playedCard[0] = card;
                   ts[0].getHand().remveSingle(card);setNewimage();round();
                    }
                }
                });
         labelArray.get(10).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                    Card card = new Card(ts[0].getHand().getCard(10).rank, ts[0].getHand().getCard(10).suit);
                    playedCard[0] = card;
                   ts[0].getHand().remveSingle(card);setNewimage();round();
                    }
                }
                });
        
         labelArray.get(11).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                     Card card = new Card(ts[0].getHand().getCard(11).rank, ts[0].getHand().getCard(11).suit);
                     playedCard[0] = card;
                   ts[0].getHand().remveSingle(card);setNewimage();round();
                    }
                }
                });
         labelArray.get(12).addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played != 3){
                     Card card = new Card(ts[0].getHand().getCard(12).rank, ts[0].getHand().getCard(12).suit);
                     playedCard[0] = card;setNewimage();round();
                    }
                }
                });
         
         next.addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                {
                    if(played == 3){
                   aiMove();
                    }
                }
                });
    }
}
