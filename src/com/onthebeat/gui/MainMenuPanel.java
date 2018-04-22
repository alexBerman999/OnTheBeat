package com.onthebeat.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.onthebeat.input.MainMenuActionListener;

public class MainMenuPanel extends JPanel
{
    public JLabel title;
    public JButton tempoTapButton, transcribeButton, reviewButton;
    public Frame f;
    public MainMenuPanel(Frame f)
    {
        this.f = f;
        MainMenuActionListener a = new MainMenuActionListener(f, this);
        this.setPreferredSize(new Dimension(400, 400));
        
        title = new JLabel("On The Beat");
        tempoTapButton = new JButton("Tempo Tapper");
        tempoTapButton.addActionListener(a);
        transcribeButton = new JButton("Transcribe");
        transcribeButton.addActionListener(a);
        reviewButton = new JButton("Review");
        reviewButton.addActionListener(a);
        
        this.add(title);
        this.add(tempoTapButton);
        this.add(transcribeButton);
        this.add(reviewButton);
    }
}
