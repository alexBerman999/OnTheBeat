package com.onthebeat.gui;

import java.awt.CardLayout;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.onthebeat.Driver;
import com.onthebeat.Score;

public class Frame extends JFrame
{
    String title = "On The Beat";
    JPanel cards;
    public HashMap<String, JPanel> cardMap;
    CardLayout c;
    public Frame() throws FileNotFoundException
    {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("assets/dolphin_16.png").getImage());
        
        cardMap = new HashMap<String, JPanel>();
        JPanel menu = new MainMenuPanel(this);
        cardMap.put(Driver.MENU, menu);
        JPanel tempo = new TempoTapperPanel(this);
        cardMap.put(Driver.TEMPO, tempo);
        JPanel transcribeSettup = new TranscribeSettupPanel(this);
        cardMap.put(Driver.TRANSCRIBE_SETTUP, transcribeSettup);
        JPanel transcribe = new TranscriberPanel();
        cardMap.put(Driver.TRANSCRIBE, transcribe);
        JPanel reviewPanel = new ReviewPanel(Score.read("savename.otb"));
        cardMap.put(Driver.REVIEW, reviewPanel);
        c = new CardLayout();
        cards = new JPanel(c);
        cards.add(menu, Driver.MENU);
        cards.add(tempo, Driver.TEMPO);
        cards.add(transcribeSettup, Driver.TRANSCRIBE_SETTUP);
        cards.add(transcribe, Driver.TRANSCRIBE);
        cards.add(reviewPanel, Driver.REVIEW);
        this.add(cards);
        switchPanel(Driver.MENU);
        this.setVisible(true);
    }
    
    public void switchPanel(String key)
    {
        c.show(cards, key);
        cardMap.get(key).grabFocus();
        this.pack();
    }
}
