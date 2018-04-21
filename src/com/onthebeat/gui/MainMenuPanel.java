package com.onthebeat.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel
{
    JLabel title;
    JButton tempoTapButton, transcribeButton;
    public MainMenuPanel()
    {
        this.setPreferredSize(new Dimension(400, 400));
        
        title = new JLabel("On The Beat");
        tempoTapButton = new JButton("Tempo Tapper");
        transcribeButton = new JButton("Transcribe");
        
        this.add(title);
        this.add(tempoTapButton);
        this.add(transcribeButton);
    }
}
