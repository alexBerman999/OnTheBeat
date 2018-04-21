package com.onthebeat.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.onthebeat.input.NoteButtonListener;

public class Frame extends JFrame
{
    String title = "On The Beat";
    public Frame()
    {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel menu = new MainMenuPanel();
        JPanel tempo = new TempoTapperPanel();
        JPanel transcribe = new TranscriberPanel();
        
        this.pack();
        this.setVisible(true);
    }
}
